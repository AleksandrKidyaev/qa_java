package com.example;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class CatTest {

    Feline feline = new Feline();
    Cat cat = new Cat(feline);

    @Test
    public void catGetSoundTest() {
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
        //Делал намеренно по разному в разных тестах. Где-то сразу в ассерте ожидаемый, где-то сначала объявил переменную с ним.
    }

    @Test
    public void catGetFoodTest() {
        //Также, вместо try catch, тут (как и в других тестах на методы с исключениями) возможен вариант public void getFoodTest() throws Exception {
        //Он бы тоже сработал.
        try {
            List<String> actualFoodReturn = cat.getFood();
            //List<String> notExpected = List.of("Трава", "Различные растения");
            List<String> expectedFoodReturn = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodReturn, actualFoodReturn);
            //assertNotEquals(notExpected, actual);
            //Закомментированные строки в блоке try - рассматривал вариант добавить и их плюсом к тому что есть, но это было бы избыточно.
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }
        /*
        Также для catch я рассматривал вариант:
        catch (Exception e) {
        e.printStackTrace();
        }
        Он бы тоже работал. В некоторых следующих тестах использовал этот вариант.
         */

    }
}