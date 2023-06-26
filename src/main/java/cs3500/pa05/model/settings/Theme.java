package cs3500.pa05.model.settings;

/**
 * Represents the different themes available.
 */
public enum Theme {
  /**
   * Light mode
   */
  LIGHT("#d9d9d9", "#f6f6f6", "#000000"),
  /**
   * Dark mode
   */
  DARK("#282828", "#565656", "#ffffff"),
  /**
   * Warm mode
   */
  WARM("#ffa298", "#ffceaa", "#8c2f39"),
  /**
   * Cool mode
   */
  COOL("#39b9d3", "#97cdff", "#01295f"),
  /**
   * Spring theme
   */
  SPRING("#ef798a", "#ffbcbb", "#def4c6"),
  /**
   * Fall theme
   */
  FALL("#d5a74e", "#f8ba71", "#720307"),
  /**
   * Summer theme
   */
  SUMMER("#f2f480", "#ffe58c", "#ffffff"),
  /**
   * Winter theme
   */
  WINTER("#626ea1", "#9dafd4", "#42246d");

  private final String paneColor;
  private final String backgroundColor;
  private final String textColor;

  /**
   * Initializes a theme with the given hex-code color of panes and text
   *
   * @param paneColor       the color of the panes and buttons
   * @param backgroundColor the color of the background
   * @param textColor       the color of the text
   */
  Theme(String paneColor, String backgroundColor, String textColor) {
    this.paneColor = paneColor;
    this.backgroundColor = backgroundColor;
    this.textColor = textColor;
  }

  /**
   * Gets the pane color of this theme
   *
   * @return the pane color of the theme as a hex-code
   */
  public String getPaneColor() {
    return paneColor;
  }

  /**
   * Gets the background color of this theme
   *
   * @return the background color of the theme as a hex-code
   */
  public String getBackgroundColor() {
    return backgroundColor;
  }

  /**
   * Gets the text color of this theme
   *
   * @return the text color of the theme as a hex-code
   */
  public String getTextColor() {
    return textColor;
  }
}
