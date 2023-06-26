package cs3500.pa05.controller;

import cs3500.pa05.view.HomeView;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Represents a controller for the splash screen
 */
public class SplashController extends Controller {
  protected Stage stage;

  /**
   * Initializes the stage of this controller
   *
   * @param stage the stage for this controller
   */
  public SplashController(Stage stage) {
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

  }

  /**
   * Initializes elements in the controller.
   */
  @Override
  public void initElements() {
    initMenuBar();

    // stay on splash screen for 2 seconds
    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    delay.setOnFinished(event -> {
      Platform.runLater(() -> {
        HomeController hc = new HomeController(getStage());
        switchScene("Home", new HomeView(hc), hc);
      });
    });

    delay.play();
  }
}
