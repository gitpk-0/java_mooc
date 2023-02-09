import java.util.ArrayList;

public class Recipe {

    private String name;
    private int cookTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int cookTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return this.name;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public String getIngredients() {
        String output = "";
        for (String ingredient: ingredients) {
            output = output + "\n" + ingredient;
        }
        return "Ingredients: " + output;
    }

    public String toString() {
        return this.name + ", cooking time: " + cookTime;
    }

    public ArrayList<String> listIngredients() {
        return ingredients;
    }
}
