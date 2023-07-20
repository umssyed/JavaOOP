/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents a FireBender object extended from Bender
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class FireBender extends Bender {

    //-------------------------------------- VARIABLES
    private static int firePoints;
    private static final int DEFAULT_STRENGTH_LEVEL = 60;
    private static final int DEFAULT_HEALTH = 50;

    //-------------------------------------- CONSTRUCTORS
    /**
     * Default Constructor with all arguments
     * @param name of Bender
     * @param strengthLevel of the Bender
     * @param health of the Bender
     */
    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }
    /**
     * Constructor with only name as argument
     * @param name of Bender
     */
    public FireBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, DEFAULT_HEALTH);
    }

    //-------------------------------------- GETTERS
    /**
     * Method gets fire points
     * @return firepoints in int
     */
    public static int getFirePoints() {
        return firePoints;
    }

    //-------------------------------------- SETTERS
    /**
     * Method sets fire points
     * @param fp int firepoints
     */
    public void setFirePoints(int fp) {
        firePoints = fp;
    }

    //-------------------------------------- METHODS
    /**
     * Method performs attack on another Bender b
     * @param b Bender
     */
    public void attack(Bender b) {
        if (this.getHealth() > 5) {
            int newBenderHealth = b.getHealth() - this.getStrengthLevel();
            b.setHealth(newBenderHealth);

            if (b.getHealth() < 20) {
                setFirePoints(getFirePoints() + b.getStrengthLevel());
            }

            if (newBenderHealth <= 0) {
                b.setHealth(0);
                b.setStrengthLevel(0);
            }

        }
    }

    /**
     * Firebender performs a flame Circle attack on a group of benders
     * @param b list of Bender
     */
    public void flameCircle(Bender[] b) {
        if (this.getHealth() <= 0) {
            return;
        }
        for (int i = 0; i < b.length; i++) {
            b[i].setHealth(b[i].getHealth() - 10);
            if (b[i].getHealth() < 0) {
                b[i].setHealth(0);
            }
        }
        setFirePoints(getFirePoints() + b.length * 5);
    }
}
