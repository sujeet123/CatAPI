package com.sujeetkumar.catapp.view.common.events;

import com.squareup.otto.Bus;
import com.sujeetkumar.catapp.common.domain.Cat;


public class CatLoadedEvent implements VoteCatEvent {

    private Cat cat;
    private Bus bus;

    public CatLoadedEvent(Cat cat, Bus bus) {
        this.cat = cat;
        this.bus = bus;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public void executeEvent(String source) {
        bus.post(this);
    }
}
