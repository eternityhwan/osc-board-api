package com.osckorea.board.ioc;

import org.springframework.stereotype.Component;

@Component // 해당 클래스를 객체로 만들고, 이를 IOC 컨테이너에 등록하는 어노테이션
public class IngredientFactory {


    public Ingredient get(String menu) {
        switch (menu) {
            case "noodle":
                return new Pork("요호 파스타");

            case "스테이크" :
                    return new Beef("꽃등심");
            case "크리스피 치킨" :
                return new Chicken("국내산 10호 닭");
            default:
                return null;
        }
    }
}
