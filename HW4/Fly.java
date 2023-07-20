/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a Fly object
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public class Fly {
    //Instance variables
    private double mass;
    private double speed;

    //Static constants/variables
    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    //----------Constructors----------//

    /**
     * Default Constructor with no argument
     * Sets mass to DEFAULT_MASS
     * Sets speed to DEFAULT_SPEED
     */
    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    /**
     * Constructor takes only mass and sets speed to DEFAULT_SPEED
     * @param mass Mass of fly
     */
    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    /**
     * Connstructor takes both mass and speed
     * @param mass Mass of fly
     * @param speed Speed of fly
     */
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    //----------Getters/Setters----------//

    /**
     * This method gets the mass of fly
     * @return mass of fly
     */
    public double getMass() {
        return this.mass;
    }
    /**
     * This method gets the speed of fly
     * @return speed of fly
     */
    public double getSpeed() {
        return this.speed;
    }
    /**
     * This method sets the mass of fly
     * @param mass Mass of fly to be set
     */
    public void setMass(double mass) {
        if (mass >= 0) {
            this.mass = mass;
        }
    }

    /**
     * This method sets the speed of fly
     * @param speed Speed of fly to be set. Must be larger than 0.
     */
    public void setSpeed(double speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    //----------Methods----------//

    /**
     * This method grows the fly with added mass
     * @param addMass Mass to be added to the fly.
     */
    public void grow(int addMass) {
        for (int i = 0; i < addMass; i++) {
            if (this.mass < 20) {
                this.speed += 1;
            } else if (this.mass >= 20) {
                this.speed -= 0.5;
            }
            this.mass += 1;
        }
    }

    /**
     * This method checks if the fly is dead
     * @return True if fly is dead, False if fly is alive.
     */
    public boolean isDead() {
        return this.mass == 0;
    }

    /**
     * This method outputs general information about the fly
     * @return Output in String format
     */
    public String toString() {
        String output;
        if (this.mass == 0) {
            output = String.format("I'm dead, but I used to be a fly with a speed of %.2f.", this.speed);
        } else {
            output = String.format("I'm a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
        }
        return output;
    }

}

