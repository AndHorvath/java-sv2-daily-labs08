package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipeA;
    Recipe recipeB;

    @BeforeEach
    void setUp() {
        recipeA = new Recipe("pasta");
        recipeB = new Recipe("cake", "chocolate cake");
    }

    @Test
    void getNameTest() {
        assertEquals("pasta", recipeA.getName());
        assertEquals("cake", recipeB.getName());
    }

    @Test
    void getDescriptionTest() {
        assertNull(recipeA.getDescription());
        assertEquals("chocolate cake", recipeB.getDescription());
    }

    @Test
    void getIngredientsTest() {
        assertEquals(0, recipeA.getIngredients().size());
        assertEquals(0, recipeB.getIngredients().size());
    }

    @Test
    void addIngredientTest() {
        recipeA.addIngredient("noodles");
        recipeB.addIngredient("sugar", "cacao", "butter");

        assertEquals(Arrays.asList("noodles"), recipeA.getIngredients());
        assertEquals(Arrays.asList("sugar", "cacao", "butter"), recipeB.getIngredients());
    }
}