/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class represents a BirdSitting class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */
public class BirdSitting {
    private File birdsList;

    // Constructors

    /**
     * Constructor with 1-arg, File
     * @param birdList File of bird lists
     */
    public BirdSitting(File birdList) {
        this.birdsList = birdList;
    }

    /**
     * Constructor with 1-arg, String
     * @param nameOfFile String name of the file
     */
    public BirdSitting(String nameOfFile) {
        this(new File(nameOfFile));
    }



    // Getter

    /**
     * This method gets the bird list
     * @return the birdlist
     */
    public File getBirdsList() {
        return this.birdsList;
    }

    // Setter

    /**
     * This method sets the bird list
     * @param birdList File
     */
    public void setBirdsList(File birdList) {
        this.birdsList = birdList;
    }


    // Methods

    /**
     * This method starts bird sitting where you care for each bird and check
     * their responses
     * @param birdCare File birdCare where it instructs petting/feeding for each bird
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public void startBirdSitting(File birdCare) throws FileNotFoundException, InvalidBirdException {
        // Check if birdCare file exists
        if (!birdCare.exists()) {
            throw new FileNotFoundException("The file was not found....");
        }

        // Bird variables which define properties of the bird
        String birdName;
        String birdType;

        // Store updated information
        String[] updatedInfo = new String[10];
        String[] updatedMessages = new String[10];

        // Scanner for File I/O
        Scanner fileScanner = new Scanner(getBirdsList());
        Scanner lineScan = null;

        try {
            int index = 0;
            // Read from birdsList
            while (fileScanner.hasNextLine()) {
                // Read from file using delimiter ","
                lineScan = new Scanner(fileScanner.nextLine());
                lineScan.useDelimiter(",");

                // Update bird name and type for each line
                birdName = lineScan.next();
                birdType = lineScan.next();

                if (birdType == null && birdType.equals(null)) {
                    throw new InvalidBirdException();
                } else {

                    if (birdType.equals("pigeon")) {
                        // Update bird's hunger and happiness
                        int birdHunger = lineScan.nextInt();
                        int birdHappiness = lineScan.nextInt();
                        // If bird is "pigeon", update the Pigeon's Home City
                        String birdHomeCity = lineScan.next();

                        // Instantiate Pigeon instance for this bird
                        Pigeon myPigeon = new Pigeon(birdName, birdHunger, birdHappiness, birdHomeCity);

                        // Perform bird care
                        // After each bird's care, update the updatedInfo
                        // This will update the stats of each bird
                        updatedInfo[index] = birdCare(myPigeon, birdCare, "pigeon", updatedMessages);

                    } else if (birdType.equals("goose")) {
                        // Update bird's hunger and happiness
                        int birdHunger = lineScan.nextInt();
                        int birdHappiness = lineScan.nextInt();
                        // If bird is "goose", update the Goose's Honk Power
                        int birdHonkPower = lineScan.nextInt();

                        // Instantiate Goose instance for this bird.
                        Goose myGoose = new Goose(birdName, birdHunger, birdHappiness, birdHonkPower);

                        // Perform bird care
                        // After each bird's care, update the updatedInfo
                        // This will update the stats of each bird
                        updatedInfo[index] = birdCare(myGoose, birdCare, "goose", updatedMessages);

                    } else {
                        throw new InvalidBirdException("No birds found!");
                    }
                }
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (lineScan != null) {
                lineScan.close();
            }
        }

        // Write the new updated information after bird care into the bird list file
        writeToBirdList(birdsList, updatedInfo);

        String str;
        // Check for filename
        if (birdCare.getName().equals("birdCare1.csv")) {
            str = "birdCare1_summary.txt";
        } else {
            str = "birdCare2_summary.txt";
        }

        for (String response : updatedMessages) {
            summarizeDay(response, str);
        }

    }

    /**
     * This method summarizes the day. The method saves the content contained in the String
     * passed into the file "birdResponses", in to the file destination "summaryDestination"
     * @param birdResponses Response of the bird
     * @param summaryDestination Destination output of the file
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    private void summarizeDay(String birdResponses,
                              String summaryDestination) throws FileNotFoundException {

        PrintWriter filePrint = null;

        try {
            File fileOut = new File(summaryDestination);
            filePrint = new PrintWriter(fileOut);
            filePrint.println(birdResponses + "\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (filePrint != null) {
                filePrint.close();
                filePrint.flush();
            }
        }
    }

    /**
     * This method writes to the bird list. It essentially updates the bird list
     * with new stats after bird care
     * @param fileOut The output file of the birdlist
     * @param updatedBirdInfo Updated bird information after bird care
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public void writeToBirdList(File fileOut, String[] updatedBirdInfo) throws FileNotFoundException {
        PrintWriter fileWriter = null;
        //File outputFile = new File(fileOut);
        //File fileOuts = new File("birdsOutput.csv");

        try {
            fileWriter = new PrintWriter(fileOut);
            for (int i = 0; i < updatedBirdInfo.length; i++) {
                if (updatedBirdInfo[i] != null) {
                    fileWriter.println(updatedBirdInfo[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            fileWriter.close();
        }

    }


    /**
     * The birdCare method performs care on the Bird regardless of Pigeon or Goose
     * The bird is cared for by either petting or feeding
     * The method updates the updatedMessages. These messages are captured after feeding or petting
     * The method returns a String with updated stats of the bird
     * @param myBird Instance of Bird, this can be Pigeon or Goose
     * @param birdCare File which instructs on the care for the bird
     * @param birdType Type of Bird. This is used to help with the Honk Power and Home City
     * @param updatedMessages Pass updatedMessages to update messages after each pet() and feed()
     * @return Returns a String which is the updated stats of the bird
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public String birdCare(Bird myBird,
                           File birdCare,
                           String birdType,
                           String[] updatedMessages
                           ) throws FileNotFoundException {


        // Define Scanner and other variables
        Scanner fileScanner = new Scanner(birdCare);
        String birdCareEntry;
        Scanner lineScan = null;
        String birdName;
        String careInstructions;
        String birdCareOutput = "";


        // Parse through the birdCare file which instructs
        // whether to pet or feed the bird
        try {
            int index = 0;
            while (fileScanner.hasNextLine()) {
                // Scan each line of the birdCare file
                birdCareEntry = fileScanner.nextLine();
                lineScan = new Scanner(birdCareEntry);
                lineScan.useDelimiter(",");

                // In the birdCare file, first column is bird name
                // second column is care instructions
                birdName = lineScan.next();
                careInstructions = lineScan.next();

                if (myBird.getName().equals(birdName)) {

                    // If the bird's name is same as bird's name in the
                    // birdCare file, then perform care

                    // Perform pet or feed based on instructions
                    if (careInstructions.equals("pet")) {
                        updatedMessages[index] = myBird.receivePets();
                    }
                    if (careInstructions.equals("feed")) {
                        updatedMessages[index] = myBird.eatFood();
                    }

                    // Update the return string with the format:
                    // Name, Type, Hunger, Happiness, HomeCity/HonkPower
                    birdCareOutput = myBird.getName() + ","
                            + birdType + ","
                            + String.valueOf(myBird.getHunger()) + ","
                            + String.valueOf(myBird.getHappiness());

                    if (birdType.equals("pigeon")) {
                        birdCareOutput += "," + ((Pigeon) myBird).getHomeCity();
                    } else {
                        birdCareOutput += "," + String.valueOf(((Goose) myBird).getHonkPower());
                    }
                    break;
                }

                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return birdCareOutput;
    }

    /**
     * This method performs the same and calls the above startBirdSitting method
     * Accepts a filename for the bird care file
     * @param birdCareFileName File which instructs on the care for the bird
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public void startBirdSitting(String birdCareFileName) throws FileNotFoundException {
        startBirdSitting(new File(birdCareFileName));
    }


    /**
     * This method goes through the list of birds
     * and prints out to the console each birds feelings!
     */
    public void birdInventory() throws FileNotFoundException {
        /**
         * This method instantiates all birds in birdsList
         * o For each bird, call and print the returned String of their speak() method to check up on how they
         * are doing
         * o Hint: An array can be used here
         */
        File birdsListNew = getBirdsList();

        String birdName;
        String birdType;

        // Store updated information in Bird[]
        Bird[] myBirds = new Bird[10];

        // Scanner for File I/O
        Scanner fileScanner = new Scanner(birdsListNew);
        Scanner lineScan = null;

        try {
            int index = 0;
            // Read file
            while (fileScanner.hasNextLine()) {

                lineScan = new Scanner(fileScanner.nextLine());
                lineScan.useDelimiter(",");

                // Update bird name and type for each line
                birdName = lineScan.next();
                birdType = lineScan.next();

                if (birdType == null && birdType.equals(null)) {
                    throw new InvalidBirdException();
                } else {

                    if (birdType.equals("pigeon")) {
                        // Update bird's hunger and happiness
                        int birdHunger = lineScan.nextInt();
                        int birdHappiness = lineScan.nextInt();
                        // If bird is "pigeon", update the Pigeon's Home City
                        String birdHomeCity = lineScan.next();

                        // Instantiate Pigeon instance for this bird
                        Pigeon myPigeon = new Pigeon(birdName, birdHunger, birdHappiness, birdHomeCity);
                        myBirds[index] = myPigeon;

                    } else if (birdType.equals("goose")) {
                        // Update bird's hunger and happiness
                        int birdHunger = lineScan.nextInt();
                        int birdHappiness = lineScan.nextInt();
                        // If bird is "goose", update the Goose's Honk Power
                        int birdHonkPower = lineScan.nextInt();

                        // Instantiate Goose instance for this bird.
                        Goose myGoose = new Goose(birdName, birdHunger, birdHappiness, birdHonkPower);
                        myBirds[index] = myGoose;

                    } else {
                        throw new InvalidBirdException();
                    }
                }
                index++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Bird bird: myBirds) {
            if (bird != null) {
                System.out.println(bird.speak());
            }

        }

    }

}

