package cs3500.pa05.model;

/**
 * Represents each of the days of the week.
 */
public enum DayType {
  /**
   * Represents Sunday
   */
  SUNDAY,
  /**
   * Represents Monday
   */
  MONDAY,
  /**
   * Represents Tuesday
   */
  TUESDAY,
  /**
   * Represents Wednesday
   */
  WEDNESDAY,
  /**
   * Represents Thursday
   */
  THURSDAY,
  /**
   * Represents Friday
   */
  FRIDAY,
  /**
   * Represents Saturday
   */
  SATURDAY;

  /**
   * Parses a string into a type of day
   *
   * @param s - the string to parse
   * @return - the day of the week the string represents
   */
  public static DayType stringToDayType(String s) {
    if (s.equalsIgnoreCase("sunday")) {
      return SUNDAY;
    } else if (s.equalsIgnoreCase("monday")) {
      return MONDAY;
    } else if (s.equalsIgnoreCase("tuesday")) {
      return TUESDAY;
    } else if (s.equalsIgnoreCase("wednesday")) {
      return WEDNESDAY;
    } else if (s.equalsIgnoreCase("thursday")) {
      return THURSDAY;
    } else if (s.equalsIgnoreCase("friday")) {
      return FRIDAY;
    } else if (s.equalsIgnoreCase("saturday")) {
      return SATURDAY;
    } else {
      System.out.println("An invalid day of the week was entered.");
      return null;
    }
  }
}
