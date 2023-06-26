package cs3500.pa05.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Theme.
 */
public class ThemeTest {
  private Theme light;
  private Theme dark;
  private Theme warm;
  private Theme cool;
  private Theme summer;
  private Theme fall;
  private Theme winter;
  private Theme spring;

  /**
   * Initializes themes before each test.
   */
  @BeforeEach
  public void setUp() {
    light = Theme.LIGHT;
    dark = Theme.DARK;
    warm = Theme.WARM;
    cool = Theme.COOL;
    summer = Theme.SUMMER;
    fall = Theme.FALL;
    winter = Theme.WINTER;
    spring = Theme.SPRING;
  }

  /**
   * Tests that each theme returns the correct pane color.
   */
  @Test
  public void testGetPaneColor() {
    assertEquals("#d9d9d9", light.getPaneColor());
    assertEquals("#282828", dark.getPaneColor());
    assertEquals("#ffa298", warm.getPaneColor());
    assertEquals("#39b9d3", cool.getPaneColor());
    assertEquals("#f2f480", summer.getPaneColor());
    assertEquals("#d5a74e", fall.getPaneColor());
    assertEquals("#626ea1", winter.getPaneColor());
    assertEquals("#ef798a", spring.getPaneColor());
  }

  /**
   * Tests that each theme returns the correct background color.
   */
  @Test
  public void testGetBackgroundColor() {
    assertEquals("#f6f6f6", light.getBackgroundColor());
    assertEquals("#565656", dark.getBackgroundColor());
    assertEquals("#ffceaa", warm.getBackgroundColor());
    assertEquals("#97cdff", cool.getBackgroundColor());
    assertEquals("#ffe58c", summer.getBackgroundColor());
    assertEquals("#f8ba71", fall.getBackgroundColor());
    assertEquals("#9dafd4", winter.getBackgroundColor());
    assertEquals("#ffbcbb", spring.getBackgroundColor());
  }

  /**
   * Tests that each theme returns the correct text color.
   */
  @Test
  public void testGetTextColor() {
    assertEquals("#000000", light.getTextColor());
    assertEquals("#ffffff", dark.getTextColor());
    assertEquals("#8c2f39", warm.getTextColor());
    assertEquals("#01295f", cool.getTextColor());
    assertEquals("#ffffff", summer.getTextColor());
    assertEquals("#720307", fall.getTextColor());
    assertEquals("#42246d", winter.getTextColor());
    assertEquals("#def4c6", spring.getTextColor());
  }
}