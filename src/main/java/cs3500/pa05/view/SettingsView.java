package cs3500.pa05.view;

import cs3500.pa05.controller.SettingsController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a GUI View to access and configure the settings.
 */
public class SettingsView implements View {
  private final FXMLLoader loader;

  /**
   * Constructs a new SettingsView.
   *
   * @param controller - the controller for the settings view
   */
  public SettingsView(SettingsController controller) {
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Settings.fxml"));
  }

  /**
   * Loads the Settings JavaFX scene.
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
