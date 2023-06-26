package cs3500.pa05.view;

import cs3500.pa05.controller.ThemeController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a GUI View to configure the theme of the bullet journal.
 */
public class ThemeView implements View {
  private final FXMLLoader loader;

  /**
   * Constructs a new ThemeView
   *
   * @param controller the controller for the ThemeView
   */
  public ThemeView(ThemeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Theme.fxml"));
  }

  /**
   * Loads the Themes JavaFX scene.
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
