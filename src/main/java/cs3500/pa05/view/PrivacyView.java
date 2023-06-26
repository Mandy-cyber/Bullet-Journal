package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a GUI View for the privacy lock when the
 * user tries to open a file.
 */
public class PrivacyView implements View {
  private final FXMLLoader loader;

  /**
   * Constructs a new SplashView.
   *
   * @param controller - the controller for the splash view
   */
  public PrivacyView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Privacy.fxml"));
  }

  /**
   * Loads the corresponding JavaFX scene.
   *
   * @return - the layout
   * @throws IllegalStateException - throws if layout is unable to be loaded
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
