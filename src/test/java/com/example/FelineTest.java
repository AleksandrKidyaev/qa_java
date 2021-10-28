package com.example;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    Feline testFeline;
    /*
    Рассматривал также вариант сразу тут написать Feline testFeline = new Feline();, ведь объект для всех тестов
    используется одинаковый и не изменяется. Таким образом сделал в не параметризированном тесте на Льва.
    */

    @Test
    public void felineEatMeatWillReturnMeatListTest() {
        testFeline = new Feline();
        try {
            List<String> actualFoodReturn = testFeline.eatMeat();
            List<String> expectedFoodReturn = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodReturn, actualFoodReturn);
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    public void felineGetFamilyWillReturnFelineTest() {
        testFeline = new Feline();
        String actualFamilyReturn = testFeline.getFamily();
        String expectedFamilyReturn = "Кошачьи";
        assertEquals(expectedFamilyReturn, actualFamilyReturn);
    }

    @Test
    public void felineGetKittensWithoutArgumentWillReturnOneTest() {
        /*
        Этот тест отдельно, от того, что в классе FelineParameterizedTest,
        чтобы проверить, что без аргументов метод getKittens() действительно вернет "1".
        */
        testFeline = new Feline();
        int actualKittensCOunt = testFeline.getKittens();
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, actualKittensCOunt);
    }

}