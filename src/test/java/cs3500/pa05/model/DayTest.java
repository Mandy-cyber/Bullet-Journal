package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a Day.
 */
public class DayTest {
  Day day;

  /**
   * Initializes the day before tests.
   */
  @BeforeEach
  public void setup() {
    day = new Day(DayType.MONDAY, new ArrayList<>());
  }

  /**
   * Tests that you can add an entry to a day.
   */
  @Test
  public void testAddEntry() {
    assertEquals(0, day.getEntries().size());
    day.addEntry(new Event("event", "name",
        "nothing", day.getDayType(), new Time(12, 0),
        new Time(1, 0)));
    day.addEntry(new Task("task", "name", "",
        day.getDayType(), false));
    assertEquals(2, day.getEntries().size());
    assertEquals(1, day.getEvents().size());
    assertEquals(1, day.getTasks().size());
  }

  /**
   * Tests that the correct day of the week is returned.
   */
  @Test
  public void testGetDayType() {
    assertEquals(DayType.MONDAY, day.getDayType());
  }

  /**
   * Tests the string representation of a Day.
   */
  @Test
  public void testToString() {
    assertEquals("{\"day\": \"MONDAY\", \"entries\": []}", day.toString());
  }
}
