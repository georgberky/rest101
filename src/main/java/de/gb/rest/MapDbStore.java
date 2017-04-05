package de.gb.rest;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

public class MapDbStore implements Store {

    private static HTreeMap<String, String> map;
    static {
        DB db = DBMaker.memoryDB().make();
        map = db.hashMap("testHashMap", Serializer.STRING, Serializer.STRING).createOrOpen();

        map.put("plain", "Got it!");
    }

    @Override
    public String loadPlain() {
        return map.get("plain");
    }
}
