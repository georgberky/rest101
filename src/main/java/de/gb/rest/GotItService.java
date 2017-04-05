package de.gb.rest;

import java.util.Optional;

public class GotItService implements Service {

    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String loadPlain() {
        return store.loadPlain();
    }

    @Override
    public void saveMyGotIt(GotIt gotIt) {
        store.save(1, gotIt);
    }

    @Override
    public Optional<GotIt> getMyGotIt(int id) {
        return store.load(id);
    }
}
