package yakuramori.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import yakuramori.api.domain.GadgetData;
import yakuramori.api.domain.GadgetDto;

@RestController
@RequestMapping(value = "/gadgets", produces = APPLICATION_JSON_VALUE)
public class GadgetController {
    @Autowired private GadgetService service;

    @RequestMapping(method = RequestMethod.GET)
    public GadgetData searchGadgets(@RequestParam("$top") Integer top,
                                    @RequestParam("$skip") Integer skip) {
        Collection<GadgetDto> gadgets = service.searchGadgets(top, skip);
        return new GadgetData(gadgets);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GadgetDto getGadget(@PathVariable(value = "id", required = false) Integer id) {
        if (Objects.nonNull(id)) {
            return service.getGadget(id);
        } else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addGadget(@RequestBody GadgetDto gadget) {
        Integer id = service.addGadget(gadget);
        return String.valueOf(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeGadget(@PathVariable("id") Integer id) {
        service.removeGadget(id);
    }
}
