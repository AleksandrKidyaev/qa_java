package com.example;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class CatTest {

    Feline feline = new Feline();
    Cat cat = new Cat(feline);

    @Test
    public void getSoundTest() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actual = cat.getFood();
        List<String> notExpected = List.of("Трава", "Различные растения");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
        assertNotEquals(notExpected, actual);


    }
}