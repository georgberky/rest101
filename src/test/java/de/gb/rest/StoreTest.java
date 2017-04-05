package de.gb.rest;

import org.junit.Before;
import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class StoreTest {

    private HTreeMap<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        DB db = DBMaker.memoryDB().make();
        map = db.hashMap("testHashMap", Serializer.STRING, Serializer.INTEGER).createOrOpen();
    }

    @Test
    public void inMemoryMap() throws Exception {
        map.put("foo", 42);

        assertThat(map, hasEntry("foo", 42));
    }
}
