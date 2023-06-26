package cs3500.pa05.model.entries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayType;

/**
 * Represents a Task.
 */
public class Task extends Entry {
  @JsonProperty
  private boolean isComplete;

  /**
   * Constructs an instance of task and if it is complete.
   *
   * @param type        - the type of entry this is
   * @param name        - the name of the task
   * @param description - a description of the task
   * @param dayOfWeek   - what day of the week the task takes place
   * @param isComplete  - whether the task is complete or not
   */
  @JsonCreator
  public Task(@JsonProperty("type") String type,
              @JsonProperty("name") String name,
              @JsonProperty("description") String description,
              @JsonProperty("day-of-week") DayType dayOfWeek,
              @JsonProperty("is-complete") boolean isComplete) {
    super(type, name, description, dayOfWeek);
    this.isComplete = isComplete;
  }

  /**
   * Sets the task as complete.
   */
  public void setAsComplete() {
    this.isComplete = true;
  }

  /**
   * Sets the task as incomplete.
   */
  public void setAsIncomplete() {
    this.isComplete = false;
  }

  /**
   * Checks if the task is complete.
   *
   * @return if the class is complete or not
   */
  public boolean checkIfComplete() {
    return isComplete;
  }

  /**
   * Writes this task as a string
   *
   * @return a string representation of this task
   */
  @Override
  public String toString() {
    return "{\"type\": \"" + type + "\", \"name\": \"" + name
        + "\", \"description\": \"" + description + "\", \"day-of-week\": \"" + dayOfWeek
        + "\", \"is-complete\": \"" + isComplete + "\"}";
  }
}
