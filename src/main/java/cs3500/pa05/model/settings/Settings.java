package cs3500.pa05.model.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Represents the settings of a week in a bullet journal
 */
public class Settings {
  @JsonProperty
  private String name;
  @JsonProperty
  private Theme theme;
  @JsonProperty
  private Font font;
  @JsonProperty
  private int fontSize;
  @JsonProperty
  private String fontColor;
  @JsonProperty
  private int maxEvents;
  @JsonProperty
  private int maxTasks;
  @JsonProperty
  private String password;
  @JsonProperty
  private String quote;


  /**
   * Initialize default Settings
   */
  public Settings() {
    this.name = "Untitled";
    this.theme = Theme.LIGHT;
    this.font = Font.ARIAL;
    this.fontSize = 12;
    this.fontColor = theme.getTextColor();
    this.maxTasks = 20;
    this.maxEvents = 20;
    this.password = "password123";
    this.quote = "Lalala";
  }

  /**
   * Initializes Settings with preloaded values
   *
   * @param name the name of the week associated with these settings
   * @param theme the theme of the journal
   * @param font the font of the journal
   * @param fontSize the size of the font in the journal
   * @param fontColor the color of the font in the journal
   * @param maxEvents the maximum number of events allowed
   * @param maxTasks the maximum number of tasks allowed
   * @param password the password to open a certain week's bujo
   * @param quote the quote/note for the week
   */
  @JsonCreator
  public Settings(@JsonProperty("week-name") String name,
                  @JsonProperty("theme") Theme theme,
                  @JsonProperty("font") Font font,
                  @JsonProperty("font-size") int fontSize,
                  @JsonProperty("font-color") String fontColor,
                  @JsonProperty("max-events") int maxEvents,
                  @JsonProperty("max-tasks") int maxTasks,
                  @JsonProperty("password") String password,
                  @JsonProperty("week-quote") String quote) {
    this.name = name;
    this.theme = theme;
    this.font = font;
    this.fontSize = fontSize;
    this.fontColor = fontColor;
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;
    this.password = password;
    this.quote = quote;
  }


  /**
   * Writes these settings in string format
   *
   * @return the string format of these settings
   */
  @Override
  public String toString() {
    return new ObjectMapper().valueToTree(this).toString();
  }

  /**
   * Sets the maximum number of events allowed in the week.
   *
   * @param maxNumEvents - the max number of events allowed
   */
  public void setMaxNumEvents(int maxNumEvents) {
    this.maxEvents = maxNumEvents;
  }

  /**
   * Sets the maximum number of tasks allowed in the week.
   *
   * @param maxNumTasks - the max number of tasks allowed
   */
  public void setMaxNumTasks(int maxNumTasks) {
    this.maxTasks = maxNumTasks;
  }


  /**
   * Sets the name of this week's settings
   *
   * @param name the new name of the week
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the week associated with these settings
   *
   * @return the name of the week
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the theme of this week's settings
   *
   * @return the theme of the week's settings
   */
  public Theme getTheme() {
    return theme;
  }

  /**
   * Gets the font of this week's settings
   *
   * @return the font of the week's settings
   */
  public Font getFont() {
    return font;
  }

  /**
   * Gets the font size of this week's settings
   *
   * @return the font size of the week's settings
   */
  public int getFontSize() {
    return fontSize;
  }

  /**
   * Gets the font color of this week's settings
   *
   * @return the font color of the week's settings
   */
  public String getFontColor() {
    return fontColor;
  }

  /**
   * Gets the password of this week's settings
   *
   * @return the password of the week's settings
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the theme of this week's settings
   *
   * @param theme the new theme of the week's settings
   */
  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  /**
   * Sets the font of this week's settings
   *
   * @param font the new font of the week's settings
   */
  public void setFont(Font font) {
    this.font = font;
  }

  /**
   * Sets the font size of this week's settings
   *
   * @param size the new font size of the week's settings
   */
  public void setFontSize(int size) {
    this.fontSize = size;
  }

  /**
   * Sets the font color of this week's settings
   *
   * @param color the new font color of the week's settings
   */
  public void setFontColor(String color) {
    this.fontColor = color;
  }

  /**
   * Sets the password of this week's settings if it's a non-empty string
   *
   * @param password the new password of the week's settings
   * @return whether, or not, the password could be set
   */
  public boolean setPassword(String password) {
    if (password.length() > 0) {
      this.password = password;
      return true;
    }
    return false;
  }

  /**
   * Gets the quote of this week's settings
   *
   * @return the quote of the week's settings
   */
  public String getQuote() {
    return quote;
  }

  /**
   * Sets the quote for this week's settings
   *
   * @param quote the new quote for the week's settings
   */
  public void setQuote(String quote) {
    this.quote = quote;
  }
}













