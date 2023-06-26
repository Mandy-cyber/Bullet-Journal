package cs3500.pa05.controller;

import static cs3500.pa05.model.DayType.FRIDAY;
import static cs3500.pa05.model.DayType.MONDAY;
import static cs3500.pa05.model.DayType.SATURDAY;
import static cs3500.pa05.model.DayType.SUNDAY;
import static cs3500.pa05.model.DayType.THURSDAY;
import static cs3500.pa05.model.DayType.TUESDAY;
import static cs3500.pa05.model.DayType.WEDNESDAY;

import cs3500.pa05.controller.popup.MiniViewerHandler;
import cs3500.pa05.controller.popup.PopupHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents a controller for the week view.
 */
public class WeekController extends Controller {
  @FXML
  private Label lowMargin;
  @FXML
  private Label highMargin;
  @FXML
  private Label weekTitle;
  @FXML
  private Label sundayTitle;
  @FXML
  private Label mondayTitle;
  @FXML
  private Label tuesdayTitle;
  @FXML
  private Label wednesdayTitle;
  @FXML
  private Label thursdayTitle;
  @FXML
  private Label fridayTitle;
  @FXML
  private Label saturdayTitle;
  @FXML
  private Button button;
  // PANES
  @FXML
  private VBox sundayEntries;
  @FXML
  private VBox mondayEntries;
  @FXML
  private VBox tuesdayEntries;
  @FXML
  private VBox wednesdayEntries;
  @FXML
  private VBox thursdayEntries;
  @FXML
  private VBox fridayEntries;
  @FXML
  private VBox saturdayEntries;
  // NOTES STUFF
  @FXML
  private Button setNoteButton;
  @FXML
  private TextArea notesTextArea;
  @FXML
  private Label noteLabel;
  @FXML
  private Label actualNoteLabel;
  // PROGRESS BAR
  @FXML
  private Label progressLabel;
  @FXML
  private ProgressBar progressBar;
  private Alert exceededAlert;

  /**
   * Initializes a new WeekController
   */
  public WeekController() {
  }

  /**
   * Initializes a new WeekController with the given stage
   *
   * @param stage the stage to be displayed
   */
  public WeekController(Stage stage) {
    super(stage);
    scene.getStylesheets().add(
        String.valueOf(getClass().getClassLoader().getResource("/style/scrollstyle.css")));
    this.setPopupHandler(new PopupHandler(getStage(), model, this));
  }

  /**
   * Runs the week view controller.
   */
  @Override
  public void run() {
    initElements();
  }

  /**
   * Organizes lists into their different 'types' (i.e. title vs body)
   */
  @Override
  public void makeLists() {
    panes = new ArrayList<>();
    panes.addAll(List.of(
        sundayEntries, mondayEntries, tuesdayEntries, wednesdayEntries,
        thursdayEntries, fridayEntries, saturdayEntries));
    centerPanes.addAll(panes);

    allLabels = new ArrayList<>();
    bodyLabels = new ArrayList<>(
        List.of(noteLabel, actualNoteLabel, lowMargin, highMargin, progressLabel));

    titleLabels = new ArrayList<>(List.of(
        sundayTitle, mondayTitle, tuesdayTitle, wednesdayTitle, thursdayTitle,
        fridayTitle, saturdayTitle, weekTitle));

    allLabels.addAll(bodyLabels);
    allLabels.addAll(titleLabels);
  }

  /**
   * Initializes elements in the week view controller.
   */
  @Override
  public void initElements() {
    initMenuBar();
    weekTitle.setText(model.getWeekName());
    actualNoteLabel.setText(model.getSettings().getQuote());
    applyTheme();
    // displaying events & tasks
    for (int i = 0; i < 7; i++) {
      showEntries(panes.get(i), model.getDays().get(i));
      updateProgressBar();
    }
    this.popupHandler.setModel(model);
    notesTextArea.setText(model.getSettings().getQuote());
    setNoteButton.setOnAction(e -> {
      String newNote = notesTextArea.getText();
      model.getSettings().setQuote(newNote);
      actualNoteLabel.setText(newNote);
    });
    exceededAlert = new Alert(AlertType.ERROR);
    applyTheme();
  }

  /**
   * Handles changing placeholder Events, in a day's vbox, with actual events and tasks
   *
   * @param box the box to adjust
   * @param day the day of the week to adjust
   */
  public void showEntries(VBox box, Day day) {
    List<Entry> entries = day.getEntries();
    for (int i = 0; i < entries.size(); i++) {
      Button button = new Button();
      button.setId(day.getDayType().toString().toLowerCase() + i);
      Entry entry = entries.get(i);
      button.setText(entry.getName());
      button.setOnAction(this::handleEntryButtonPress);
      allButtons.add(button);
      box.getChildren().add(button);
    }
    applyTheme();
  }

