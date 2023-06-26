package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for the DayType class.
 */
public class DayTypeTest {
  /**
   * Tests that parsing day of the week strings will return the correct DayType.
   */
  @Test
  public void testStringToDayType() {
    assertEquals(DayType.MONDAY, DayType.stringToDayType("monday"));
    assertEquals(DayType.TUESDAY, DayType.stringToDayType("tuesday"));
    assertEquals(DayType.WEDNESDAY, DayType.stringToDayType("wednesday"));
    assertEquals(DayType.THURSDAY, DayType.stringToDayType("thursday"));
    assertEquals(DayType.FRIDAY, DayType.stringToDayType("friday"));
    assertEquals(DayType.SATURDAY, DayType.stringToDayType("saturday"));
    assertEquals(DayType.SUNDAY, DayType.stringToDayType("SuNday"));
    assertNull(DayType.stringToDayType(""));
  }
}
