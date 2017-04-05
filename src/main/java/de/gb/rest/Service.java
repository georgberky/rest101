package de.gb.rest;

import java.util.Optional;

public interface Service {
    String loadPlain();

    void saveMyGotIt(GotIt gotIt);
    Optional<GotIt> getMyGotIt(int id);
}
