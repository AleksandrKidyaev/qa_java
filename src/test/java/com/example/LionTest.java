package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    Feline feline = new Feline();

    Lion lion;
    /*
    Тут объект сделан заранее и с фиксированным полом,
    чтобы не создавать его потом два раза для двух оставшихся методов, не использующих параметризацию.
    Рассматривал и другой вариант: внутри теста lionGetFoodTest создать объект с одним полом,
    а внутри теста lionGetKittensTest создать объект с другим полом.
    Но не увидел в этом смысла в конкретной текущей ситуации.
     */
    {
        try {
            lion = new Lion(feline, "Самец");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String checkedSex;
    private final boolean expectedManeOutcome;

    public LionTest(String checkedSex, boolean expectedManeOutcome) {
        this.checkedSex = checkedSex;
        this.expectedManeOutcome = expectedManeOutcome;
    }

    @Parameterized.Parameters
    public static Object[][] getSexAndExpectedManeData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionGetKittensTest() {
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void lionDoesHaveManeParameterizedTest() {
        try {
            Lion parameterizedLion = new Lion(feline, checkedSex);
            //А тут уже использовал новый объяект, т.к. lion не подошел бы из-за зафиксированного пола.
            boolean actual = parameterizedLion.doesHaveMane();
            assertEquals(expectedManeOutcome, actual);
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }

    @Test
    public void lionGetFoodTest() {
        try {
            List<String> actual = lion.getFood();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expected, actual);
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }
    }
}