package yakuramori.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import yakuramori.api.domain.GadgetDto;
import yakuramori.api.domain.GadgetType;

@Service
public class GadgetService {

    @Autowired
    private GadgetInMemoryStorage storage;

    public Collection<GadgetDto> searchGadgets(Integer top, Integer skip) {
        Iterator<GadgetDto> iterator = storage.getGadgets().values().iterator();
        if (Objects.nonNull(skip)) {
            for (int i = 0; i < skip; i++) { iterator.next(); }
        }
        List<GadgetDto> result = new ArrayList<GadgetDto>();
        for (int i = 0; (top == null || i < top) && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }
        return result;
    }

    public GadgetDto getGadget(Integer id) {
        return storage.getGadgets().get(id);
    }

    public Integer addGadget(GadgetDto gadget) {
        if (gadget == null || !isValidType(gadget)) { return null; }

        Set<Integer> gadgetIds = storage.getGadgets().keySet();
        Integer newId = Collections.max(gadgetIds) + 1;
        gadget.setId(newId);
        gadget.setUpdatedDate(null);
        gadget.setCreatedDate(new Date());

        storage.getGadgets().put(newId, gadget);
        return newId;
    }

    private boolean isValidType(GadgetDto gadget) {
        GadgetType type = gadget.getType();
        return type != null && type != GadgetType.BOOK_READER;
    }

    public boolean removeGadget(Integer id) {
        return storage.removeById(id);
    }
}
