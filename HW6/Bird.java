/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents the abstract Bird class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public abstract class Bird {
    // Private variables
    private String name;
    private int hunger;
    private int happiness;

    // Constructors

    /**
     * Constructor for the Bird class
     * @param name Name
     * @param hunger Hunger
     * @param happiness Happiness
     */
    public Bird(String name, int hunger, int happiness){
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
    }

    // Getters

    /**
     * This method gets the name of the Bird
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method gets the happiness of the Bird
     * @return int happiness
     */
    public int getHappiness() {
        return this.happiness;
    }

    /**
     * This method gets hunger of the bird
     * @return int hunger
     */
    public int getHunger() {
        return this.hunger;
    }

    // Setters

    /**
     * This method sets name of the bird
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets happiness of the bird
     * @param happiness
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * This method sets hunger of the bird
     * @param hunger
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    // Methods

    /**
     * An abstract method for Bird to speak
     * @return String
     */
    public abstract String speak();

    /**
     * An abstract method for Bird to receive pets
     * @return String
     */
    public abstract String receivePets();

    /**
     * An abstract method for Bird to eat food
     * @return String
     */
    public abstract String eatFood();

    /**
     * Equals method for Bird
     * @param o Object o
     * @return Returns whether true or false
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof  Bird)) {
            return false;
        } else {
            Bird tempBird = (Bird) o;
            if (tempBird.name.equals(this.name) &&
                    tempBird.hunger == this.hunger &&
                    tempBird.happiness == this.happiness) {
                return true;
            }
        }
        return false;
    }

}
