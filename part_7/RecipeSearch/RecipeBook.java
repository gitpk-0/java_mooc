import java.util.ArrayList;

public class RecipeBook {

    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void getRecipeBook() {
        System.out.println("Recipes: ");
        for (Recipe recipe: recipes) {
            System.out.println(recipe);
        }
    }

    public void getRecipeByName(String name) {
        System.out.println("Recipes: ");
        for (Recipe recipe: recipes) {
            if (recipe.getRecipeName().contains(name)) {
                System.out.println(recipe);
            }
        }
    }

    public void getRecipeByCookTime(int timeToCook) {
        System.out.println("Recipes: ");
        for (Recipe recipe: recipes) {
            if (recipe.getCookTime() <= timeToCook) {
                System.out.println(recipe);
            }
        }
    }

    public void getRecipeByIngredient(String ingredient) {
        System.out.println("Recipes: ");
        for (Recipe recipe: recipes) {
            if (recipe.listIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
}
