import java.util.Scanner;

public class Giveaway {
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
        


        



        boolean testOutput = false;

        
        while (testOutput == false) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Would you like to take an item? [Y]es, [N]o, or [E]xit\n");
            String testInput = userInput.next();
            if (testInput.equals("E")) {
                System.out.println("Have a good day!");
                testOutput = true;
            } else {
                testOutput = false;
            }
        }

    }


}
