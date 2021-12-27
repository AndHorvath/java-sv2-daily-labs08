package day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {

    // --- attributes ---------------------------------------------------------

    private String name;
    private String description;
    private List<String> ingredients;

    // --- constructors -------------------------------------------------------

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<String> getIngredients() { return ingredients; }

    // --- public methods -----------------------------------------------------

    public void addIngredient(String ingredient, String... furtherIngredients) {
        ingredients.add(ingredient);
        ingredients.addAll(Arrays.asList(furtherIngredients));
    }
}