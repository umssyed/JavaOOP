import java.io.FileNotFoundException;

public class BirdDriver {
    public static <InvalidBirdException> void main(String[] args) throws FileNotFoundException {
        BirdSitting b = new BirdSitting("birds.csv");
        try {
            b.startBirdSitting("birdCare2.csv");
            b.birdInventory();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } //catch (InvalidBirdException ibe) {
        //  System.out.println(ibe.getMessage());
        //}

        /**
        File f = new File("birds.csv");
        File h = new File("birdCare1.csv");
        BirdSitting c = new BirdSitting(f);

        try  {
            c.startBirdSitting(h);
            c.birdInventory();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
         */
    }
}
