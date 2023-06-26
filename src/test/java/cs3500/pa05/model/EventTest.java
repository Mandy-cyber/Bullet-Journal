package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.entries.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for an Event.
 */
public class EventTest {
  Event event;

  /**
   * Initializes events before testing.
   */
  @BeforeEach
  public void setup() {
    event = new Event("event", "name",
        "", DayType.MONDAY, new Time(12, 0),
        new Time(1, 0));
  }

  /**
   * Tests that a description is successfully added to an Event
   */
  @Test
  public void testAddDescription() {
    event.addDescription("This is a description.");
    assertEquals("This is a description.", event.getDescription());
  }

  /**
   * Tests that an Event is correctly converted into string format
   */
  @Test
  public void testToString() {
    String expected = "{\"type\": \"event\", \"name\": \"name\", \"description\": "
        + "\"\", \"day-of-week\": \"MONDAY\", \"start-time\": \"12:00\", \"duration\": "
        + "\"1:00\"}";
    assertEquals(expected, event.toString());
  }

  /**
   * Tests that the getter returns the correct start time.
   */
  @Test
  public void testGetStartTime() {
    assertEquals("12:00", event.getStartTime().toString());
  }
}