  /**
   * Updates progress bar and label based on how many tasks have been completed.
   */
  public void updateProgressBar() {
    int totalTasks = 0;
    int tasksFinished = 0;
    StringBuilder progressText = new StringBuilder();
    progressText.append("Task Progress: ");
    for (Day day : model.getDays()) {
      for (Entry task : day.getTasks()) {
        if (((Task) task).checkIfComplete()) {
          tasksFinished++;
        }
        totalTasks++;
      }
    }
    if (totalTasks > 0) {
      progressBar.setProgress(((double) tasksFinished) / totalTasks);
      progressText.append(String.format("%.0f", (progressBar.getProgress() * 100))).append("%");
    } else {
      progressBar.setProgress(0);
      progressText.append(0).append("%");
    }
    progressLabel.setText(progressText.toString());
  }

  /**
   * Updates the entries and adds a button for the given entry.
   *
   * @param entry     - the entry to add
   * @param dayOfWeek - what day the entry takes place on
   */
  public void updateEntries(Entry entry, DayType dayOfWeek) {
    System.out.println(sundayEntries == null);
    VBox boxToAdd = switch (dayOfWeek) {
      case SUNDAY -> sundayEntries;
      case MONDAY -> mondayEntries;
      case TUESDAY -> tuesdayEntries;
      case WEDNESDAY -> wednesdayEntries;
      case THURSDAY -> thursdayEntries;
      case FRIDAY -> fridayEntries;
      case SATURDAY -> saturdayEntries;
    };
    Button button = new Button();
    button.setId(dayOfWeek.toString().toLowerCase() + (boxToAdd.getChildren().size()));
    button.setText(entry.getName());
    button.setOnAction(this::handleEntryButtonPress);
    paneButtons.add(button);
    allButtons.add(button);
    // updating other stuff
    updateProgressBar();
    boxToAdd.getChildren().add(button);
    applyTheme();
  }

  /**
   * Handles what happens when the entry button is pressed.
   *
   * @param event - the event triggering the method
   */
  public void handleEntryButtonPress(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();
    DayType dayOfWeek = null;
    int number = 0;
    for (int i = 0; i < clickedButton.getId().length(); i++) {
      if (!Character.isLetter(clickedButton.getId().charAt(i))) {
        dayOfWeek = DayType.stringToDayType(clickedButton.getId().substring(0, i));
        number = Integer.parseInt(clickedButton.getId().substring(i));
        break;
      }
    }
    assert dayOfWeek != null;
    int entryDayIndex = switch (dayOfWeek) {
      case SUNDAY -> SUNDAY.ordinal();
      case MONDAY -> MONDAY.ordinal();
      case TUESDAY -> TUESDAY.ordinal();
      case WEDNESDAY -> WEDNESDAY.ordinal();
      case THURSDAY -> THURSDAY.ordinal();
      case FRIDAY -> FRIDAY.ordinal();
      case SATURDAY -> SATURDAY.ordinal();
    };

    Entry entry = model.getDays().get(entryDayIndex).getEntries().get(number);
    MiniViewerHandler mini = new MiniViewerHandler();

    if (entry.getType().equals("Event")) {
      mini.viewEvent((Event) entry);
      updateProgressBar();
    } else {
      mini.viewTask((Task) entry);
      Function function = this::updateProgressBar;
      mini.setTaskCloseButtonOnAction(function);
      updateProgressBar();
    }

    System.out.println(model.toString());
  }

  /**
   * Display alert for when the maximum number of events is
   * exceeded.
   */
  public void displayEventsExceededAlert() {
    exceededAlert.setContentText("You've exceeded the set amount of events.");
    exceededAlert.show();
  }

  /**
   * Display alert for when the maximum number of tasks is
   * exceeded.
   */
  public void displayTasksExceededAlert() {
    exceededAlert.setContentText("You've exceeded the set amount of tasks.");
    exceededAlert.show();
  }

  /**
   * Check that the maximum number of events has been exceeded (call to model).
   *
   * @return whether max has been exceeded
   */
  public boolean checkMaxEventsExceeded() {
    return model.checkMaxNumEventsExceeded();
  }

  /**
   * Check that the maximum number of task has been exceeded (call to model).
   *
   * @return whether max has been exceeded
   */
  public boolean checkMaxTasksExceeded() {
    return model.checkMaxNumTasksExceeded();
  }
}
