package yakuramori.api;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import yakuramori.api.domain.GadgetDto;
import yakuramori.api.domain.GadgetType;
import yakuramori.api.domain.Owner;

@Component
@Scope(value = "singleton")
public class GadgetInMemoryStorage {
    private Map<Integer, GadgetDto> gadgets = new HashMap<Integer, GadgetDto>();

    @PostConstruct protected void
    init() {
        initGadget(1857, GadgetType.SMARTPHONE, "LG Nexus 5", "Lisa", 8);
        initGadget(1858, GadgetType.LAPTOP, "Macbook Air", "Homer", 38);
        initGadget(1859, GadgetType.LAPTOP, "Alienware 17 R3", "Bart", 10);
        initGadget(1860, GadgetType.SMART_WATCH, "Apple Watch", "Marge", 36);
        initGadget(1861, GadgetType.TABLET, "Samsung Galaxy Tab 2", "Maggie", 2);
    }

    private void initGadget(Integer id, GadgetType type, String gadgetName, String name,
                            Integer age) {
        GadgetDto gadget = new GadgetDto();

        gadget.setId(id);
        gadget.setType(type);
        gadget.setName(gadgetName);
        gadget.setOwner(new Owner(name,
                                  "Simpson",
                                  age,
                                  Collections.singletonList("Mr.Burns' slave")));
        gadget.setCreatedDate(new Date());

        this.gadgets.put(id, gadget);
    }

    public Map<Integer, GadgetDto> getGadgets() {
        return Collections.unmodifiableMap(this.gadgets);
    }

    public boolean removeById(Integer id) {
        return Objects.nonNull(gadgets.remove(id));
    }
}
