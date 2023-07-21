/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents a Pigeon class which extends the abstract Bird class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public class Pigeon extends Bird {
    // Variables
    private String homeCity;
    private static final int DEFAULT_HUNGER = 90;
    private static final int DEFAULT_HAPPINESS = 90;
    private static final String DEFAULT_HOMECITY = "New York";

    // Constructors

    /**
     * Constructor with 4-args
     * @param name Name
     * @param hunger Hunger
     * @param happiness Happiness
     * @param homeCity Home City
     */
    public Pigeon(String name, int hunger, int happiness, String homeCity) {
        super(name, hunger, happiness);
        this.homeCity = homeCity;
    }

    /**
     * Constructor with 1-arg
     * @param name Name
     */
    public Pigeon(String name) {
        this(name, DEFAULT_HUNGER, DEFAULT_HAPPINESS, DEFAULT_HOMECITY);
    }

    // Getters

    /**
     * This method gets home city of the Pigeon
     * @return String home city
     */
    public String getHomeCity() {
        return homeCity;
    }

    // Setters

    /**
     * This method sets the home city of the Pigeon
     * @param homeCity String homeCity
     */
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    // Methods

    /**
     * This method enables Pigeon to speak
     * @return A string where Pigeon is speaking
     */
    public String speak() {
        String sound = "coo coo coo";
        if (this.getHunger() > 40) {
            return sound.toUpperCase();
        } else {
            return sound;
        }
    }

    /**
     * This method receives pets for Pigeons
     * Pigeons dont like being pet though.
     * @return A String explaining the Pigeon flew away
     */
    public String receivePets() {
        return this.getName() + " was displeased and flew away when I tried to pet it.";
    }

    /**
     * The Pigeon is cared for by some high-quality food.
     * Pigeons are always ready to consume more bread. The pigeon’s hunger is set to 0.
     * Additionally, the pigeon’s happiness increases by 50
     * @return A String where the Pigeon happily pecks the bread
     */
    public String eatFood() {
        // Set hunger to 0 and increase happiness by 50. Set to 100 if it exceeds 100.
        this.setHunger(0);
        this.setHappiness(this.getHappiness() + 50);
        if (this.getHappiness() > 100) {
            this.setHappiness(100);
        }
        return this.getName() + " happily pecked up the bread.";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pigeon)) {
            return false;
        } else {
            Pigeon tempPigeon = (Pigeon) o;
            return (super.equals(this)
                    && tempPigeon.homeCity == this.homeCity);
        }
    }
}

