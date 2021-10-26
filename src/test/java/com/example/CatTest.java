package com.example;
import org.junit.Test;
import static org.junit.Assert.*;


public class CatTest {

    @Test
    public void getSoundTest() {
        Feline fel = new Feline();
        Cat cat = new Cat(fel);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() {

    }
}