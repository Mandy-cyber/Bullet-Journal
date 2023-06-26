package cs3500.pa05.model;

import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents one day in a week.
 */
public class Day {
  private final DayType dayOfWeek;
  private final List<Entry> entries;

  /**
   * Constructs a Day.
   *
   * @param dayOfWeek - which day of the week it is
   * @param entries   - the tasks or events for this day
   */
  public Day(DayType dayOfWeek, List<Entry> entries) {
    this.dayOfWeek = dayOfWeek;
    this.entries = entries;
  }

  /**
   * Adds a task or event to this day.
   *
   * @param entry - the entry to be added
   */
  public void addEntry(Entry entry) {
    entries.add(entry);
  }

  /**
   * Gets the name of this day
   *
   * @return the day of the week this day is
   */
  public DayType getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * Gets all entries stored in the day.
   *
   * @return - the entries stored in the day
   */
  public List<Entry> getEntries() {
    return entries;
  }

  /**
   * Get all events stored in the day.
   *
   * @return - the entries stored in the day
   */
  public List<Entry> getEvents() {
    List<Entry> events = new ArrayList<>();
    for (Entry entry : entries) {
      // I want to avoid this if there's another way.
      if (entry instanceof Event) {
        events.add(entry);
      }
    }
    return events;
  }

  /**
   * Get all tasks stored in the day.
   *
   * @return - the tasks stored in the day
   */
  public List<Entry> getTasks() {
    List<Entry> tasks = new ArrayList<>();
    for (Entry entry : entries) {
      // I want to avoid this if there's another way.
      if (entry instanceof Task) {
        tasks.add(entry);
      }
    }
    return tasks;
  }

  /**
   * Get the day of the week for this instance
   * of day.
   *
   * @return - the day of the weekn
   */
  public DayType getDayType() {
    return dayOfWeek;
  }

  /**
   * Writes this Day as a string
   *
   * @return the day represented as a string
   */
  @Override
  public String toString() {
    String entryStr = entries.stream()
        .map(Object::toString)
        .collect(Collectors.joining(","));

    return "{\"day\": \"" + dayOfWeek
        + "\", \"entries\": [" + entryStr
        + "]}";
  }
}
