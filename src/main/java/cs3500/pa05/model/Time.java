package cs3500.pa05.model;

/**
 * Represents hours and minutes in military time.
 */
public class Time {
  // 24-hr time
  int hour;
  int minute;

  /**
   * Constructs an instance of Time in hours and minutes.
   *
   * @param hour   - the hour
   * @param minute - the minutes
   */
  public Time(int hour, int minute) {
    this.hour = hour;
    this.minute = minute;
  }

  /**
   * Constructs an instance of Time based on a String.
   *
   * @param time - the time in String format
   */
  public Time(String time) {
    checkTimeString(time.trim());
    convertStringToTime(time.trim());
  }

  /**
   * Checks if the string is suitable as a time.
   *
   * @param time - the string to check
   */
  private void checkTimeString(String time) {
    if (time == null || !time.contains(":")) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Parses a string into a minutes and hours.
   *
   * @param time - the string to parse
   */
  private void convertStringToTime(String time) {
    try {
      int hours = Integer.parseInt(time.substring(0, time.indexOf(":")));
      int minutes = Integer.parseInt(time.substring(time.indexOf(":") + 1).trim());
      this.hour = hours;
      this.minute = minutes;
    } catch (NumberFormatException exc) {
      throw new IllegalArgumentException("Invalid time provided.");
    }
  }

  /**
   * Converts Time into String format.
   *
   * @return - the Time in String form
   */
  public String toString() {
    String minuteFormatted;
    if (minute < 10) {
      minuteFormatted = "0" + minute;
    } else {
      minuteFormatted = Integer.toString(minute);
    }
    return String.format("%d:%s", hour, minuteFormatted);
  }
}
