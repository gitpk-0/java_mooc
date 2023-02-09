import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private RecipeBook recipeBook;

    public TextUI(Scanner scanner, RecipeBook recipeBook) {
        this.scanner = scanner;
        this.recipeBook = new RecipeBook();
    }


    public void start() {
        int loop = 0;
        System.out.println("File to read: ");
        String file = scanner.nextLine();

        try (Scanner reader = new Scanner(Paths.get(file))) {

            // Read recipes and create book of recipes
            int count = 0;
            String name = "";
            int cookTime = 0;
            ArrayList<String> ingredients = new ArrayList<>();

            while (reader.hasNextLine()) {
                String row = reader.nextLine();

                if (count == 0) { // recipe name
                    name = row;
                }

                if (count == 1) { // recipe cookTime
                    cookTime = Integer.valueOf(row);
                }

                if ((count > 1) && (!(row.equals("")))) { // recipe ingredients
                    ingredients.add(row);
                }
                count++;

                if (row.equals("") || (!(reader.hasNextLine()))) {
                    // create new recipe and add to recipeBook
                    Recipe recipe = new Recipe(name, cookTime, ingredients);
                    recipeBook.add(recipe);

                    // reset variables
                    count = 0;
                    name = "";
                    cookTime = 0;
                    ingredients = new ArrayList<>();
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        while (true) {
            if (loop == 0) {
                System.out.println();
                System.out.println("Commands: ");
                System.out.println("list - lists the recipes");
                System.out.println("stop - stops the program");
                System.out.println("find name - searches recipes by name");
                System.out.println("find cooking time - searches recipes by cooking time");
                System.out.println("find ingredient - searches recipes by ingredient");
                loop++;
            }
            System.out.println();
            System.out.println("Enter command: ");
            String command = scanner.nextLine();

            /* commands sections */
            if (command.equals("stop")) { // stop program
                break;
            }

            if (command.equals("list")) { // list out recipes
                System.out.println();
                recipeBook.getRecipeBook();
            }

            if (command.equals("find name")) {
                System.out.println("Searched word: ");
                String recipeName = scanner.nextLine();

                recipeBook.getRecipeByName(recipeName);
            }

            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int timeToCook = Integer.valueOf(scanner.nextLine());

                recipeBook.getRecipeByCookTime(timeToCook);
            }

            if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingr = scanner.nextLine();

                recipeBook.getRecipeByIngredient(ingr);
            }
        }
    }
}
