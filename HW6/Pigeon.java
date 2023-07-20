/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents a Pigeon class which extends the abstract Bird class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public class Pigeon extends Bird{
    private String homeCity;
    private static final int DEFAULT_HUNGER = 90;
    private static final int DEFAULT_HAPPINESS = 90;
    private static final String DEFAULT_HOMECITY = "New York";

    // Constructors
    public Pigeon(String name, int hunger, int happiness, String homeCity) {
        super(name, hunger, happiness);
        this.homeCity = homeCity;
    }
    public Pigeon(String name) {
        this(name, DEFAULT_HUNGER, DEFAULT_HAPPINESS, DEFAULT_HOMECITY);
    }

    // Getters
    public String getHomeCity() {
        return homeCity;
    }

    // Setters
    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    // Methods
    public String speak() {
        String sound = "coo coo coo";
        if (this.getHunger() > 40) {
            return sound.toUpperCase();
        } else {
            return sound;
        }
    }

    public String receivePets() {
        return this.getName() + " was displeased and flew away when I tried to pet it.";
    }

    public String eatFood() {
        this.setHunger(0);
        this.setHappiness(this.getHappiness() + 50);
        if (this.getHappiness() > 100) {
            this.setHappiness(100);
        }
        return this.getName() + " happily pecked up the bread.";
    }

    public boolean equals(Object o) {
        if (!(o instanceof Pigeon)) {
            return false;
        } else {
            Pigeon tempPigeon = (Pigeon) o;
            return (tempPigeon.equals(this)
                    && tempPigeon.homeCity == this.homeCity);
        }
    }
}

