package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.text.html.ImageView;

/**
 * Represents a controller for home screen.
 */
public class HomeController extends Controller {
  @FXML
  private Label titleText;
  @FXML
  private Label descriptionText;
  @FXML
  private ImageView image;

  /**
   * Initializes a new HomeController
   */
  public HomeController() {}

  /**
   * Initializes a new HomeController with the given stage
   *
   * @param stage the stage to be displayed
   */
  public HomeController(Stage stage) {
    super(stage);
  }

  /**
   * Runs the home view controller.
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
    // in a better world, the home page would also have a space on the menu bar and hence be
    // customizable... this is not a better world
  }

  /**
   * Initializes elements in the home view controller.
   */
  @Override
  public void initElements() {
    initMenuBar();
    applyTheme();
  }
}




