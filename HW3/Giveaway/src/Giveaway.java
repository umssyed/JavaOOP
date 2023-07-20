/*
COLLABORATION STATEMENT:
I worked on the homework assignment alone, using only course materials.
*/
import java.util.Scanner;

public class Giveaway {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //Define the Giveaway grid
        String[][] grid = {
                {"x", "x", "StuffedPython", "x", "CSalt"},
                {"hAIrspray", "x", "x", "x", "x"},
                {"x", "x", "x", "JavaBeans", "x"},
                {"x", "RustedMetal", "SwiftShoes", "x", "x"},
                {"FuRniture", "x", "x", "GroovyGear", "RadiantRuby"}
        };

        //Welcome the user
        System.out.println("Welcome to the 1331 Giveaway!\n");

        //Define some variables
        // For acceptable input from user:
        // 0 - Exit, 1 - N, 2 - Y, negative number is invalid response
        // A variable gridIsEmpty is used to check if grid is empty
        int acceptableInputFromPrompt = 0;
        boolean gridIsEmpty = checkIfEmptyGrid(grid);

        //Continue prompting the user until grid is empty
        while (!gridIsEmpty) {
            acceptableInputFromPrompt = promptUserToTakeItem(userInput, grid);
            if (acceptableInputFromPrompt == 0) {
                // 0 - Exit
                break;
            }
            //After each prompt, check if grid is empty. Exit gracefully if grid is empty.
            if (checkIfEmptyGrid(grid)) {
                System.out.println("Sorry, we have no more items!");
                break;
            }
        }
    }

    //This function prints the grid
    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
    }

    //This function updates the grid with 'x' when user takes an item from the grid
    public static void updateGrid(int loc1, int loc2, String[][] grid) {
        grid[loc1][loc2] = "x";
    }

    //This function checks the entire grid if it is empty
    public static boolean checkIfEmptyGrid(String[][] grid) {
        boolean isEmpty = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j].equals("x")) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    //This function prompts the user to take an item
    //Depending on the input from the user, the function either repeats until
    //an acceptable prompt is provided, or exits the program, or goes to the
    //next person in line or calls another method to prompt user to select
    //item from the grid
    public static int promptUserToTakeItem(Scanner userInput, String[][] grid) {
        System.out.print("Would you like to take an item? [Y]es, [N]o, or [E]xit\n");
        String input = userInput.next();
        int result;
        Boolean validUserSelection = false;

        //Identify next step based on user's input
        if (input.equals("E")) {
            System.out.println("Have a good day!");
            result = 0;
            return result;
        } else if (input.equals("N")) {
            System.out.println("Next person in line!\n");
            result = 1;
            return result;
        } else if (input.equals("Y")) {
            System.out.println();
            printGrid(grid);
            System.out.println();
            result = 2;
            while (!validUserSelection) {
                validUserSelection = handleUserSelection(userInput, grid);
            }
            return result;
        } else {
            System.out.println("\nPlease input 'Y', 'N', or 'E'.\n");
            result = -1;
            return result;
        }
    }

    //This function handles user's selection by asking what item they are interested
    //in. The function checks for invalid location provided, whether an item
    //exists in the location requested, or calls the update grid when user
    //requests a valid item.
    public static Boolean handleUserSelection(Scanner userInput, String[][] grid) {
        System.out.println("What item are you interested in taking?");
        int gridRows = grid.length;
        int gridCols = grid[0].length;
        int inputLoc1 = userInput.nextInt();
        int inputLoc2 = userInput.nextInt();

        if (inputLoc1 >= gridRows || inputLoc2 >= gridCols || inputLoc1 < 0 || inputLoc2 < 0) {
            System.out.println("\nLocation does not exist.\n");
            return false;
        } else {
            if (grid[inputLoc1][inputLoc2].equals("x")) {
                System.out.println("\nThere is no item in this location.\n");
                return false;
            }
            System.out.println("\nYou successfully took the " + grid[inputLoc1][inputLoc2] + "!\n");
            updateGrid(inputLoc1, inputLoc2, grid);
            printGrid(grid);
            System.out.println();
            return true;
        }
    }
}
