/*
COLLABORATION STATEMENT:
I worked on the homework assignment alone, using only course materials.
*/

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        //Print out list of operations
        System.out.println("List of operations: add subtract multiply divide alphabetize");

        //Prompt for entering operation
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an operation: ");
        String userOpr = input.next().toLowerCase();
        

        switch (userOpr) {
            case "add":
                //System.out.println("User entered: " + userOpr);
                System.out.println("Enter two integers: ");
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                System.out.println("Answer: " + (num1 + num2));
                break;

            case "subtract":
                System.out.println("Enter two integers: ");
                int num3 = input.nextInt();
                int num4 = input.nextInt();
                System.out.println("Answer: " + (num3 - num4));
                break;

            case "multiply":
                System.out.println("Enter two doubles:");
                double num5 = input.nextDouble();
                double num6 = input.nextDouble();
                System.out.printf("Answer: %.2f\n", (num5 * num6));
                break;

            case "divide":
                System.out.println("Enter two doubles: ");
                double num7 = input.nextDouble();
                double num8 = input.nextDouble();

                //If divisor is 0, terminate the program
                if (num8 == 0) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.printf("Answer: %.2f\n", (num7 / num8));
                break;

            case "alphabetize":
                System.out.println("Enter two words: ");
                String word1 = input.next();
                String word2 = input.next();
                if (word1.toLowerCase().compareTo(word2.toLowerCase()) < 0) {
                    System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                } else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) {
                    System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                } else {
                    System.out.println("Answer: Chicken or Egg.");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }

    }
}