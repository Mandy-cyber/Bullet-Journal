package cs3500.pa05.controller;

import cs3500.pa05.controller.popup.PopupHandler;
import cs3500.pa05.model.WeekModel;
import cs3500.pa05.model.io.BujoFileWriter;
import cs3500.pa05.model.io.FileReader;
import cs3500.pa05.model.io.FileWriter;
import cs3500.pa05.model.settings.Font;
import cs3500.pa05.model.settings.Settings;
import cs3500.pa05.model.settings.Theme;
import cs3500.pa05.view.OpenView;
import cs3500.pa05.view.SettingsView;
import cs3500.pa05.view.ThemeView;
import cs3500.pa05.view.View;
import cs3500.pa05.view.WeekView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents a controller for the bullet journal.
 */
public abstract class Controller {
  protected WeekModel model;
  protected FileReader reader;
  protected FileWriter writer;
  protected String fileName;
  protected Stage stage;
  protected PopupHandler popupHandler;
  //protected boolean weekHasBeenLoaded;
  private static HostServices hostServices;
  @FXML
  protected Scene scene;
  @FXML
  private VBox mainFrame;
  // LISTS
  protected List<Label> allLabels = new ArrayList<>();
  protected List<Label> titleLabels = new ArrayList<>();
  protected List<Label> bodyLabels = new ArrayList<>();
  protected List<Button> allButtons = new ArrayList<>();
  protected List<Button> paneButtons = new ArrayList<>();
  protected List<Button> menuButtons = new ArrayList<>();
  protected List<VBox> panes = new ArrayList<>();
  protected List<VBox> centerPanes = new ArrayList<>();

  // menu bar buttons
  @FXML
  private Button save;
  @FXML
  private Button open;
  @FXML
  private Button newEvent;
  @FXML
  private Button newTask;
  @FXML
  private Button newWeek;
  @FXML
  private Button homeButton;
  @FXML
  private Button theme;
  @FXML
  private Button settings;

