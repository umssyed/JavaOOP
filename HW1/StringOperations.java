/*
COLLABORATION STATEMENT:
In order to help learn course concepts, I worked on the homework by myself and consulted related material
that can be found at www.stackoverflow.com.
*/
public class StringOperations {
    public static void main(String[] args) {
        //Create new string object and assign my name
        String myName = new String("Muhammad Uzair Shahid Syed");
        System.out.println(myName);

        //Replace first letter and last letter
        String firstLetterReplaced = "A" + myName.substring(1, myName.length());
        String lastLetterReplaced = firstLetterReplaced.substring(0, myName.length() - 1) + "Z";
        System.out.println(lastLetterReplaced);

        //Declare a web address
        String webAddress = "www.google.com";
        System.out.println(webAddress);

        //Concatenate integer 1331 to the end of name
        String removeFist = webAddress.replace("www.", "");
        String removeLast = removeFist.replace(".com", "");
        String name = removeLast + "1331";
        System.out.println(name);
    }
}