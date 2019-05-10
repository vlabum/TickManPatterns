package ru.vlabum.study.tickman;

import java.util.HashSet;
import java.util.Set;

public class SetSeats {

    private Set<Long> set = new HashSet<>();

    public void add (final Long id) {
        set.add(id);
    }

    public void remove(final Long id) {
        set.remove(id);
    }

    public boolean contains(final Long id) {
        return set.contains(id);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }
}
