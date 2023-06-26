package cs3500.pa05.controller;

import cs3500.pa05.view.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controls the privacy lock.
 */
public class PrivacyController extends Controller {
  @FXML
  private TextField passwordField;
  @FXML
  private Button passwordButton;
  @FXML
  private Label warningLabel;
  private final WeekController wc;

  /**
   * Creates a new instance of PrivacyController.
   *
   * @param wc    - instance of week controller for this privacy controller
   * @param stage - the current stage for the application
   */
  public PrivacyController(WeekController wc, Stage stage) {
    super(stage);
    this.wc = wc;
  }

  /**
   * Runs the controller.
   */
  @Override
  public void run() {
    initElements();
  }

  /**
   * Organizes all lists into their different 'types' (i.e. title vs body)
   */
  @Override
  public void makeLists() {

  }

  /**
   * Initializes elements in the controller.
   */
  @Override
  public void initElements() {
    passwordButton.setOnAction(e -> {
      System.out.println(model.getSettings().getPassword());
      if (passwordField.getCharacters().toString().equals(model.getSettings().getPassword())) {
        switchScene(model.getWeekName(), new WeekView(wc), wc);
      } else {
        warningLabel.setText("Incorrect password. Try again!");
      }
    });
  }
}
