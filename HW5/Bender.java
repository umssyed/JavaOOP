/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents an abstract Bender object
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public abstract class Bender {
    //-------------------------------------- VARIABLES
    private String name;
    private int strengthLevel;
    private int health;

    //-------------------------------------- CONSTRUCTORS

    /**
     * Default Constructor with all arguments
     * @param name of the Bender
     * @param strengthLevel of the Bender
     * @param health of the Bender
     */
    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

    //-------------------------------------- GETTERS

    /**
     * This methods gets the name of the Bender
     * @return name of Bender
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method gets the strength level of the Bender
     * @return strength level of Bender
     */
    public int getStrengthLevel() {
        return this.strengthLevel;
    }

    /**
     * This method gets the health of the Bender
     * @return health of Bender
     */
    public int getHealth() {
        return this.health;
    }

    //-------------------------------------- SETTERS

    /**
     * This method sets the name of the Bender
     * @param name of Bender
     */
    public void setName(String name) {
        if (!(name.equals("") || name.equals(null))) {
            this.name = name;
        }
    }

    /**
     * This method sets the strength level of the bender
     * @param strengthLVL Strength Level of Bender
     */
    public void setStrengthLevel(int strengthLVL) {
        this.strengthLevel = strengthLVL;
    }

    /**
     * This method sets the health of the bender
     * @param health Health of the Bender
     */
    public void setHealth(int health) {
        this.health = health;
    }

    //-------------------------------------- METHODS

    /**
     * This is the abstract class attack for each child Bender
     * @param b Bender
     */
    abstract void attack(Bender b);

    /**
     * This method allows to recover for the bender.
     * @param i Int value of health.
     */
    public void recover(int i) {
        if (this.health > 0) {
            this.health += i;
        }
    }

    /**
     * Checks for two benders being equal
     * @param o Object
     * @return True of False if two benders are equal
     */
    public boolean equals(Object o) {
        if (!(o instanceof Bender)) {
            return false;
        }

        Bender tempBender = (Bender) o;
        return ((tempBender.name.equals(this.name))
                && (tempBender.strengthLevel == this.strengthLevel)
                && (tempBender.health == this.health));
    }

    /**
     * Provides information about the Bender
     * @return String information about the Bender
     */
    public String toString() {
        String output;
        output = String.format("My name is %s. I am a bender. "
                        + "My strength level is %d and my current health is %d.",
                this.getName(), this.getStrengthLevel(), this.getHealth());
        return output;
    }

}
