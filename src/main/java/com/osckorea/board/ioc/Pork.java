package com.osckorea.board.ioc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;


@Getter
public class Pork extends Ingredient {

    public Pork(String name) {
        super(name);
    }
}

