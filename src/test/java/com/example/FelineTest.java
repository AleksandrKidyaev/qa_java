package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    Feline feline = new Feline();
    /*
    Объект feline сделал тут, т.к. он используется везде аналогично,
    в данной ситуации нет смысла создавать отдельно в каждом тесте
     */
    private final int checkedNumber;
    private final int expectedNumber;

    public FelineTest(int checkedNumber, int expectedNumber) {
        this.checkedNumber = checkedNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getNumberData() {
        return new Object[][] {
                {1, 1},
                {1, 1},
                {2, 2},
                {7, 7},
                {34, 34},
                {569, 569},
        };
    }

    @Test
    public void felineEatMeatTest() {
        try {
            List<String> actual = feline.eatMeat();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, actual);
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    public void felineGetFamilyTest() {
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }

    @Test
    public void felineGetKittensWithoutArgumentTest() {
        //Этот тест отдельно, чтобы проверить, что без аргументов метод getKittens() действительно вернет "1".
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void felineGetKittensWithParameters() {
        int actual = feline.getKittens(checkedNumber);
        assertEquals(expectedNumber, actual);
    }
}