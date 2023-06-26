package cs3500.pa05.model.settings;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Shortcuts.
 */
public class ShortcutsTest {
  private Shortcuts open;
  private Shortcuts save;
  private Shortcuts changeToDark;
  private Shortcuts changeToLight;
  private Shortcuts createEvent;
  private Shortcuts createTask;
  private Shortcuts newWeek;

  /**
   * Initializes shortcuts before each test.
   */
  @BeforeEach
  public void setUp() {
    open = Shortcuts.OPEN;
    save = Shortcuts.SAVE;
    changeToDark = Shortcuts.CHANGE_TO_DARK;
    changeToLight = Shortcuts.CHANGE_TO_LIGHT;
    createEvent = Shortcuts.CREATE_EVENT;
    createTask = Shortcuts.CREATE_TASK;
    newWeek = Shortcuts.NEW_WEEK;
  }

  /**
   * Tests that each shortcut enum is not a null value.
   */
  @Test
  public void testShortcutsNotNull() {
    assertNotNull(open);
    assertNotNull(save);
    assertNotNull(changeToDark);
    assertNotNull(changeToLight);
    assertNotNull(createEvent);
    assertNotNull(createTask);
    assertNotNull(newWeek);
  }
}