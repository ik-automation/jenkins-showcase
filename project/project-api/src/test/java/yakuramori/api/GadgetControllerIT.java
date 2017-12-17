package yakuramori.api;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class GadgetControllerIT {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired MockMvc mockMvc;

    @Parameters({
            "1857, LG Nexus 5, SMARTPHONE",
            "1858, Macbook Air, LAPTOP",
            "1861, Samsung Galaxy Tab 2, TABLET"
    })
    @Test public void
    should_retrieve_gadget_by_id(Integer id, String name, String type) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gadgets/" + id))
               .andExpect(status().is(200))
               .andExpect(content().contentTypeCompatibleWith(MediaType
                                                                      .APPLICATION_JSON))
               .andExpect(jsonPath("$.id", is(id)))
               .andExpect(jsonPath("$.name", is(name)))
               .andExpect(jsonPath("$.type", is(type)));
    }

    @Parameters({
            "1857",
            "1859"
    })
    @Test public void
    shoud_have_remove_gadget_by_id(Integer id) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/gadgets/" + id))
               .andExpect(status().is(200));

        mockMvc.perform(MockMvcRequestBuilders.get("/gadgets/" + id))
               .andExpect(status().is(200))
               .andExpect(content().string(""));
    }
}
