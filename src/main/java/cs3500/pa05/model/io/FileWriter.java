package cs3500.pa05.model.io;

/**
 * Represents a tool for writing content to a file
 */
public interface FileWriter {

  /**
   * Writes the given content to a file
   *
   * @param content the things to write to a file
   */
  void write(String content);
}
