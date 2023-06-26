package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Represents tests for a Time object.
 */
public class TimeTest {
  Time time;

  /**
   * Initializes times before each test.
   */
  @Test
  public void testStringToTime() {
    time = new Time(3, 4);
    assertEquals("3:04", time.toString());
    time = new Time(3, 40);
    assertEquals("3:40", time.toString());
  }

  /**
   * Tests for the correct string representation of a Time,
   * when created from a string input.
   */
  @Test
  public void testToString() {
    time = new Time("3:04");
    assertEquals("3:04", time.toString());
    time = new Time("3:40");
    assertEquals("3:40", time.toString());
    assertThrows(IllegalArgumentException.class, () -> new Time("3:"));
    assertThrows(IllegalArgumentException.class, () -> new Time(""));
    assertThrows(IllegalArgumentException.class, () -> new Time(new String()));
    assertThrows(IllegalArgumentException.class, () -> new Time("3:00:00"));
  }
}
