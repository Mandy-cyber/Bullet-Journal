package cs3500.pa05.model;

import cs3500.pa05.model.settings.Settings;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the week and all the days within it.
 */
public class WeekModel {
  private final Settings settings;
  private final List<Day> days;
  private String name;
  private int maxNumEvents;
  private int maxNumTasks;

  /**
   * Initializes an empty week with default settings
   */
  public WeekModel() {
    days = new ArrayList<>();
    addDays();
    this.settings = new Settings();
    this.name = settings.getName();
  }

  /**
   * Adds blank Days of the week to this model's list of days
   */
  private void addDays() {
    for (DayType day : DayType.values()) {
      days.add(new Day(day, new ArrayList<>()));
    }
  }

  /**
   * Initializes a Week using the given days and settings
   *
   * @param days     - the days of the week to be included in this week
   * @param settings - the settings for this week
   */
  public WeekModel(List<Day> days, Settings settings) {
    this.name = settings.getName();
    this.days = days;
    this.settings = settings;
  }

  /**
   * Sets the name of the week.
   *
   * @param name - the name to change it to
   */
  public void setWeekName(String name) {
    this.name = name;
    settings.setName(name);
  }

  /**
   * Gets the name of the week
   *
   * @return the name of the week
   */
  public String getWeekName() {
    return name;
  }

  /**
   * Gets the days of this week
   *
   * @return a list of the days of this week
   */
  public List<Day> getDays() {
    return days;
  }

  /**
   * Sets the maximum number of events allowed in the week.
   *
   * @param maxNumEvents - the max number of events allowed
   */
  public void setMaxNumEvents(int maxNumEvents) {
    settings.setMaxNumEvents(maxNumEvents);
    this.maxNumEvents = maxNumEvents;
  }

  /**
   * Sets the maximum number of tasks allowed in the week.
   *
   * @param maxNumTasks - the max number of tasks allowed
   */
  public void setMaxNumTasks(int maxNumTasks) {
    settings.setMaxNumTasks(maxNumTasks);
    this.maxNumTasks = maxNumTasks;
  }

  /**
   * Checks if there are more events than the maximum amount allowed.
   *
   * @return - if the maximum number of events has been exceeded
   */
  public boolean checkMaxNumEventsExceeded() {
    if (maxNumEvents != 0) {
      int numEvents = 0;
      for (Day day : days) {
        numEvents += day.getEvents().size();
      }
      return numEvents > maxNumEvents;
    }
    return false;
  }

  /**
   * Checks if there are more tasks than the maximum amount allowed.
   *
   * @return - if the maximum number of tasks has been exceeded
   */
  public boolean checkMaxNumTasksExceeded() {
    if (maxNumTasks != 0) {
      int numTasks = 0;
      for (Day day : days) {
        numTasks += day.getTasks().size();
      }
      return numTasks > maxNumTasks;
    }
    return false;
  }

  /**
   * Creates a string format of this week
   *
   * @return the week in the form of a string
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.settings.toString()).append("\n");

    for (Day day : days) {
      sb.append(day.toString()).append("\n");
    }

    return sb.toString();
  }

  /**
   * Gets the settings of this week
   *
   * @return the settings of the week
   */
  public Settings getSettings() {
    return settings;
  }
}
