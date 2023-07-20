/*
COLLABORATION STATEMENT:
In order to help learn course concepts, I worked on the homework by myself and consulted related material
that can be found at www.stackoverflow.com.
*/

public class PrimitiveOperations {
    public static void main(String[] args) {
        //Declare and initialize two variables
        int num = 4;
        double floatingPointNum = 10.0;
        System.out.println(num);
        System.out.println(floatingPointNum);

        //Multiply the above two together
        double multiple = floatingPointNum * num;
        System.out.println(multiple);

        //Casting to convert integer to floating-point value
        double castedNum = (double) num;
        System.out.println(castedNum);

        //Casting to convert floating-point value to integer
        int castedFloatingPointNum = (int) floatingPointNum;
        System.out.println(castedFloatingPointNum);

        //Declaring a char variable
        char character = 'G';
        System.out.println(character);

        //Changing the letter to lowercase
        char lowerCharacter; //declare lower character variable
        int upperASCII = (int) character; //Find ASCII num for upper case
        int lowerASCII = upperASCII + 32; //Find lower case ASCII num by adding 32
        lowerCharacter = (char) lowerASCII; //Cast the int to character
        System.out.println(lowerCharacter);

    }
}