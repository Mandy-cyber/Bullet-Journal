package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayJson;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a DayJson
 */
public class DayJsonTest {
  private DayJson dayJson;

  /**
   * Initializes a DayJson and entries for testing.
   */
  @BeforeEach
  public void setup() {
    Entry entry1 = new Event("Event", "Sample Event 1", "some description here",
        DayType.MONDAY, new Time("12:30"), new Time(1, 5));
    Entry entry2 = new Task("Task", "Sample Task 1", "some description here",
        DayType.MONDAY, true);
    dayJson = new DayJson(DayType.MONDAY, new ArrayList<>(List.of(entry1, entry2)));
  }

  /**
   * Tests that the DayJson was constructed correctly.
   */
  @Test
  public void construct() {
    assertEquals(dayJson.day(), DayType.MONDAY);
    assertEquals(dayJson.entries().size(), 2);
  }

  /**
   * Tests that a DayJson is converted into a Day correctly.
   */
  @Test
  public void toDay() {
    Day actualDay = dayJson.toDay();
    assertEquals(actualDay.getDayOfWeek(), DayType.MONDAY);
    assertEquals(actualDay.getEntries().size(), 2);
    assertEquals(actualDay.getEvents().size(), 1);
    assertEquals(actualDay.getTasks().size(), 1);
  }
}