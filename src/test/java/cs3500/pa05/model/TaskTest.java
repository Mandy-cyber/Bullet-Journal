package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.entries.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a Task.
 */
public class TaskTest {
  Task task;
  Task taskAlternate;

  /**
   * Initializes Tasks for testing.
   */
  @BeforeEach
  public void setup() {
    task = new Task("Task", "name", "",
        DayType.TUESDAY, false);
    taskAlternate = new Task("Task", "name", "description", DayType.MONDAY, false);
    task = new Task("Task", "", "hihi",
        DayType.TUESDAY, false);
    taskAlternate = new Task("Task", "task alternate", "description",
        DayType.MONDAY, true);
  }

  /**
   * Tests that a description is successfully added to a Task.
   */
  @Test
  public void testAddDescription() {
    task.addDescription("This is a description.");
    assertEquals("This is a description.", task.getDescription());
  }

  /**
   * Tests that a task is marked as complete when requested.
   */
  @Test
  public void testSetAsComplete() {
    assertFalse(task.checkIfComplete());
    task.setAsComplete();
    assertTrue(task.checkIfComplete());
  }

  /**
   * Tests that a Task is correctly converted into string format.
   */
  @Test
  public void testToString() {
    String expected = "{\"type\": \"Task\", \"name\": \"\", \"description\": \"hihi\","
        + " \"day-of-week\": \"TUESDAY\", \"is-complete\": \"false\"}";
    assertEquals(expected, task.toString());
  }

  /**
   * Tests that the task is set as incomplete.
   */
  @Test
  public void testSetAsIncomplete() {
    task.setAsIncomplete();
    assertFalse(task.checkIfComplete());
  }

  /**
   * Tests that the getType method works for tasks.
   */
  @Test
  public void testGetType() {
    assertEquals("Task", task.getType());
  }

  /**
   * Tests that the setName method sets the name of the task properly.
   */
  @Test
  public void testSetName() {
    task.setName("Test");
    assertEquals("Test", task.getName());
  }
}
