package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents a GUI view for the bullet journal.
 */
public interface View {


  /**
   * Loads the corresponding JavaFX scene.
   *
   * @return - the layout
   * @throws IllegalStateException - throws if layout is unable to be loaded
   */
  Scene load() throws IllegalStateException;
}
