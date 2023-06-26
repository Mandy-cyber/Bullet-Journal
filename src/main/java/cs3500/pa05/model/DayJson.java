package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.entries.Entry;
import java.util.List;

/**
 * JSON format of this record:
 * <p>
 * <code>
 * {
 *   "day": "Monday, Tuesday, etc"
 *   "entries": "list of events/tasks"
 * }
 * </code>
 * </p>
 *
 * @param day the day of the week
 * @param entries the list of events and tasks associated with this day
 */
public record DayJson(
    @JsonProperty("day") DayType day,
    @JsonProperty("entries") List<Entry> entries
) {

  /**
   * Initializes a new DayJson with the given day and entries
   *
   * @param day the day of the week
   * @param entries the list of events and tasks associated with this day
   */
  public DayJson(DayType day, List<Entry> entries) {
    this.day = day;
    this.entries = entries;
  }

  /**
   * Converts a DayJson into a Day
   *
   * @return the Day representation of this DayJson
   */
  public Day toDay() {
    return new Day(this.day, this.entries);
  }
}
