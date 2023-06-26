package cs3500.pa05.controller;

import cs3500.pa05.model.settings.Font;
import cs3500.pa05.model.settings.Theme;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents a controller for the theme view.
 */
public class ThemeController extends Controller {
  @FXML
  private Label changeThemeTitle;
  @FXML
  private Label lowMarginText;
  @FXML
  private Label sliderValue;
  @FXML
  private Label highMarginText;
  @FXML
  private ChoiceBox<Theme> appearance;
  @FXML
  private ChoiceBox<Font> fontStyle;
  @FXML
  private Slider fontSize;
  @FXML
  private ColorPicker fontColor;
  @FXML
  private Label appearanceLabel;
  @FXML
  private Label fontStyleLabel;
  @FXML
  private Label fontSizeLabel;
  @FXML
  private Label fontColorLabel;


  /**
   * Initializes a new ThemeController
   */
  public ThemeController() {
  }

  /**
   * Initializes a new ThemeController with the given stage
   *
   * @param stage the stage to be displayed
   */
  public ThemeController(Stage stage) {
    super(stage);
  }

  /**
   * Runs the theme view controller.
   */
  @Override
  public void run() {
    initElements();
  }

  /**
   * Initializes elements in the theme view controller.
   */
  @Override
  public void initElements() {
    initMenuBar();
    makeLists();
    lowMarginText.setText("12");
    lowMarginText.setText("48");
    applyTheme();

    appearance.getItems().addAll(Theme.values());
    fontStyle.getItems().addAll(Font.values());
    // Appearance Change
    appearance.getSelectionModel().selectedIndexProperty().addListener((ov, value, newValue) -> {
      Theme newTheme = Theme.values()[newValue.intValue()];
      changeTheme(newTheme);
    });
    // Font Style Change
    fontStyle.getSelectionModel().selectedIndexProperty().addListener((ov, value, newValue) -> {
      Font newFont = Font.values()[newValue.intValue()];
      changeFont(newFont);
    });
    // Font Color Change
    fontColor.setOnAction(event -> changeColor(fontColor.getValue()));
    // Font Size Change
    fontSize.valueProperty().addListener(
        (observable, value, newValue) -> changeSize(newValue.intValue()));
  }

  /**
   * Organizes labels into their different 'types' (i.e. title vs body)
   */
  @Override
  public void makeLists() {
    titleLabels = new ArrayList<>();
    titleLabels.add(changeThemeTitle);

    bodyLabels = new ArrayList<>();
    bodyLabels.addAll(List.of(fontColorLabel, fontSizeLabel, fontStyleLabel, appearanceLabel));

    allLabels = new ArrayList<>();
    allLabels.addAll(titleLabels);
    allLabels.addAll(bodyLabels);
  }

  /**
   * Changes the appearance of the theme (e.g. background colors and pane colors) to match that
   * of the given theme.
   *
   * @param theme the new theme to be used
   */
  public void changeTheme(Theme theme) {
    model.getSettings().setTheme(theme);
    applyTheme();
  }

  /**
   * Changes the font of the theme to match that
   * of the given font.
   *
   * @param font the new font to be used
   */
  public void changeFont(Font font) {
    model.getSettings().setFont(font);
    applyTheme();
  }

  /**
   * Changes the size of body text (does not include size of titles)
   *
   * @param size the new size of the body text
   */
  public void changeSize(int size) {
    model.getSettings().setFontSize(size);
    sliderValue.setText(String.valueOf(size));
    applyTheme();
  }

  /**
   * Changes the color of all text in the application
   *
   * @param color the new color of the text
   */
  public void changeColor(Color color) {
    model.getSettings().setFontColor(color.toString());
    applyTheme();
  }
}
