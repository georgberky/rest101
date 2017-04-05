package de.gb.rest;

import java.util.Optional;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

public class MapDbStore implements Store {

    private static HTreeMap<String, String> map;
    private static HTreeMap<Integer, GotIt> gotIts;
    static {
        DB db = DBMaker.memoryDB().make();
        map = db.hashMap("testHashMap")
                .keySerializer(Serializer.STRING)
                .valueSerializer(Serializer.STRING)
                .createOrOpen();

        gotIts = db.hashMap("gotItsMap")
                .keySerializer(Serializer.INTEGER)
                .valueSerializer(Serializer.ELSA)
                .createOrOpen();

        map.put("plain", "Got it!");
    }


    @Override
    public String loadPlain() {
        return map.get("plain");
    }

    @Override
    public void save(int id, GotIt gotIt) {
        gotIts.put(id, gotIt);
    }

    @Override
    public Optional<GotIt> load(int id) {
        return Optional.ofNullable(gotIts.get(id));
    }
}
