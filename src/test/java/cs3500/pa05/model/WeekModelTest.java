package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import cs3500.pa05.model.settings.Settings;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the WeekModel class.
 */
public class WeekModelTest {
  WeekModel weekDefault;
  WeekModel weekAlternate;

  /**
   * Initializes the weeks before each test.
   */
  @BeforeEach
  public void setup() {
    weekDefault = new WeekModel();
    weekAlternate = new WeekModel(new ArrayList<>(), new Settings());
  }

  /**
   * Tests if the name of the week can be set.
   */
  @Test
  public void testSetWeekName() {
    weekDefault.setWeekName("Default Week");
    assertEquals("Default Week", weekDefault.getWeekName());
  }

  /**
   * Tests if the check for if the maximum number of events is exceeded returns the right value.
   */
  @Test
  public void testCheckMaxNumEventsExceeded() {
    weekDefault.setMaxNumEvents(10);
    for (Day day : weekDefault.getDays()) {
      day.getEntries().add(new Event("event", "name",
          "nothing", day.getDayType(), new Time(12, 0),
          new Time(1, 0)));
    }
    assertFalse(weekDefault.checkMaxNumEventsExceeded());
    for (Day day : weekDefault.getDays()) {
      day.getEntries().add(new Event("event", "name",
          "nothing", day.getDayType(), new Time(12, 0),
          new Time(1, 0)));
    }
    assertTrue(weekDefault.checkMaxNumEventsExceeded());
  }

  /**
   * Tests if the check for if the maximum number of tasks is exceeded returns the right value.
   */
  @Test
  public void testCheckMaxNumTasksExceeded() {
    weekDefault.setMaxNumTasks(10);
    for (Day day : weekDefault.getDays()) {
      day.getEntries().add(new Task("task", "name", "nothing",
          day.getDayType(), false));
    }
    assertFalse(weekDefault.checkMaxNumTasksExceeded());
    for (Day day : weekDefault.getDays()) {
      day.getEntries().add(new Task("task", "name", "nothing",
          day.getDayType(), false));
    }
    assertTrue(weekDefault.checkMaxNumTasksExceeded());
  }

  /**
   * Tests that the maximum number of entries returns false when not exceeded.
   */
  @Test
  public void testCheckMaxNumEntriesExceededFalse() {
    weekDefault.setMaxNumEvents(0);
    assertFalse(weekDefault.checkMaxNumEventsExceeded());
    weekDefault.setMaxNumTasks(0);
    assertFalse(weekDefault.checkMaxNumTasksExceeded());
  }

  /**
   * Tests if the string representation of WeekModel is correct.
   */
  @Test
  public void testToString() {
    String expected =
        """
            {"theme":"LIGHT","font":"ARIAL","password":"password123","name":"Untitled",\
            "fontSize":12,"fontColor":"#000000","maxEvents":20,"maxTasks":20,"quote":"Lalala"}
            {"day": "SUNDAY", "entries": []}
            {"day": "MONDAY", "entries": []}
            {"day": "TUESDAY", "entries": []}
            {"day": "WEDNESDAY", "entries": []}
            {"day": "THURSDAY", "entries": []}
            {"day": "FRIDAY", "entries": []}
            {"day": "SATURDAY", "entries": []}
            """;

    assertEquals(expected, weekDefault.toString());
  }

  /**
   * Tests if you can get the week name.
   */
  @Test
  public void getWeekName() {
    assertEquals(weekDefault.getWeekName(), "Untitled");
    assertEquals(weekAlternate.getWeekName(), "Untitled");
  }

  /**
   * Tests if you can get the days in the week.
   */
  @Test
  public void getDays() {
    assertEquals(weekDefault.getDays().size(), 7);
    assertEquals(weekAlternate.getDays().size(), 0);
  }

  /**
   * Tests if you can get the settings for the week.
   */
  @Test
  public void getSettings() {
    String expected =
        "{\"theme\":\"LIGHT\",\"font\":\"ARIAL\",\"password\":\"password123\","
            + "\"name\":\"Untitled\",\"fontSize\":12,\"fontColor\":\"#000000\","
            + "\"maxEvents\":20,\"maxTasks\":20,\"quote\":\"Lalala\"}";
    assertEquals(expected, weekDefault.getSettings().toString());
  }
}
