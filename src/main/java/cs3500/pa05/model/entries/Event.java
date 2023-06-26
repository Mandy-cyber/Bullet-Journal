package cs3500.pa05.model.entries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Time;

/**
 * Represents an Event.
 */
public class Event extends Entry {
  @JsonProperty
  private Time startTime;
  @JsonProperty
  private Time duration;

  /**
   * Creates an instance of an Event.
   *
   * @param type        - the type of entry this is
   * @param name        - the name of the event
   * @param description - a description for the event
   * @param dayOfWeek   - the day of the week the event takes place
   * @param startTime   - the start time of the event
   * @param duration    - how long the event will take
   */
  @JsonCreator
  public Event(@JsonProperty("type") String type,
               @JsonProperty("name") String name,
               @JsonProperty("description") String description,
               @JsonProperty("day-of-week") DayType dayOfWeek,
               @JsonProperty("start-time") Time startTime,
               @JsonProperty("duration") Time duration) {
    super(type, name, description, dayOfWeek);
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Writes this event as a string
   *
   * @return a string representation of this event
   */
  @Override
  public String toString() {
    return "{\"type\": \"" + type + "\", \"name\": \"" + name
        + "\", \"description\": \"" + description + "\", \"day-of-week\": \"" + dayOfWeek
        + "\", \"start-time\": \"" + startTime.toString()
        + "\", \"duration\": \"" + duration.toString() + "\"}";
  }

  /**
   * Returns the start time.
   *
   * @return when the event starts
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Returns the duration.
   *
   * @return how long the event will last
   */
  public Time getDuration() {
    return duration;
  }

  /**
   * Gets the type of entry.
   *
   * @return the type of entry it is
   */
  public String getType() {
    return type;
  }
}