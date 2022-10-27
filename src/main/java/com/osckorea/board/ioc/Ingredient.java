package com.osckorea.board.ioc;

import lombok.Getter;
import lombok.NoArgsConstructor;


public abstract class Ingredient {

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
