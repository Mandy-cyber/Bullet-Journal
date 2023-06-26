package cs3500.pa05.controller;

import cs3500.pa05.view.ThemeView;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents a controller for the settings screen.
 */
public class SettingsController extends Controller {
  // Buttons
  @FXML
  private Button enterButton;
  @FXML
  private Button themeButton;
  @FXML
  private Button sortButton;
  @FXML
  private Button weekNameButton;
  @FXML
  private Button maxEntriesButton;
  @FXML
  private Button maxTasksButton;
  // FIELDS
  @FXML
  private TextField passwordField;
  @FXML
  private TextField weekNameField;
  @FXML
  private TextField maxEntriesField;
  @FXML
  private TextField maxTasksField;
  @FXML
  private Label settingsTitle;
  @FXML
  private Label actionTitle;
  @FXML
  private Label warningLabel;
  @FXML
  private Label passwordLabel;
  @FXML
  private Label weekNameLabel;
  @FXML
  private Label maxEntriesLabel;
  @FXML
  private Label maxTasksLabel;
  @FXML
  private Label text1;
  @FXML
  private Label text2;
  @FXML
  private Label text3;
  @FXML
  private Label text4;
  @FXML
  private Label text5;
  @FXML
  private Label text6;
  @FXML
  private Label text7;
  @FXML
  private Label text8;
  @FXML
  private Label text9;
  @FXML
  private Label text10;
  @FXML
  private Label text11;
  @FXML
  private Label text12;
  @FXML
  private Label text13;

  /**
   * Initializes a new SettingsController
   */
  public SettingsController() {
  }

  /**
   * Initializes a new SettingsController with the given stage
   *
   * @param stage the stage to be displayed
   */
  public SettingsController(Stage stage) {
    super(stage);
  }

  /**
   * Runs the settings view controller.
   */
  @Override
  public void run() {
    initElements();
  }

  /**
   * Initializes elements in the settings view controller.
   */
  @Override
  public void initElements() {
    initMenuBar();
    applyTheme();

    enterButton.setOnAction(event -> changePassword());
    weekNameButton.setOnAction(event -> changeWeekName());
    maxEntriesButton.setOnAction(event -> changeMaxEntries());
    maxTasksButton.setOnAction(event -> changeMaxTasks());

    themeButton.setOnAction(event -> {
      ThemeController tc = new ThemeController(getStage());
      switchScene("Customize Theme", new ThemeView(tc), tc);
    });
  }

  /**
   * Changes the password for the JavaJournal if a new one is actually provided
   */
  public void changePassword() {
    String newPassword = passwordField.getText();
    boolean canChange = model.getSettings().setPassword(newPassword);
    String labelTxt = canChange ? "Password successfully changed" : "Invalid password provided!";
    warningLabel.setText(labelTxt);
  }

  /**
   * Changes the name of the week and the window title if a new one is actually provided
   */
  public void changeWeekName() {
    String newName = weekNameField.getText();
    if (newName.length() > 0) {
      model.setWeekName(newName);
      getStage().setTitle(newName);
      warningLabel.setText("Week name successfully changed");
    } else {
      warningLabel.setText("Invalid week name provided");
    }
  }

  /**
   * Changes the number of entries a user can put per day
   */
  public void changeMaxEntries() {
    int maxEntries = Integer.parseInt(maxEntriesField.getText());
    if (maxEntries > 0) {
      model.setMaxNumEvents(maxEntries);
      warningLabel.setText("Maximum number of entries updated successfully");
    } else {
      warningLabel.setText("Invalid maximum provided. Please provide a number greater than zero");
    }
  }

  /**
   * Changes the number of tasks a user can put per day
   */
  public void changeMaxTasks() {
    int maxTasks = Integer.parseInt(maxTasksField.getText());
    if (maxTasks > 0) {
      model.setMaxNumTasks(maxTasks);
      warningLabel.setText("Maximum number of tasks updated successfully");
    } else {
      warningLabel.setText("Invalid maximum provided. Please provide a number greater than zero");
    }
  }

  /**
   * Organizes labels into their different 'types' (i.e. title vs body)
   */
  @Override
  public void makeLists() {
    titleLabels = new ArrayList<>(List.of(settingsTitle, warningLabel, actionTitle, text3));

    bodyLabels = new ArrayList<>(List.of(
        passwordLabel, weekNameLabel, maxEntriesLabel, maxTasksLabel,
        text1, text2, text4, text5, text6, text7,
        text8, text9, text10, text11, text12, text13
    ));

    allLabels = new ArrayList<>(titleLabels);
    allLabels.addAll(bodyLabels);
  }
}



















