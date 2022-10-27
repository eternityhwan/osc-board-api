//package com.osckorea.board.ioc;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ChefTest {
//
//    @Autowired // IOC 컨테이너에 등록함
//    IngredientFactory ingredientFactory;
//
//    @Test
//    void cook() {
//        // 준비
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
//        String menu = "noodle";
//
//        // 수행
//        String food = chef.cook(menu);
//
//        // 예상
//        String expected = "pasta";
//
//        // 검증
//        assertEquals(expected, food);
//        System.out.println(food);
//    }
//
//    @Test
//    void crispy_chicken() {
//
////        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
//        String menu = "크리스피 치킨";
//
//        // 수행
//        String food = chef.cook(menu);
//
//        // 예상
//        String expected = "국내산 10호 닭으로 만든 크리스피 치킨";
//
//        // 검증
//        assertEquals(expected, food);
//        System.out.println(food);
//    }
//}

//    @Test
//    void cook2() {
//    // 준비
//    Chef chef = new Chef();
//    String menu = "스테이크";
//
//    // 수행
//    String food = chef.cook(menu);
//
//    // 예상
//    String expected = "meat로 만든 noodle";
//
//    // 검증
//    assertEquals(expected, food);
//        System.out.println(food);
//    }
