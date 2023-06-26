package cs3500.pa05.model.settings;

/**
 * Represents the available text fonts.
 */
public enum Font {
  /**
   * Arial font
   */
  ARIAL("Arial"),
  /**
   * System font
   */
  SYSTEM("System"),
  /**
   * Times New Roman font
   */
  TIMES_NEW_ROMAN("Times New Roman"),
  /**
   * Monospaced font
   */
  MONOSPACED("Monospaced"),
  /**
   * Optima font
   */
  OPTIMA("Optima"),
  /**
   * Comic Sans font
   */
  COMIC_SANS("Comic Sans MS");

  private final String fontName;

  /**
   * Initializes a Font with the given font name
   *
   * @param fontName the name of the font
   */
  Font(String fontName) {
    this.fontName = fontName;
  }

  /**
   * Gets the name of this font
   *
   * @return the name of this font
   */
  public String getFontName() {
    return fontName;
  }
}
