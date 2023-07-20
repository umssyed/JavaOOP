/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a Pond object
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class Pond {
    /**
     * Defines the main method which declares various Frog and Fly species.
     * @param args Argument
     */
    public static void main(String[] args) {
        // Four Frog instances
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog maindak = new Frog("Maindak", 6, 7);

        // Three Fly instances
        Fly smallFly = new Fly(1, 3);
        Fly bigFly = new Fly(6);
        Fly makkhi = new Fly(4, 5);

        // Method calls
        peepaw.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(bigFly);
        System.out.println(bigFly.toString());
        peepo.grow(8);
        peepo.eat(bigFly);
        System.out.println(bigFly.toString());
        System.out.println(peepo.toString());
        System.out.println(maindak.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}