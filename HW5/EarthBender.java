/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a EarthBender object extended from Bender
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class EarthBender extends Bender {
    //-------------------------------------- VARIABLES
    private boolean earthArmor;
    private static int earthPoints;
    private static final int DEFAULT_STRENGTH_LEVEL = 40;
    private static final int HEALTH = 100;
    private static final boolean DEFAULT_EARTH_ARMOR = false;

    //-------------------------------------- CONSTRUCTORS
    /**
     * Default Constructor with all arguments
     * @param name of Bender
     * @param strengthLevel of the Bender
     * @param health of the Bender
     * @param earthArmor if Bender has earthArmor
     */
    public EarthBender(String name, int strengthLevel, int health, boolean earthArmor) {
        super(name, strengthLevel, health);
        this.earthArmor = earthArmor;
    }
    /**
     * Constructor with only name as argument
     * @param name of Bender
     */
    public EarthBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, HEALTH, DEFAULT_EARTH_ARMOR);
    }

    //-------------------------------------- GETTERS

    /**
     * Method tells if bender has earthArmor
     * @return boolean
     */
    public boolean getEarthArmor() {
        return this.earthArmor;
    }

    /**
     * Method gets earthPoints
     * @return earthPoints in int
     */
    public static int getEarthPoints() {
        return earthPoints;
    }

    //-------------------------------------- SETTERS

    /**
     * Method sets earthArmor to true
     * @param earthArmor boolean
     */
    public void setEarthArmor(boolean earthArmor) {
        this.earthArmor = earthArmor;
    }

    /**
     * Method sets earthPoints
     * @param ep int earthPoints
     */
    public void setEarthPoints(int ep) {
        earthPoints = ep;
    }

    //-------------------------------------- METHODS
    /**
     * Method performs attack on another Bender b
     * @param b Bender
     */
    public void attack(Bender b) {
        if (this.getHealth() > 0) {
            if (b instanceof EarthBender) {
                return;
            } else {
                int newBenderHealth = b.getHealth() - this.getStrengthLevel();
                if (this.getEarthArmor()) {
                    newBenderHealth -= 20;
                    this.setEarthArmor(false);
                }
                b.setHealth(newBenderHealth);

                if (b.getHealth() < 20) {
                    this.setEarthPoints(this.getEarthPoints() + b.getStrengthLevel());
                }

                if (b.getHealth() <= 0) {
                    b.setHealth(0);
                    b.setStrengthLevel(0);
                }
            }
        }
    }

    /**
     * Method rebuilds Armor
     */
    public void buildArmor() {
        this.setEarthArmor(true);
    }

}
