package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    Feline testFeline = new Feline();
    Lion testLion;
    {
        try {
            testLion = new Lion(testFeline, "Самка");
        } catch (Exception lionSexException) {
            lionSexException.printStackTrace();
        }
    }


    @Test
    public void lionGetKittensWillReturnOneTest() {
            int actualKittensCount = testLion.getKittens();
            int expectedKittensCount = 1;
            assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void lionGetFoodWillReturnMeatListTest() {
        try {
            List<String> actualFoodReturn = testLion.getFood();
            List<String> expectedFoodReturn = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expectedFoodReturn, actualFoodReturn);
        }
        catch (Exception animalFoodException) {
            Assert.fail("Exception " + animalFoodException);
        }
    }

    @Mock
    Feline mockFeline;
    //Использовал мок, т.к. исключению не важен null в первом параметре
    @Test
    public void lionSexExceptionMessageHaveCorrectTextTest() {
        try {
            Lion lionWithIncorrectSex = new Lion(mockFeline, "Некорректный пол");
        }
        catch (Exception lionSexException) {
            String actualExceptionText = lionSexException.getMessage();
            String expectedExceptionText = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedExceptionText, actualExceptionText);
        }
    }

    /*
    Другой вариант проверки исключения был такой:
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void whenExceptionThrown_thenRuleIsApplied() throws Exception {
        Feline f = new Feline();
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion l = new Lion(testFeline, "Некорректный тест");
    }

    Он тоже отрабатывал успешно. Но у ExpectedException.none(); - "none" зачеркивает, устаревший.
    Поэтому показался этот вариант не "красивым".
     */
}