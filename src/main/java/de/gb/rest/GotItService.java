package de.gb.rest;

public class GotItService implements Service {

    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String loadPlain() {
        return store.loadPlain();
    }
}
