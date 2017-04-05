package de.gb.rest;

import java.io.Serializable;
import java.util.Objects;

public class GotIt implements Serializable {

    final private String message;

    public GotIt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GotIt gotIt = (GotIt) o;
        return Objects.equals(message, gotIt.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return String.format("GotIt[%s]", message);
    }
}
