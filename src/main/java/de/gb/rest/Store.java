package de.gb.rest;

import java.util.Optional;

public interface Store {
    String loadPlain();

    void save(int id, GotIt gotIt);
    Optional<GotIt> load(int id);
}
