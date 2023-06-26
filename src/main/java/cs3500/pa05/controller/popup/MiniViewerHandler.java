package cs3500.pa05.controller.popup;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.Function;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Handler for new windows (as part of the Mini Viewer).
 */
public class MiniViewerHandler {
  @FXML
  private Button eventClose;
  @FXML
  private Label eventNameLabel;
  @FXML
  private Label startLabel;
  @FXML
  private Label durationLabel;
  @FXML
  private Label descriptionLabel;
  @FXML
  private VBox eventLinkBox;
  @FXML
  private Label taskNameLabel;
  @FXML
  private Label taskDescriptionLabel;
  @FXML
  protected Button taskCloseButton;
  @FXML
  private CheckBox taskCheckbox;
  @FXML
  private VBox taskLinkBox;
  @FXML
  private Label taskStatus;

  /**
   * View the event through a popup.
   *
   * @param event - the event to be viewed
   */
  public void viewEvent(Event event) {
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ViewEvent.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
      eventClose = (Button) loader.getNamespace().get("eventClose");
      eventNameLabel = (Label) loader.getNamespace().get("eventNameLabel");
      startLabel = (Label) loader.getNamespace().get("startLabel");
      durationLabel = (Label) loader.getNamespace().get("durationLabel");
      descriptionLabel = (Label) loader.getNamespace().get("descriptionLabel");
      eventLinkBox = (VBox) loader.getNamespace().get("eventLinkBox");
    } catch (IOException e) {
      e.printStackTrace();
    }
    eventNameLabel.setText(event.getName());
    startLabel.setText(event.getStartTime().toString());
    durationLabel.setText(event.getDuration().toString());
    descriptionLabel.setText(event.getDescription());
    descriptionLabel.setWrapText(true);

    // Add the links
    addLinksToContainer(event, eventLinkBox);

    Stage stage = new Stage();
    stage.setTitle("View Event");
    stage.setScene(s);
    stage.show();
    eventClose.setOnAction(e -> stage.close());
  }

  /**
   * Finds and parses hyperlinks in the given string.
   *
   * @param s - the string to search
   * @return - a list of all the links found
   */
  private List<String> parseLinks(String s) {
    List<String> links = new ArrayList<>();

    String regexPattern = "\\b(?:https?://|www\\.)\\S+\\b";
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
      String link = matcher.group();
      links.add(link);
    }

    return links;
  }

  private void addLinksToContainer(Entry entry, VBox box) {
    List<String> links = parseLinks(entry.getDescription());
    if (links.size() > 0) {
      box.getChildren().add(new Label("Links:"));
    }
    for (String link : links) {
      Hyperlink hyperlink = new Hyperlink(link);
      hyperlink.setOnAction(this::handleLinkPress);
      box.getChildren().add(hyperlink);
    }
  }

  /**
   * Sends the user to the given link after clicked.
   *
   * @param event - the trigger to send the person to the link
   */
  private void handleLinkPress(ActionEvent event) {
    System.out.println("Trying link!");
    Hyperlink link = (Hyperlink) event.getSource();
    Controller.getHostServices().showDocument(link.getText());
  }

  /**
   * View the task through a popup.
   *
   * @param task - the task to be viewed
   */
  public void viewTask(Task task) {
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ViewTask.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
      taskCloseButton = (Button) loader.getNamespace().get("taskCloseButton");
      taskNameLabel = (Label) loader.getNamespace().get("taskNameLabel");
      taskDescriptionLabel = (Label) loader.getNamespace().get("taskDescriptionLabel");
      taskCheckbox = (CheckBox) loader.getNamespace().get("taskCheckbox");
      taskLinkBox = (VBox) loader.getNamespace().get("taskLinkBox");
      taskStatus = (Label) loader.getNamespace().get("taskStatus");
    } catch (IOException e) {
      e.printStackTrace();
    }
    taskNameLabel.setText(task.getName());
    taskStatus.setText(""); // placeholder will be updated
    taskDescriptionLabel.setText(task.getDescription());
    taskDescriptionLabel.setWrapText(true);
    addLinksToContainer(task, taskLinkBox);
    taskStatusSetup(task, taskCheckbox, taskStatus);
    Stage stage = new Stage();
    stage.setTitle("View Event");
    stage.setScene(s);
    stage.show();
    taskCloseButton.setOnAction(e -> stage.close());
    taskCheckbox.setOnAction(e -> {
      if (taskCheckbox.isSelected()) {
        task.setAsComplete();
        taskStatus.setText("True");
      } else {
        task.setAsIncomplete();
        taskStatus.setText("False");
      }
    });
  }

  /**
   * Adds another event handler onto the taskCloseButton.
   *
   * @param func - the event handler to add to the button
   */
  public void setTaskCloseButtonOnAction(Function func) {
    taskCloseButton.addEventHandler(ActionEvent.ACTION, e -> func.apply());
  }

  /**
   * Helper method to aid with viewing a task, particularly
   * controlling setting up for whether it is seen as complete or not.
   *
   * @param task         - the task to set up
   * @param taskCheckbox - the task checkbox
   * @param taskStatus   - label for the status of the task
   */
  private void taskStatusSetup(Task task, CheckBox taskCheckbox, Label taskStatus) {
    if (task.checkIfComplete()) {
      taskCheckbox.setSelected(true);
      taskStatus.setText("True");
    } else {
      taskCheckbox.setSelected(false);
      task.setAsIncomplete();
      taskStatus.setText("False");
    }
  }
}
