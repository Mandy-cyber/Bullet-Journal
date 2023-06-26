package cs3500.pa05;

import cs3500.pa05.controller.SplashController;
import cs3500.pa05.view.SplashView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Driver class where the program is called.
 */
public class Driver extends Application {

  /**
   * The main entry point for all JavaFX applications.
   * The start method is called after the init method has returned,
   * and after the system is ready for the application to begin running.
   *
   * <p>
   * NOTE: This method is called on the JavaFX Application Thread.
   * </p>
   *
   * @param stage the primary stage for this application, onto which
   *                     the application scene can be set.
   *                     Applications may create other stages, if needed, but they will not be
   *                     primary stages.
   * @throws IllegalStateException if a view could not be loaded
   */
  @Override
  public void start(Stage stage) {
    SplashController splashController = new SplashController(stage);
    SplashView view = new SplashView(splashController);
    splashController.setHostServices(getHostServices());

    try {
      // load and place the view's scene onto the stage
      stage.setScene(view.load());
      stage.setTitle("Welcome");

      // run controller and render the stage
      splashController.run();
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Oopsie daisy, unable to load the GUI!");
    }
  }

  /**
   * Main entry point for the code.
   *
   * @param args - command line arguments.
   */
  public static void main(String[] args) {
    launch();
  }
}
