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
    public Bird(String name, int hunger, int happiness){
        this.name = name;
        this.hunger = hunger;
        this.happiness = happiness;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public int getHunger() {
        return this.hunger;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    // Methods
    public abstract String speak();
    public abstract String receivePets();
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
