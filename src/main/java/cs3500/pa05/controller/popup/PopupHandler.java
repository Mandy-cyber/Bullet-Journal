package cs3500.pa05.controller.popup;

import cs3500.pa05.controller.WeekController;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.WeekModel;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Handles popups.
 */
public class PopupHandler {
  // New Event
  @FXML
  private Button eventAdd;
  @FXML
  private Button eventCancel;
  @FXML
  private TextField eventNameText;
  @FXML
  private TextField eventWeekDayText;
  @FXML
  private TextField startTimeText;
  @FXML
  private TextField durationText;
  @FXML
  private TextArea eventDetailsText;

  // New Task
  @FXML
  private Button taskAdd;
  @FXML
  private Button taskCancel;
  @FXML
  private TextField taskNameText;
  @FXML
  private TextField taskWeekDayText;
  @FXML
  private TextArea taskDetailsText;

  // privacy popup
  @FXML
  private TextField passwordField;
  @FXML
  private Button passwordButton;
  @FXML
  private Label warningLabel;

  // popups
  private final Stage stage;
  private WeekModel model;
  private Popup newEventPopup;

  private Popup newTaskPopup;
  private final WeekController wc;

  /**
   * Constructs a new PopupHandler.
   *
   * @param stage - the stage it's constructed on
   * @param model - the model it's storing data in
   * @param wc    - the week controller
   */
  public PopupHandler(Stage stage, WeekModel model, WeekController wc) {
    System.out.println("Popup handler created!");
    this.stage = stage;
    this.model = model;
    this.wc = wc;
    setupNewEventPopup();
    setupNewTaskPopup();
  }

  /**
   * Shows a new event pop up.
   */
  @FXML
  public void makeNewEventPopup() {
    this.newEventPopup.show(this.stage);
  }

  /**
   * Shows a new task pop up.
   */
  @FXML
  public void makeNewTaskPopup() {
    this.newTaskPopup.show(this.stage);
  }

  /**
   * Sets up the event pop up and gives it functionality.
   */
  // :D
  private void setupNewEventPopup() {
    this.newEventPopup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("NewEvent.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
      eventNameText = (TextField) loader.getNamespace().get("eventNameText");
      eventWeekDayText = (TextField) loader.getNamespace().get("eventWeekDayText");
      startTimeText = (TextField) loader.getNamespace().get("startTimeText");
      durationText = (TextField) loader.getNamespace().get("durationText");
      eventDetailsText = (TextArea) loader.getNamespace().get("eventDetailsText");
      eventAdd = (Button) loader.getNamespace().get("addButtonEvent");
      eventCancel = (Button) loader.getNamespace().get("cancelButtonEvent");
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert s != null;
    newEventPopup.getContent().add(s.getRoot());
    eventAdd.setOnAction(e -> {
          newEventPopup.hide();
          processNewEventInputs(eventNameText, eventWeekDayText, startTimeText,
              durationText, eventDetailsText);
          if (wc.checkMaxEventsExceeded()) {
            wc.displayEventsExceededAlert();
          }
        }
    );
    eventCancel.setOnAction(e -> newEventPopup.hide());
  }

  /**
   * Processes the user input for events and stores the data.
   *
   * @param eventNameText    - user input name of the event
   * @param eventWeekDayText - what day the event will be on
   * @param startTimeText    - when the event will start
   * @param durationText     - how long the event will be
   * @param eventDetailsText - the event details
   */
  private void processNewEventInputs(TextField eventNameText, TextField eventWeekDayText,
                                     TextField startTimeText, TextField durationText,
                                     TextArea eventDetailsText) {
    StringBuilder sb = new StringBuilder();
    for (CharSequence line : eventDetailsText.getParagraphs()) {
      sb.append(line.toString());
    }
    DayType dayOfWeek = DayType.stringToDayType(eventWeekDayText.getCharacters().toString());
    Event event = new Event("Event", eventNameText.getCharacters().toString(),
        sb.toString(), dayOfWeek,
        new Time(startTimeText.getCharacters().toString()),
        new Time(durationText.getCharacters().toString()));
    assert dayOfWeek != null;
    model.getDays().get(dayOfWeek.ordinal()).addEntry(event);
    System.out.println(model.toString());
    wc.updateEntries(event, dayOfWeek);
  }

  /**
   * Sets up the task pop up and gives it functionality.
   */
  private void setupNewTaskPopup() {
    this.newTaskPopup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("NewTask.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
      taskNameText = (TextField) loader.getNamespace().get("taskNameText");
      taskWeekDayText = (TextField) loader.getNamespace().get("taskWeekDayText");
      taskDetailsText = (TextArea) loader.getNamespace().get("taskDetailsText");
      taskAdd = (Button) loader.getNamespace().get("addButtonTask");
      taskCancel = (Button) loader.getNamespace().get("cancelButtonTask");
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert s != null;
    newTaskPopup.getContent().add(s.getRoot());
    taskAdd.setOnAction(e -> {
          newTaskPopup.hide();
          processNewTaskInputs(taskNameText, taskWeekDayText, taskDetailsText);
          if (wc.checkMaxTasksExceeded()) {
            wc.displayTasksExceededAlert();
          }
        }
    );
    taskCancel.setOnAction(e -> newTaskPopup.hide());
  }


  /**
   * Processes the user input for tasks and stores the data.
   *
   * @param taskNameText    - name of the task
   * @param taskWeekDayText - day of the week
   * @param taskDetailsText - task details
   */
  private void processNewTaskInputs(TextField taskNameText, TextField taskWeekDayText,
                                    TextArea taskDetailsText) {
    StringBuilder sb = new StringBuilder();
    for (CharSequence line : taskDetailsText.getParagraphs()) {
      sb.append(line.toString());
    }
    DayType dayOfWeek = DayType.stringToDayType(taskWeekDayText.getCharacters().toString());
    // Task is not complete by default.
    Task task = new Task("Task", taskNameText.getCharacters().toString(),
        sb.toString(), dayOfWeek, false);
    assert dayOfWeek != null;
    model.getDays().get(dayOfWeek.ordinal()).addEntry(task);
    wc.updateEntries(task, dayOfWeek);
  }

  /**
   * Sets the model to the given model.
   *
   * @param model - the model to set it to
   */
  public void setModel(WeekModel model) {
    this.model = model;
  }
}
