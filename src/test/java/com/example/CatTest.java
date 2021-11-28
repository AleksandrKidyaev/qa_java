package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline mockFeline;

    @Test //Использовал мок, т.к. параметр конструктора кошки никак не повлияет на результат метода getFood
    public void catGetSoundWillReturnMyauTest() {
        Cat testCatWithMock = new Cat(mockFeline);
        String actualCatSound = testCatWithMock.getSound();
        String expectedCatSound = "Мяу";
        assertEquals(expectedCatSound, actualCatSound);

    }

    @Test
    public void catGetFoodWillReturnMeatListTest() {
        Feline testFeline = new Feline();
        //А тут, соответственно, мок использовать нельзя, т.к. predator получится null и метод не выполнится
        Cat testCat = new Cat(testFeline);
        /*
        Также, вместо try catch, тут (как и в других тестах на методы (или конструкторы) с исключениями)
        рассматривал вариант public void getFoodTest() throws Exception {
        Он бы тоже сработал.
         */
        try {
            List<String> actualFoodReturn = testCat.getFood();
            List<String> expectedFoodReturn = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodReturn, actualFoodReturn);
        }
        catch (Exception animalFoodException) {
            Assert.fail("Exception " + animalFoodException);
        }
        /*
        Также для catch я рассматривал вариант:
        catch (Exception e) {
        e.printStackTrace();
        }
        Он бы тоже работал.
         */
    }
}