  private final KeyCombination openKeys =
      new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
  private final KeyCombination openKeysMac =
      new KeyCodeCombination(KeyCode.O, KeyCombination.META_DOWN);
  private final KeyCombination saveKeys =
      new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
  private final KeyCombination saveKeysMac =
      new KeyCodeCombination(KeyCode.S, KeyCombination.META_DOWN);
  private final KeyCombination newWeekKeys =
      new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
  private final KeyCombination newWeekKeysMac =
      new KeyCodeCombination(KeyCode.N, KeyCombination.META_DOWN);
  private final KeyCombination newEventKeys =
      new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN);

  private final KeyCombination newEventKeysMac =
      new KeyCodeCombination(KeyCode.E, KeyCombination.META_DOWN);
  private final KeyCombination newTaskKeys =
      new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);
  private final KeyCombination newTaskKeysMac =
      new KeyCodeCombination(KeyCode.T, KeyCombination.META_DOWN);
  private final KeyCombination changeAppearanceKeys =
      new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);
  private final KeyCombination changeAppearanceKeysMac =
      new KeyCodeCombination(KeyCode.P, KeyCombination.META_DOWN);

  private final Button openShort = new Button("Mnemonic");
  private final Button saveShort = new Button("Mnemonic");
  private final Button newWeekShort = new Button("Mnemonic");
  private final Button newEventShort = new Button("Mnemonic");
  private final Button newTaskShort = new Button("Mnemonic");
  private final Button changeAppearanceShort = new Button("Mnemonic");

  Mnemonic openMn = new Mnemonic(openShort, openKeys);
  Mnemonic openMacMn = new Mnemonic(openShort, openKeysMac);
  Mnemonic saveMn = new Mnemonic(saveShort, saveKeys);
  Mnemonic saveMacMn = new Mnemonic(saveShort, saveKeysMac);
  Mnemonic newWeekMn = new Mnemonic(newWeekShort, newWeekKeys);
  Mnemonic newWeekMacMn = new Mnemonic(newWeekShort, newWeekKeysMac);
  Mnemonic newEventMn = new Mnemonic(newEventShort, newEventKeys);
  Mnemonic newEventMacMn = new Mnemonic(newEventShort, newEventKeysMac);
  Mnemonic newTaskMn = new Mnemonic(newTaskShort, newTaskKeys);
  Mnemonic newTaskMacMn = new Mnemonic(newTaskShort, newTaskKeysMac);
  Mnemonic changeAppearanceMn = new Mnemonic(changeAppearanceShort, changeAppearanceKeys);
  Mnemonic changeAppearanceMacMn = new Mnemonic(changeAppearanceShort, changeAppearanceKeysMac);

  List<Mnemonic> shortcuts =
      List.of(openMn, openMacMn, saveMn, saveMacMn, newWeekMn, newWeekMacMn, newEventMn,
          newEventMacMn, newTaskMn, newTaskMacMn, changeAppearanceMn, changeAppearanceMacMn);

  /**
   * Initializes a new Controller for a JavaJournal
   */
  public Controller() {
    this.model = new WeekModel();
  }

  /**
   * Initializer used with pop-ups
   *
   * @param stage - the stage that needs to be loaded
   */
  public Controller(Stage stage) {
    this.model = new WeekModel();
    this.stage = stage;
    this.scene = stage.getScene();
    System.out.println("I'm going to create a popup now!");
  }

  /**
   * Runs the controller.
   */
  public abstract void run();

  /**
   * Organizes all lists into their different 'types' (i.e. title vs body)
   */
  public abstract void makeLists();

  /**
   * Initializes elements in the controller.
   */
  public abstract void initElements();

  /**
   * Initializes the menu bar and its buttons
   */
  public void initMenuBar() {
    makeLists();
    menuButtons.addAll(
        List.of(save, newEvent, newTask, newWeek, open, homeButton, theme, settings));
    weekLoadedOptions();
    nonDependentOptions();
  }

  /**
   * Sets up shortcuts that depend on whether a week has been loaded or not.
   */
  private void weekLoadedOptions() {
    // OPTIONS FOR WHEN A WEEK HAS BEEN LOADED
    save.setOnAction(e -> {
      save.setBackground(new Background(
          new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
      writer.write(model.toString());
    });

    saveShort.setOnAction(e -> writer.write(model.toString()));

    newEvent.setOnAction(e -> {
      popupHandler.makeNewEventPopup();
      System.out.println("New Event Button Pressed");
    });

    newEventShort.setOnAction(e -> {
      //      popupHandler.makePrivacyPopup();
      popupHandler.makeNewEventPopup();
      System.out.println("New Event Button Pressed");
    });

    newTask.setOnAction(e -> {
      popupHandler.makeNewTaskPopup();
      System.out.println("New Task Button Pressed");
    });

    newTaskShort.setOnAction(e -> {
      popupHandler.makeNewTaskPopup();
      System.out.println("New Task Button Pressed");
    });

    homeButton.setOnAction(e -> {
      WeekController wc = new WeekController(stage);
      switchScene(model.getWeekName(), new WeekView(wc), wc);
    });
  }

  /**
   * Sets up shortcuts that do not depend on whether a week
   * has been loaded.
   */
  private void nonDependentOptions() {
    // OPTIONS FOR WHETHER, OR NOT, A WEEK HAS BEEN LOADED
    open.setOnAction(e -> {
      OpenController oc = new OpenController(stage);
      switchScene("Open Week", new OpenView(oc), oc);
    });

    openShort.setOnAction(e -> {
      OpenController oc = new OpenController(stage);
      switchScene("Open Week", new OpenView(oc), oc);
    });

    newWeek.setOnAction(e -> makeNewWeek());

    newWeekShort.setOnAction(e -> makeNewWeek());

    theme.setOnAction(e -> {
      ThemeController tc = new ThemeController(stage);
      switchScene("Customize Theme", new ThemeView(tc), tc);
    });

    changeAppearanceShort.setOnAction(e -> {
      ThemeController tc = new ThemeController(stage);
      switchScene("Customize Theme", new ThemeView(tc), tc);
    });

    settings.setOnAction(e -> {
      SettingsController sc = new SettingsController(stage);
      switchScene("Settings", new SettingsView(sc), sc);
    });
  }

  /**
   * Switches to the scene represented in the given view, and sets a new title for the stage
   *
   * @param stageTitle the new title of the stage
   * @param view       the new view for the stage
   * @param controller the new controller for the stage
   */
  public void switchScene(String stageTitle, View view, Controller controller) {
    Scene newScene = view.load();
    for (Mnemonic mn : shortcuts) {
      newScene.addMnemonic(mn);
    }
    Stage current = getStage();
    current.setScene(newScene);
    current.setTitle(stageTitle);
    // updating new controller
    controller.setWriter(this.writer);
    controller.setModel(this.model);
    controller.run();
    current.show();

    this.stage = current;
    System.out.println("Scene/Stage switched!");
  }

  /**
   * Applies the theme to this controller's view if a week has been loaded
   */
  public void applyTheme() {
    if (model == null) {
      model = new WeekModel();
    }
    panes.add(mainFrame);
    makeLists();
    // settings + font
    Settings modelSettings = model.getSettings();
    Theme journalTheme = modelSettings.getTheme();
    Font newFont = modelSettings.getFont();
    int fontSize = modelSettings.getFontSize();
    // colors
    Color paneColor = Color.web(journalTheme.getPaneColor());
    Color bgColor = Color.web(journalTheme.getBackgroundColor());
    Color fontColor = Color.web(modelSettings.getFontColor());

    // CHANGE FONT STUFF
    for (Label label : allLabels) {
      label.setTextFill(fontColor);
      if (!titleLabels.contains(label)) {
        label.setFont(javafx.scene.text.Font.font(newFont.getFontName(), fontSize));
      } else {
        label.setFont(javafx.scene.text.Font.font(newFont.getFontName(), 36));
      }
    }
    // CHANGE APPEARANCE
    if (mainFrame != null) {
      mainFrame.setBackground(
          new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    Background paneBg = new Background(
        new BackgroundFill(paneColor, new CornerRadii(5), Insets.EMPTY));
    Background otherBg = new Background(
        new BackgroundFill(bgColor, new CornerRadii(5), Insets.EMPTY));

    for (Button button : allButtons) {
      button.setTextFill(fontColor);
      Background b = (paneButtons.contains(button)) ? otherBg : paneBg;
      button.setBackground(b);
    }
    for (VBox pane : panes) {
      pane.setBackground(paneBg);
      if (centerPanes.contains(pane)) {
        pane.setAlignment(Pos.BASELINE_CENTER);
        pane.setSpacing(10);
      }
    }
  }


  /**
   * Creates a new bujo file with a blank week
   */
  public void makeNewWeek() {
    String root = "src/main/resources/";
    String newFileName = "";
    model = new WeekModel();
    // make sure existing files aren't accidentally override. Make e.g. untitled1.bujo
    int fileNum = 0;
    String newFile = "untitled";
    File file = new File(root, newFile + ".bujo");
    while (file.exists()) {
      fileNum++;
      newFileName = newFile + fileNum + ".bujo";
      file = new File(root, newFileName);
    }
    // write empty week to the file
    this.fileName = root + newFileName;
    this.writer = new BujoFileWriter(file);
    this.writer.write(model.toString());
    WeekController wc = new WeekController(stage);
    switchScene("Untitled Week", new WeekView(wc), wc);
  }

  /**
   * Sets the model of this controller
   *
   * @param model the WeekModel to give to this controller
   */
  public void setModel(WeekModel model) {
    this.model = model;
  }

  /**
   * Gets the stage for the controller.
   *
   * @return - the stage
   */
  public Stage getStage() {
    return stage;
  }

  /**
   * Sets the file writer for the controller
   *
   * @param newWriter the writer to be used
   */
  public void setWriter(FileWriter newWriter) {
    this.writer = newWriter;
  }

  /**
   * Sets the instance of popup handler.
   *
   * @param popupHandler - the popup handler to set
   */
  public void setPopupHandler(PopupHandler popupHandler) {
    this.popupHandler = popupHandler;
  }

  /**
   * Sets the host services (for links).
   *
   * @param hostServices - the instance to set
   */
  public void setHostServices(HostServices hostServices) {
    Controller.hostServices = hostServices;
  }

  /**
   * Gets the host services (for links).
   *
   * @return the host services
   */
  public static HostServices getHostServices() {
    return hostServices;
  }
}
