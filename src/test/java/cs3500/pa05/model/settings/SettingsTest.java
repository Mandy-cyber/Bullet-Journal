package cs3500.pa05.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Settings.
 */
public class SettingsTest {
  Settings settings;

  /**
   * Initializes settings before testing.
   */
  @BeforeEach
  public void setup() {
    settings = new Settings("dark-default", Theme.DARK, Font.ARIAL, 24,
        "#ffffff", 3, 3, "password123", "quote");
  }

  /**
   * Tests that the correct name for settings is returned.
   */
  @Test
  public void testGetName() {
    assertEquals("dark-default", settings.getName());
  }

  /**
   * Tests that the correct string representation of settings is returned.
   */
  @Test
  public void testToString() {
    System.out.println(settings.toString());
    assertEquals(
        "{\"theme\":\"DARK\",\"font\":\"ARIAL\","
            + "\"password\":\"password123\",\"name\":\"dark-default\","
            + "\"fontSize\":24,\"fontColor\":\"#ffffff\",\"maxEvents\":3,"
            + "\"maxTasks\":3,\"quote\":\"quote\"}",
        settings.toString());
  }

  /**
   * Tests if the password can be set and that it has been set.
   */
  @Test
  public void testSetPassword() {
    assertTrue(settings.setPassword("hello"));
    assertEquals("hello", settings.getPassword());
    assertFalse(settings.setPassword(""));
  }

  /**
   * Tests that the quote can be set.
   */
  @Test
  public void testSetQuote() {
    settings.setQuote("To be, or not to be");
    assertEquals("To be, or not to be", settings.getQuote());
  }

  /**
   * Tests that the font color can be set.
   */
  @Test
  public void testSetFontColor() {
    settings.setFontColor("White");
    assertEquals("White", settings.getFontColor());
  }

  /**
   * Tests that the theme can be set.
   */
  @Test
  public void testSetTheme() {
    settings.setTheme(Theme.DARK);
    assertEquals(Theme.DARK, settings.getTheme());
  }

  /**
   * Tests that the font can be set.
   */
  @Test
  public void testSetFont() {
    settings.setFont(Font.TIMES_NEW_ROMAN);
    assertEquals(Font.TIMES_NEW_ROMAN, settings.getFont());
  }

  /**
   * Tests that the font size can be set.
   */
  @Test
  public void testSetFontSize() {
    settings.setFontSize(14);
    assertEquals(14, settings.getFontSize());
  }
}
