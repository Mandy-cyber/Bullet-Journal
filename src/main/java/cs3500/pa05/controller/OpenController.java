package cs3500.pa05.controller;

import cs3500.pa05.model.WeekModel;
import cs3500.pa05.model.io.BujoFileReader;
import cs3500.pa05.model.io.BujoFileWriter;
import cs3500.pa05.model.io.FileReader;
import cs3500.pa05.view.PrivacyView;
import cs3500.pa05.view.SettingsView;
import cs3500.pa05.view.WeekView;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents a controller for the 'Open Week' view
 */
public class OpenController extends Controller {
  @FXML
  private Label openWeekTitle;
  @FXML
  private Label templateTitle;
  @FXML
  private Label warningLabel;
  @FXML
  private TextField chosenFile;
  @FXML
  private ChoiceBox<String> tempBox;
  @FXML
  private Button openButton;
  @FXML
  private Button cancelButton;

  /**
   * Initializes a new OpenController using the given stage
   *
   * @param stage the stage for the open view controller
   */
  public OpenController(Stage stage) {
    super(stage);
  }


  /**
   * Runs the controller.
   */
  @Override
  public void run() {
    initElements();
  }

  /**
   * Organizes labels into their different 'types' (i.e. title vs body)
   */
  @Override
  public void makeLists() {
    allLabels = new ArrayList<>();
    titleLabels = new ArrayList<>();
    bodyLabels = new ArrayList<>();

    titleLabels.add(openWeekTitle);
    bodyLabels.addAll(List.of(warningLabel, templateTitle));
    allLabels.addAll(titleLabels);
    allLabels.addAll(bodyLabels);

    paneButtons = new ArrayList<>();
    paneButtons.add(openButton);
    paneButtons.add(cancelButton);
    allButtons = new ArrayList<>(paneButtons);
  }

  /**
   * Initializes elements in the controller.
   */
  @Override
  public void initElements() {
    initMenuBar();
    makeLists();
    applyTheme();

    warningLabel.setText("Provide the full path to the file <3");
    openButton.setOnAction(e -> openFile(chosenFile.getText()));
    cancelButton.setOnAction(e -> {
      WeekController wc = new WeekController(getStage());
      switchScene(model.getWeekName(), new WeekView(wc), wc);
    });

    List<String> tempOptions = new ArrayList<>(List.of("Spring", "Winter", "Fall", "Summer"));
    tempBox.getItems().addAll(tempOptions);
    tempBox.getSelectionModel().selectedIndexProperty().addListener((ov, value, newValue) ->
        openTemplateFile(tempOptions.get(newValue.intValue())));
  }

  /**
   * Gets the file the user chooses to open and validates that it is an existing file,
   * before using it to update this controller's Model. Changes warning text if
   * file does not exist.
   *
   * @param fileToOpen the file to be opened
   */
  public void openFile(String fileToOpen) {
    File file = new File(fileToOpen);

    if (file.exists()) {
      // file exists
      FileReader reader = new BujoFileReader(file);
      WeekModel week = reader.jsonToWeek(reader.read());
      setModel(week);
      setWriter(new BujoFileWriter(file));
      WeekController wc = new WeekController(getStage());
      PrivacyController pc = new PrivacyController(wc, getStage());
      switchScene(model.getWeekName(), new WeekView(wc), wc);
      switchScene("Privacy Lock", new PrivacyView(pc), pc);
    } else {
      // give them a warning
      warningLabel.setText("File does not exist... Try again!");
    }
  }

  /**
   * Makes a copy of, and opens, the given template for the user to start with
   *
   * @param template the name of the template chosen
   */
  public void openTemplateFile(String template) {
    String s = File.separator;
    // determine template file
    String fileToCopy = "src" + s + "main" + s + "resources" + s + template.toLowerCase();
    String ext = ".bujo";

    // makes a copy and does not override any other copies
    Path realTemplate = Paths.get(fileToCopy);
    String sourceFileName = realTemplate.getFileName().toString();
    String newFileName = sourceFileName + "_copy";
    Path newPath = realTemplate.resolveSibling(newFileName);

    int num = 0;
    while (Files.exists(newPath)) {
      newFileName = fileToCopy + "_copy" + num;
      newPath = realTemplate.resolveSibling(newFileName + ext);
      num++;
    }

    String finalPath = newPath + ext;
    File file = new File(finalPath);

    this.reader = new BujoFileReader(new File(realTemplate.toFile() + ext));
    this.writer = new BujoFileWriter(file);
    this.fileName = newPath.getFileName().toString();

    // write template week to the file
    WeekModel weekTemp = reader.jsonToWeek(reader.read());
    this.model = weekTemp;
    this.writer.write(weekTemp.toString());
    SettingsController sc = new SettingsController(stage);
    switchScene("Settings", new SettingsView(sc), sc);
  }
}









