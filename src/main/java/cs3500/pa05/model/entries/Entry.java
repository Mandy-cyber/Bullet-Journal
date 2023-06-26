package cs3500.pa05.model.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayType;

/**
 * Represents an entry into the bullet journal.
 */
public abstract class Entry {
  @JsonProperty
  protected String type;
  @JsonProperty
  protected String name;
  @JsonProperty
  protected String description;
  @JsonProperty
  protected DayType dayOfWeek;

  /**
   * Contructs a new instance of Entry
   *
   * @param type        - the type of entry
   * @param name        - the name of the entry
   * @param description - the description of the entry
   * @param dayOfWeek   - which day of the week the entry is stored in
   */
  public Entry(String type, String name, String description, DayType dayOfWeek) {
    this.type = type;
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * Sets the name of the entry.
   *
   * @param s - the name to set the entry to
   */
  public void setName(String s) {
    this.name = s;
  }

  /**
   * Adds a description to the entry.
   *
   * @param s - the description for the entry
   */
  public void addDescription(String s) {
    this.description = s;
  }

  /**
   * Gets the description of this entry
   *
   * @return the description of this entry
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the name of this entry
   *
   * @return the name of this entry
   */
  public String getName() {
    return name;
  }

  /**
   * Writes this entry as a string
   *
   * @return a string representation of this entry
   */
  @Override
  public abstract String toString();

  /**
   * Gets the type of entry
   *
   * @return the type of entry this is
   */
  public String getType() {
    return type;
  }
}
