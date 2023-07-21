/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */

/**
 * This class represents a Goose class which extends the abstract Bird class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public class Goose extends Bird {
    // Variables
    private int honkPower;
    private static final int DEFAULT_HUNGER = 70;
    private static final int DEFAULT_HAPPINESS = 20;
    private static final int DEFAULT_HONKPOWER = 8;

    // Constructors

    /**
     * Constructor with 4-args
     * @param name Name
     * @param hunger Hunger
     * @param happiness Happiness
     * @param honkPower Honk Power
     */
    public Goose(String name, int hunger, int happiness, int honkPower) {
        super(name, hunger, happiness);
        this.honkPower = honkPower;
    }

    /**
     * Constructor with 1-arg
     * @param name Name
     */
    public Goose(String name) {
        this(name, DEFAULT_HUNGER, DEFAULT_HAPPINESS, DEFAULT_HONKPOWER);
    }

    // Getters

    /**
     * The method gets honk power of the Goose
     * @return int honk power
     */
    public int getHonkPower() {
        return honkPower;
    }

    // Setters

    /**
     * The method sets honk power of the Goose
     * @param honkPower Goose honk power
     */
    public void setHonkPower(int honkPower) {
        this.honkPower = honkPower;
    }

    // Methods

    /**
     * This method enables Goose to speak
     * @return A string where Goose is speaking
     */
    @Override
    public String speak() {
        // Sound of Goose is "honk"
        String sound = "honk";
        String speak = "";

        // Goose will repeat the sound depending on honkPower
        // If happiness is low, it will be frustrated!!!
        for (int i = 0; i < this.getHonkPower(); i++) {
            if (this.getHappiness() < 30) {
                speak += sound.toUpperCase() + " ";
            } else {
                speak += sound + " ";
            }
        }
        return speak;
    }

    /**
     * This method receives pets for the Goose
     * Happiness is increased by 20, with a max of 100
     * If happiness was initially more than 80, Goose hands you a gift
     * Otherwise it keeps honking for more pets
     * @return A String where the Goose expresses their feelings
     */
    @Override
    public String receivePets() {
        // Identify initial happiness and set it by increasing by 20
        int initialHappiness = this.getHappiness();
        this.setHappiness(getHappiness() + 20);

        // If new happiness has increased 100, set it back to 100
        if (this.getHappiness() > 100) {
            this.setHappiness(100);
        }

        // If initially the happiness was greater than 80, Goose gives gift
        // Otherwise honks for more pets
        if (initialHappiness >= 80) {
            return this.getName() + " waddles off and hands me a "
                    + "flower after being pet";
        } else {
            return this.getName() + " honks at me for more pets";
        }
    }

    /**
     * The Goose is cared for via a gourmet meal
     * If goose is full, happiness is decreased by 10, with a minumum val of 0
     * Oterhwise, its hunger is set to 0 and it enjoys the meal
     * @return A String where the Goose expresses their satisfaction with the meal
     */
    @Override
    public String eatFood() {
        // If hunger is less than 0, happiness decreases by 10
        if (this.getHunger() <= 0) {
            this.setHappiness(this.getHappiness() - 10);

            // If happiness drops below 0, set it back to 0
            if (this.getHappiness() < 0) {
                this.setHappiness(0);
            }

            // Goose expresses satisfaction
            return this.getName() + " was not hungry but ate a little "
                    + "food anyways.";
        } else {
            // Hunger is set back to 0 and
            // Goose expresses satisfaction
            this.setHunger(0);
            return this.getName() + " thorougly enjoyed the meal.";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Goose)) {
            return false;
        } else {
            Goose tempGoose = (Goose) o;
            return (super.equals(tempGoose)
                    && tempGoose.honkPower == this.honkPower);
        }
    }
}
