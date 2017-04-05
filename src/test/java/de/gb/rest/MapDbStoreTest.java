package de.gb.rest;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MapDbStoreTest {

    private MapDbStore store;

    @Before
    public void setUp() throws Exception {
        store = new MapDbStore();
    }

    @Test
    public void newStoreHasPlain() throws Exception {
        String plain = store.loadPlain();

        assertThat(plain, equalTo("Got it!"));
    }
}
