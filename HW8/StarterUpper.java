import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.collections.FXCollections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class StarterUpper extends Application {
    private List<StartUpIdea> ideasList = new ArrayList<StartUpIdea>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Extra Credit Observable list:  UI elements
        ObservableList<StartUpIdea> UIObsList = FXCollections.observableArrayList();
        ListView<StartUpIdea> UIListView = new ListView<>(UIObsList);

        // This is used to store list of TextFields
        List<TextField> textFieldObj = new ArrayList<TextField>();

        // Extra Credit Audio: Loading audio file
        // Need to provide URI for file path
        String submitAudioFilePath = "submitIdea.mp3";
        File submitAudioFile = new File(submitAudioFilePath);
        String audioURI = submitAudioFile.toURI().toString();
        Media submitAudio = new Media(audioURI);
        MediaPlayer submitMediaPlayer = new MediaPlayer(submitAudio);


        //=======================JAVA FX====================//
        // Create layout pane
        VBox vbox = new VBox();

        // Name label
        // Create label for name
        Label label = new Label("Muhammad Uzair Shahid Syed");
        Label formTitle = new Label("Startup Ideation Form");

        // Questions in the form
        // Label and TextFields
        Label problemLabel = new Label("1. What is the problem?");
        TextField problemField = new TextField();
        problemLabel.setWrapText(true);

        Label targetCustomerLabel = new Label("2. Who is the target customer?");
        TextField targetCustomerField = new TextField();
        targetCustomerLabel.setWrapText(true);

        Label probRatingLabel = new Label("3. How badly does the customer NEED this problem fixed (1-10)?");
        TextField probRatingField = new TextField();
        probRatingLabel.setWrapText(true);

        Label probExpLabel = new Label("4. How many people do you know who might experience this problem?");
        TextField probExpField = new TextField();
        probExpLabel.setWrapText(true);

        Label targetMarketLabel = new Label("5. How big is the market?");
        TextField targetMarketField = new TextField();
        targetMarketLabel.setWrapText(true);

        Label solutionsLabel = new Label("6. Who are the competitors/existing solutions?");
        TextField solutionsField = new TextField();
        solutionsLabel.setWrapText(true);

        // Add to textFieldObj for later use when clearing TextFields
        textFieldObj.add(problemField);
        textFieldObj.add(targetCustomerField);
        textFieldObj.add(probRatingField);
        textFieldObj.add(probExpField);
        textFieldObj.add(targetMarketField);
        textFieldObj.add(solutionsField);

        // Create grid pane to hold form elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(20, 25, 20, 25)); // Padding for form elements
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        // Add form elements to grid pane
        gridPane.add(problemLabel, 0, 0);
        gridPane.add(problemField, 1, 0);

        gridPane.add(targetCustomerLabel, 0, 1);
        gridPane.add(targetCustomerField, 1, 1);

        gridPane.add(probRatingLabel, 0, 2);
        gridPane.add(probRatingField, 1, 2);

        gridPane.add(probExpLabel, 0, 3);
        gridPane.add(probExpField, 1, 3);

        gridPane.add(targetMarketLabel, 0, 4);
        gridPane.add(targetMarketField, 1, 4);

        gridPane.add(solutionsLabel, 0, 5);
        gridPane.add(solutionsField, 1, 5);



        //=======================BUTTONS===================
        // SUBMIT IDEA: Button that adds the current idea written in the fields
        // to a List of StartUpIdea object
        Button submitBtn = new Button("Submit Idea!");
        submitBtn.setOnAction(event -> {
            String problem = problemField.getText();
            String targetCustomer = targetCustomerField.getText();
            String customerNeed = probRatingField.getText();
            String knownPeopleWithProblem = probExpField.getText();
            String targetMarketSize = targetMarketField.getText();
            String competitors = solutionsField.getText();

            // Title and msg for the popup
            String title = "Warning";
            String msg = "At least one field is invalid!";

            // Validate input fields
            if (problem.isEmpty() || targetCustomer.isEmpty()
                    || customerNeed.isEmpty()
                    || knownPeopleWithProblem.isEmpty()
                    || targetMarketSize.isEmpty()
                    || competitors.isEmpty()) {
                errorInvalidFieldAlert(title, msg);
            } else if (!isValidCustomerNeed(customerNeed)) {
                errorInvalidFieldAlert(title, msg);
            } else if (!isValidKnownPeopleProb(knownPeopleWithProblem)) {
                errorInvalidFieldAlert(title, msg);
            } else if (!isValidTargetMarketSize(targetMarketSize)) {
                errorInvalidFieldAlert(title, msg);
            } else {
                // Otherwise create a class of idea with all the input fields
                StartUpIdea idea = new StartUpIdea(
                        problem,
                        targetCustomer,
                        Integer.parseInt(customerNeed),
                        Integer.parseInt(knownPeopleWithProblem),
                        Integer.parseInt(targetMarketSize),
                        competitors
                );

                // Add ideas to the list of startup ideas
                ideasList.add(idea);

                // Play submit button sound
                submitMediaPlayer.play();

                // Add ideas to the observable list view
                UIObsList.add(idea);
            }
            // Delete later - used for debugging
            showUpdate();
        });

        // SORT: Button that sorts the List of ideas
        // based on their rough potential
        Button sortBtn = new Button("Sort Ideas");
        sortBtn.setOnAction(event -> {
            Collections.sort(ideasList);
            System.out.println("\n....Sorting the ideas.....");
            showUpdate();
        });

        // RESET/DELETE: Add Button to reset form and delete
        // if file is present
        Button resetBtn = new Button("Reset Form");
        resetBtn.setOnAction(event -> {
            // Use pop up for confirmation
            String title = "Confirmation for resetting form";
            String msg = "Are you sure you want to reset the form and delete all saved data?";
            resetFormAlert(title, msg, textFieldObj);
        });

        // SAVE IDEAS: Button that saves all the added
        // Ideas to File
        Button saveIdeasBtn = new Button("Save Ideas");
        saveIdeasBtn.setOnAction(event -> {
            File saveFile = new File("ideas.txt");
            try {
                Boolean fileSaveConfirmation = FileUtil.saveIdeasToFile(ideasList, saveFile);
                System.out.println("File successfully saved!");
            } catch(Exception e) {
                System.out.println("File could not be saved!");
            }
        });





        //=================JAVAFX=================//


        // Add a Hbox at the bottom of the Vbox
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(submitBtn, saveIdeasBtn, sortBtn, resetBtn);
        flowPane.setHgap(10);
        flowPane.setVgap(200);
        flowPane.setAlignment(Pos.CENTER);

        // Create a StackPane to center the FlowPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(flowPane);

        // Scrollable Pane for the Observable List. This is
        // parent list
        StackPane ObsUIStackPane = new StackPane(UIListView);
        ObsUIStackPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
        ObsUIStackPane.prefWidthProperty().bind(scene.widthProperty().multiply(0.9));

        ScrollPane scrollPane = new ScrollPane(ObsUIStackPane);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        // StackPane for UI Observable List
        StackPane observableUI = new StackPane(scrollPane);

        // Put it in Vbox
        vbox.getChildren().addAll(label, formTitle, gridPane, stackPane, observableUI);
        vbox.setStyle("-fx-background-color: #e4e7e6;");

        // Create scene
        Scene scene = new Scene(vbox, 800, 800);

        // Add stylesheet css
        scrollPane.getStyleClass().add("scroll-pane");

        problemLabel.getStyleClass().add("labelfield-custom");
        targetCustomerLabel.getStyleClass().add("labelfield-custom");
        probRatingLabel.getStyleClass().add("labelfield-custom");
        probExpLabel.getStyleClass().add("labelfield-custom");
        targetMarketLabel.getStyleClass().add("labelfield-custom");
        solutionsLabel.getStyleClass().add("labelfield-custom");

        problemField.getStyleClass().add("textfield-custom");
        targetCustomerField.getStyleClass().add("textfield-custom");
        probRatingField.getStyleClass().add("textfield-custom");
        probExpField.getStyleClass().add("textfield-custom");
        targetMarketField.getStyleClass().add("textfield-custom");
        solutionsField.getStyleClass().add("textfield-custom");

        submitBtn.getStyleClass().add("buttonAll");
        sortBtn.getStyleClass().add("buttonAll");
        saveIdeasBtn.getStyleClass().add("buttonAll");
        resetBtn.getStyleClass().add("resetbutton");

        // Add CSS stylesheet
        scene.getStylesheets().add(getClass()
                .getResource("styles.css")
                .toExternalForm());

        // Set scene for the stage
        primaryStage.setScene(scene);

        // Set form title
        primaryStage.setTitle("Problem Ideation Form.");

        // Display the stage
        primaryStage.show();
    }

    private void showUpdate() {
        int index = 1;
        for(StartUpIdea idea: ideasList) {
            System.out.println("Idea number: " + index);
            System.out.println(idea);
            System.out.println();
            index++;
        }
    }

    private void resetFormAlert(String title, String message, List<TextField> textFieldObject) {
        // Create buttons during confirmation diaglogure alert
        ButtonType yesBtn = new ButtonType("Reset and delete");
        ButtonType noBtn = new ButtonType("I change my mind");

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(title);
        confirmationAlert.setHeaderText(message);
        confirmationAlert.getButtonTypes().setAll(yesBtn, noBtn);

        confirmationAlert.showAndWait()
            .ifPresent(
                buttonType -> {
                    if (buttonType == yesBtn) {
                        // "Reset and delete" button is clicked

                        String filePath = "ideas.txt";
                        try {
                            performReset(filePath, ideasList, textFieldObject);
                        } catch (Exception e) {
                            System.out.println("Unable to reset/delete");
                        }

                    } else if (buttonType == noBtn) {
                        // "I change my mind" button is clicked
                        System.out.println("Nothing was changed. Dialogue option closed.");
                    } else {
                        // Nothing is clicked. Dialogue option is closed.
                        System.out.println("Confirmation dialogue was closed without selection.");
                    }
            }
        );
    }

    private void performReset(String filePathString,
                              List<StartUpIdea>
                                      ideasList,
                              List<TextField> txtFieldObj) throws IOException {
        // Check if the file exists and then delete it
        try {
            Path filePath = Paths.get(filePathString);
            Files.delete(filePath);
            System.out.println("Ideas.txt file deleted...");
        } catch (Exception e) {
            System.out.println("Unable to delete file! File does not exist!");
        }

        // Clear current list of StartUpIdeas
        try {
            ideasList.clear();
            System.out.println("Data deleted....");
        } catch (Exception e) {
            System.out.println("Could not delete all data in StartUpIdeas!");
        }

        // Clear all fields in the form
        for(TextField textfield: txtFieldObj) {
            textfield.clear();
        }
        System.out.println("All fields are cleared...");

        System.out.println("\n...Dialogue option closing.\n");
    }

    private void errorInvalidFieldAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private boolean isValidCustomerNeed(String customerNeed) {
        if (customerNeed.isEmpty()) {
            return false;
        }
        try {
            int int_customerNeed = Integer.parseInt(customerNeed);
            return (int_customerNeed >= 1 && int_customerNeed <= 10);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidKnownPeopleProb(String knownPeopleWithProblem) {
        if (knownPeopleWithProblem.isEmpty()) {
            return false;
        }
        try {
            int int_kPWP = Integer.parseInt(knownPeopleWithProblem);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidTargetMarketSize(String targetMarketSize) {
        if (targetMarketSize.isEmpty()) {
            return false;
        }
        try {
            int int_kPWP = Integer.parseInt(targetMarketSize);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
