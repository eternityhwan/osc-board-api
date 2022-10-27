package com.osckorea.board.ioc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Chef {

    // 세프 식재료 공장 알고 있다
    private IngredientFactory ingredientFactory;

    // 세프가 식제료 공장과 협업하기 위한 DI
    public Chef(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public String cook(String menu) {

        // DI 외부에서 객체를 주입하기
        IngredientFactory ingredientFactory = new IngredientFactory();
        // 재료 준비
        Ingredient ingredient = ingredientFactory.get(menu);

        // Pork pork = new Pork("meat");

        // 요리 반환
        return ingredient.getName() + "으로 만든 " + menu;

    }
}
