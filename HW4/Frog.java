/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a Frog object
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class Frog {
    //Instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private String species = "Rare Pepe";

    //Static constants/variables
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUESPEED = 5;

    //----------Constructors----------//
    /**
     * Default Constructor with only name as the argument
     * Sets age to DEFAULT_AGE
     * Sets tongueSpeed to DEFAULT_TONGUESPEED
     * @param name Name of frog
     */
    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
    }

    /**
     * Constructor which takes age in years
     * @param name Name of frog
     * @param ageInYear Age of frog in years
     * @param tongueSpeed Speed of frog
     */
    public Frog(String name, double ageInYear, double tongueSpeed) {
        this(name, (int) (ageInYear * 12), tongueSpeed);
    }
    /**
     * Constructor which takes name, age and tongue speed
     * @param name Name of frog
     * @param age Age of frog in years
     * @param tongueSpeed Speed of frog
     */
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }

    //----------Getters/Setters----------//

    /**
     * This method sets the type of the species
     * @param species Type of species
     */
    public void setSpecies(String species) {
        if (!species.equals("")) {
            this.species = species;
        }
    }

    /**
     * This method gets the type of species
     * @return Type of species
     */
    public String getSpecies() {
        return this.species;
    }

    //----------Methods----------//

    /**
     * This method grows the frog by one month
     * Takes no arguments
     */
    public void grow() {
        this.grow(1);
    }

    /**
     * This method grows the frog by the month specified in the argument
     * @param months Grow the frog by the month specified
     */
    public void grow(int months) {
        for (int i = 0; i < months; i++) {
            if (this.age < 12) {
                this.tongueSpeed += 1;
            } else if (this.age >= 30) {
                if (this.tongueSpeed > 5) {
                    this.tongueSpeed -= 1;
                }
            }
            this.age += 1;
        }
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }

    /**
     * This method enables frog to eat a fly
     * @param fly Fly object
     */
    public void eat(Fly fly) {
        if (!fly.isDead()) {
            if (fly.getSpeed() < this.tongueSpeed) {
                if (fly.getMass() > 0.5 * this.age) {
                    this.grow(1);
                }
                fly.setMass(0);
            } else {
                fly.grow(1);
            }
        }
    }

    /**
     * This method outputs general information about the fly
     * @return Output in String format
     */
    public String toString() {
        String output;
        if (this.isFroglet) {
            output = String.format("My name is %s and I'm a rare froglet! I'm %01d months old and "
                    + "my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            output = String.format("My name is %s and I'm a rare frog. I'm %01d months old and my "
                    + "tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
        return output;
    }
}
