package cs3500.pa05.view;

import cs3500.pa05.controller.HomeController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a GUI View of the home screen.
 */
public class HomeView implements View {
  private final FXMLLoader loader;

  /**
   * Constructs a new HomeView.
   *
   * @param controller - the controller for the home view
   */
  public HomeView(HomeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Home.fxml"));
  }

  /**
   * Loads the Home JavaFX scene.
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
