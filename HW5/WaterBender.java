/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a WaterBender object extended from Bender
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class WaterBender extends Bender {

    //-------------------------------------- VARIABLES
    private boolean healer;
    private static int waterPoints;
    private static final int DEFAULT_STRENGTH_LEVEL = 40;
    private static final int DEFAULT_HEALTH = 80;
    private static final boolean DEFAULT_HEALER = false;

    //-------------------------------------- CONSTRUCTORS

    /**
     * Default Constructor with all arguments
     * @param name of Bender
     * @param strengthLevel of the Bender
     * @param health of the Bender
     * @param healer if Bender is healer
     */
    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }

    /**
     * Constructor with only name as argument
     * @param name of Bender
     */
    public WaterBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, DEFAULT_HEALTH, DEFAULT_HEALER);
    }

    //-------------------------------------- GETTERS

    /**
     * Method gets water points
     * @return waterpoints in int
     */
    public static int getWaterPoints() {
        return waterPoints;
    }

    /**
     * Method gets if Bender is healer
     * @return boolean
     */
    public boolean isHealer() {
        return this.healer;
    }

    //-------------------------------------- SETTERS

    /**
     * Method sets water points
     * @param wp int waterpoints
     */
    public void setWaterPoints(int wp) {
        waterPoints = wp;
    }

    /**
     * Method sets if Bender is healer
     * @param isHealer boolean
     */
    public void setHealer(boolean isHealer) {
        this.healer = isHealer;
    }


    //-------------------------------------- METHODS

    /**
     * Method performs attack on another Bender b
     * @param b Bender
     */
    public void attack(Bender b) {
        if (this.getHealth() > 0) {
            int newBenderHealth = b.getHealth() - this.getStrengthLevel();
            b.setHealth(newBenderHealth);
            if (b.getHealth() < 20) {
                setWaterPoints(getWaterPoints() + b.getStrengthLevel());
            }
            if (newBenderHealth <= 0) {
                b.setHealth(0);
                b.setStrengthLevel(0);
            }
        }
    }

    /**
     * Method performs heal on another fellow Waterbender
     * @param wb Waterbender
     */
    public void heal(WaterBender wb) {
        if (!this.isHealer()) {
            return;
        } else {
            wb.setHealth(wb.getHealth() + 20);
            wb.setStrengthLevel(wb.getStrengthLevel() + 20);
        }
    }

    /**
     * Checks for two Waterbenders being equal
     * @param o Object
     * @return True of False if two waterbenders are equal
     */
    public boolean equals(Object o) {
        if (!(o instanceof WaterBender)) {
            return false;
        }

        WaterBender tempWB = (WaterBender) o;

        return ((tempWB.getName().equals(this.getName()))
                && (tempWB.getStrengthLevel() == this.getStrengthLevel())
                && (tempWB.getHealth() == this.getHealth())
                && (tempWB.healer == this.healer)
                );
    }

    /**
     * Provides information about the Waterbender
     * @return String information about the Waterbender
     */
    public String toString() {
        String s;
        if (this.isHealer()) {
            s = "can";
        } else {
            s = "cannot";
        }
        String output;
        output = String.format("My name is %s. I am a bender. "
                        + "My strength level is %d and my current health is %d. "
                        + "With my waterbending, I %s heal others.",
                this.getName(), this.getStrengthLevel(), this.getHealth(), s);
        return output;
    }
}

