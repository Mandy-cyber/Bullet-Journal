package cs3500.pa05.view;

import cs3500.pa05.controller.WeekController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a GUI View of the week and all the entries it contains.
 */
public class WeekView implements View {
  private final FXMLLoader loader;

  /**
   * Constructs a new instance of WeekView.
   *
   * @param controller - the controller for the view
   */
  public WeekView(WeekController controller) {
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("BlankWeek.fxml"));
  }

  /**
   * Loads the Week JavaFX scene.
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
