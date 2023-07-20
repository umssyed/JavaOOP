import java.util.Scanner;

public class Dump {
    public static void main (String[] args) {
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

        //Define some variables and a Scanner object
        Scanner userInput = new Scanner(System.in);
        String input;
        boolean acceptableInputFromPrompt = false;
        boolean gridIsEmpty = checkIfEmptyGrid(grid);

        //Continue prompting the user until grid is empty
        while (acceptableInputFromPrompt == false || gridIsEmpty == false) {
            acceptableInputFromPrompt = promptUserToTakeItem(userInput, grid);
            //After each prompt, check if grid is empty. Exit gracefully if grid is empty.
            if(checkIfEmptyGrid(grid)) {
                System.out.println("Sorry, we have no more items!");
                callToExit();
            }
        }
    }

    //This function prints the grid
    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|");
            for(int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
    }

    //This function is called to exit the program from any loop
    public static void callToExit() {
        System.exit(0);
    }

    //This function updates the grid with 'x' when user takes an item from the grid
    public static void updateGrid (int loc1, int loc2, String[][] grid) {
        grid[loc1][loc2] = "x";
    }

    //This function checks the entire grid if it is empty
    public static boolean checkIfEmptyGrid (String[][] grid) {
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
    public static Boolean promptUserToTakeItem(Scanner userInput, String[][] grid) {
        System.out.print("Would you like to take an item? [Y]es, [N]o, or [E]xit\n");
        String input = userInput.next();
        Boolean validUserSelection = false;

        //Identify next step based on user's input
        if (input.equals("E")) {
            System.out.println("Have a good day!");
            callToExit();
        }
        else if (input.equals("N")) {
            System.out.println("Next person in line!\n");
            return false;
        }
        else if (input.equals("Y")) {
            System.out.println();
            printGrid(grid);
            System.out.println();
            while (validUserSelection == false) {
                validUserSelection = handleUserSelection(userInput, grid);
            }
            return true;
        } else {
            System.out.println("\nPlease input 'Y', 'N', or 'E'.\n");
            return false;
        }
        return false;
    }

    //This function handles user's selection by asking what item they are interested
    //in. The function checks for invalid location provided, whether an item
    //exists in the location requested, or calls the update grid when user
    //requests a valid item.
    public static Boolean handleUserSelection (Scanner userInput, String[][] grid) {
        System.out.println("What item are you interested in taking?");
        int gridRows = grid.length;
        int gridCols = grid[0].length;
        //System.out.println("grid Rows: " + gridRows + ", grid Cols: " + gridCols);
        int inputLoc1 = userInput.nextInt();
        int inputLoc2 = userInput.nextInt();

        if (inputLoc1 >= gridRows || inputLoc2 >= gridCols) {
            //System.out.println("1");
            System.out.println("\nLocation does not exist.\n");
            return false;
        }
        else {
            //System.out.println("2");
            if (grid[inputLoc1][inputLoc2].equals("x")){
                //System.out.println("3");
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
