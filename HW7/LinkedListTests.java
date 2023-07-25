import java.util.Arrays;
/**
 * Provided file that contains a number of tests to help you
 * debug your LinkedList class!
 * @author Andrew Chafos, Shishir Bhat and Aleksandr Kalenchits
 * @version 1.0
 */




public class LinkedListTests {
    /**
     * Contains the main execution of the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();

        // First, we test all the exceptions

        // Empty list tests  ([])
        assertEquals(0, myList.size(), "An empty list should have a size of 0!");
        assertThrows(IllegalArgumentException.class, () -> myList.addAtIndex("", -1));
        assertThrows(IllegalArgumentException.class, () -> myList.removeAtIndex(0));
        assertThrows(IllegalArgumentException.class, () -> myList.getAtIndex(0));

        // Now that we're done with exceptions, let's test the main functionality

        List<String> list2 = new LinkedList<>();


        String[] toAdd = {"3", "4", "1", "2"};
        // will add 3 at index 0, 4 at index 1, 1 at index 0, and then 2 at index 1

        list2.addAtIndex("Julia", 0);
        assertListEquals(new String[]{"Julia"}, list2);

        list2.addAtIndex("McKay", 1);
        list2.addAtIndex("Kevin", 0);
        list2.addAtIndex("Leo", 1);
        list2.addAtIndex("Alex", 2);

        // The list should now look like: [Kevin, Leo, Alex, Julia, McKay]
        assertEquals(5, list2.size(), "The list shoud be of size 5");
        assertListEquals(
            new String[]{"Kevin", "Leo", "Alex", "Julia", "McKay"},
            list2
        );

        assertTrue(!list2.isEmpty(), "The list should not be empty, it should have 5 elements inside");

        assertEquals("Leo", list2.getAtIndex(1), "The element returned by getAtIndex(1) is wrong");
        assertEquals("Alex", list2.getAtIndex(2), "The element returned by getAtIndex(2) is wrong");


        assertEquals("Leo", list2.removeAtIndex(1), "remove from index 0 should give first element");

        assertEquals("McKay", list2.removeAtIndex(3), "remove from index (size - 1) should give last element");

        // Now the list looks like [Kevin, Alex, Julia]
        assertEquals(3, list2.size(), "The list shoud be of size 3");
        assertListEquals(
            new String[] {"Kevin", "Alex", "Julia"},
            list2
        );

        assertEquals("Julia", ( (LinkedList) list2).getTail().getData(), "The tail shjould point at the node with data \"Julia\" ");

        assertEquals("Alex", list2.remove("Alex"), "Remove method does not return correct data");
        assertEquals("Julia", list2.remove("Julia"), "Remove method does not return correct data");
        assertEquals(1, list2.size(), "The list should be of size 1");
        assertListEquals(
            new String[] {"Kevin"},
            list2
        );

        list2.clear();
        assertTrue(((LinkedList) list2).getHead() == null, "Clear operation did not clear the head of the list");

        assertTrue(list2.isEmpty(), "The list should be empty");

        System.out.println("All Tests Passed!");
    }




    // YOU CAN IGNORE EVERYTHING BELOW THIS


    /**
     * Helper method that terminates the program if the given boolean expression is false.
     * @param expression when false, ends the program and prints out message.  Otherwise, method does nothing
     * @param message message to show if the progrsam ends.
     */
    private static void assertTrue(boolean expression, String message) {
        if (!expression) {
            throw new AssertionError("Test Failed: " + message);
        }
    }

    /**
     * Helper method that terminates the program if the given objects are not equal by the equals() method.
     * @param expected the expected value of `actual`
     * @param actual when not equal to expected, ends the program and prints out message.
     * @param message message to show if the progrsam ends.
     */
    private static void assertEquals(Object expected, Object actual, String message) {
        if ((actual == null && expected != null) || !actual.equals(expected)) {
            throw new AssertionError(
                "Test Failed: " + message + ".  Expected "
                + String.valueOf(expected) + ", was actually:" + String.valueOf(actual)
            );
        }
    }

    /**
     * Helper method to check if an exception was thrown from a call
     * @param expectedType The exception to expect
     * @param executable   The call to make
     */
    private static void assertThrows(Class<? extends Exception> expectedType, Runnable executable) {
        try {
            executable.run();
            throw new AssertionError("Expected: " + expectedType.getSimpleName() + ", but no exception was thrown.");
        } catch (Exception caught) {
            if (!expectedType.isInstance(caught)) {
                throw new AssertionError("Expected " + expectedType.getSimpleName() + " to be thrown"
                    + " but instead got " + caught.getClass().getSimpleName());
            }
        }
    }

    private static void assertListEquals(String[] expected, List<String> actual) {
        assertEquals(expected.length, actual.size(),
            "Expected list of size " + expected.length + " but got " + actual.size());
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.getAtIndex(i))) {
                throw new AssertionError("Expected " + Arrays.toString(expected) + ", but got " + actual.getAtIndex(i)
                                        + " at index " + i);
            }
        }
    }

}
