import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        //Print out list of operations
        System.out.println("List of operations: add subtract multiply divide alphabetize");

        //Prompt for entering operation
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an operation: ");
        String userOpr = input.next().toLowerCase();
        

        //Check for valid operation request
        if (userOpr.equals("add") || userOpr.equals("subtract") || 
            userOpr.equals("multiply") || userOpr.equals("divide") || 
            userOpr.equals("alphabetize")) 
            {
                System.out.print("User entered: " + userOpr);

                //For userOp add, subtract, multiply, divide - use Switch Statements
                
                int answerInt;
                switch (userOpr) {
                    case "add":
                        System.out.print("Enter two integers: ");
                        int num1 = input.nextInt();
                        int num2 = input.nextInt();
                        //answerInt = num1 + num2;
                        System.out.println("Answer: " + answerInt);
                        break;
                    case "subtract":
                        System.out.print("Enter two integers: ");
                        int num1 = input.nextInt();
                        int num2 = input.nextInt();
                        //answerInt = num1 - num2;
                        System.out.println("Answer: " + answerInt);
                        break;
                }
                
                




            }
        //If invalid operation requested, terminate program
        else {
            System.out.println("Invalid input entered. Terminating...");
        }
    }
}