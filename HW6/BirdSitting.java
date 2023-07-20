/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents a BirdSitting class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BirdSitting {
    private File birdList;
    private final List<Bird> listOfBirds = new ArrayList<Bird>();

    // Constructors
    public BirdSitting(File birdListFile) {
        this.birdList = birdListFile;
    }

    public BirdSitting(String nameOfFile) {
        this(new File(nameOfFile));
    }

    // Getter
    public File getBirdList() {
        return birdList;
    }

    // Setter
    public void setBirdList(File birdList) {
        this.birdList = birdList;
    }

    // Methods

    /**
     * This method starts bird sitting where you care for each bird and check
     * their responses
     * @param birdCare File birdCare where it instructs petting/feeding for each bird
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public void startBirdSitting(File birdCare) throws FileNotFoundException {
        // Check if birdCare file exists
        if(!birdCare.exists()) {
            throw new FileNotFoundException("The file was not found....");
        }

        // Bird variables which define the properties of the bird
        String birdName;
        String birdType;
        int birdHunger;
        int birdHappiness;
        int birdHonkPower;
        String birdHomeCity;

        // Store updated information. "updatedInfo" is for
        List<String> updatedInfo = new ArrayList<String>();
        List<String> updatedMessages = new ArrayList<String>();

        // Scanner for File I/O
        Scanner birdListFileScanner = new Scanner(getBirdList());
        String birdListEntry;
        Scanner lineScanForBirdList;

        try {
            // Read from BirdList.
            while(birdListFileScanner.hasNextLine()){
                // Read from file and use delimiter ","
                birdListEntry = birdListFileScanner.nextLine();
                lineScanForBirdList = new Scanner(birdListEntry);
                lineScanForBirdList.useDelimiter(",");

                // Update bird name and type in EACH line of the BirdList.csv
                birdName = lineScanForBirdList.next();
                birdType = lineScanForBirdList.next();

                // Identify from each line if bird is "goose" or "pigeon"
                // If not, throw an error "InvalidBirdException"
                if (birdType.equals("goose") || birdType.equals("pigeon")) {
                    // Update bird's hunger and happiness
                    String updatedAfterCare;
                    birdHunger = lineScanForBirdList.nextInt();
                    birdHappiness = lineScanForBirdList.nextInt();

                    if (birdType.equals("goose")) {
                        // If bird is "goose", update the Goose's Honk Power
                        birdHonkPower = lineScanForBirdList.nextInt();

                        // Instantiate Goose instance for this bird.
                        Goose myGoose = new Goose(birdName, birdHunger, birdHappiness, birdHonkPower);

                        // Perform bird care and store it in "updatedAfterCare"
                        updatedAfterCare = birdCare(myGoose, birdCare, "goose", updatedMessages);

                    } else {
                        // If bird is "pigeon", update the Pigeon's Home City
                        birdHomeCity = lineScanForBirdList.next();

                        // Instantiate Pigeon instance for this bird
                        Pigeon myPigeon = new Pigeon(birdName, birdHunger, birdHappiness, birdHomeCity);

                        // Perform bird care and store it in "updatedAfterCare"
                        updatedAfterCare = birdCare(myPigeon, birdCare, "pigeon", updatedMessages);

                    }
                    // After each bird's care, update the updatedInfo
                    // This will update the stats of each bird
                    updatedInfo.add(updatedAfterCare);
                } else {
                    throw new InvalidBirdException("This is not a type we know!");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        writeToBirdList(birdList, updatedInfo);

        String str;
        // Check for filename
        if (birdCare.getName().equals("birdCare1.csv")) {
            str = "birdCare1_summary.txt";
        } else {
            str = "birdCare2_summary.txt";
        }

        for (String response : updatedMessages) {
            System.out.println(response);
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

        File fileOut = new File(summaryDestination);
        PrintWriter pw = null;
        PrintWriter fileWriter = null;
        try {
            pw = new PrintWriter(new FileWriter(summaryDestination, true));
            pw.println(birdResponses);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pw.close();
        }
    }

    /**
     * This method writes to the bird list. It essentially updates the bird list
     * with new stats after bird care
     * @param fileOut The output file of the birdlist
     * @param updatedBirdInfo Updated bird information after bird care
     * @throws FileNotFoundException If no file is found, throws FileNotFoundException
     */
    public void writeToBirdList(File fileOut, List<String> updatedBirdInfo) throws FileNotFoundException {
        PrintWriter fileWriter = null;
        //File fileOut = new File("birdsOutput.csv");
        try {
            fileWriter = new PrintWriter(fileOut);
            for(int i=0; i < updatedBirdInfo.size(); i++) {
                String line = updatedBirdInfo.get(i);
                fileWriter.println(line);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            fileWriter.close();
        }
    }


    /**
     * The birdCare method performs care on the Bird regardless of Pigeon or Goose
     * The bird is cared for by either petting or feeding
     * The method updates the bird list with Bird objects
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
                           List<String> updatedMessages
                           ) throws FileNotFoundException {
        // Define Scanner and other variables
        Scanner birdCareFileScanner = new Scanner(birdCare);
        String birdCareEntry;
        Scanner lineScanForBirdCare;
        String birdName;
        String care;
        String returnString = "";

        // Parse through the birdCare file which instructs
        // whether to pet or feed the bird
        try {
            while(birdCareFileScanner.hasNextLine()) {
                // Scan each line of the birdCare file
                birdCareEntry = birdCareFileScanner.nextLine();
                lineScanForBirdCare = new Scanner(birdCareEntry);
                lineScanForBirdCare.useDelimiter(",");

                // In the birdCare file, first column is birds' name and second
                // is care instructions
                birdName = lineScanForBirdCare.next();
                care = lineScanForBirdCare.next();

                if (myBird.getName().equals(birdName)) {
                    // If the bird's name is same as bird's name in the
                    // birdCare file, then perform care

                    // Add the bird to the list of birds <Bird>
                    listOfBirds.add(myBird);

                    // Perform pet or feed based on instructions
                    if (care.equals("pet")) {
                        updatedMessages.add(myBird.receivePets());
                    }
                    if (care.equals("feed")) {
                        updatedMessages.add(myBird.eatFood());
                    }

                    // Update the return string with the format:
                    // Name, Type, Hunger, Happiness, HomeCity/HonkPower
                    returnString = myBird.getName() + ","
                            + birdType + ","
                            + String.valueOf(myBird.getHunger()) + ","
                            + String.valueOf(myBird.getHappiness());

                    if (birdType.equals("pigeon")) {
                        returnString += "," + ((Pigeon)myBird).getHomeCity();
                    } else {
                        returnString += "," + String.valueOf(((Goose)myBird).getHonkPower());
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnString;
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
     * This method goes through the list of birds <Bird>
     * and prints out to the console each birds feelings!
     */
    public void birdInventory(){
        for(Bird bird: listOfBirds) {
            System.out.println(bird.speak());
        }
    }
}

