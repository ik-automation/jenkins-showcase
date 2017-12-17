package yakuramori.api;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GadgetInMemoryStorageTest {

    private GadgetInMemoryStorage storage;

    @Before public void
    initialize() {
        storage = new GadgetInMemoryStorage();
        storage.init();
    }

    @Test public void
    should_have_correct_size() {
        assertThat(storage.getGadgets().size(), is(5));
    }

    @Parameters({
            "1857",
            "1858",
            "1861"
    })
    @Test public void
    should_have_remove_from_storage_by_id(Integer id) {
        int sizeBefore = storage.getGadgets().size();
        storage.removeById(id);
        int storageAfter = storage.getGadgets().size();
        assertThat(sizeBefore, is(storageAfter + 1));
    }
}
