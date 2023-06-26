package cs3500.pa05.model.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a tool for writing to a .bujo file
 */
public class BujoFileWriter implements FileWriter {
  private final File bujoFile;

  /**
   * Initializes a new BujoFileWriter to write to the given bujo file
   *
   * @param bujoFile the .bujo file to write to
   */
  public BujoFileWriter(File bujoFile) {
    this.bujoFile = bujoFile;
  }

  /**
   * Writes the given content to this bujo file
   *
   * @param content the things to write to this bujo file
   * @throws RuntimeException if the file could not be found/written to
   */
  @Override
  public void write(String content) {
    Path p = bujoFile.toPath();
    byte[] data = content.getBytes();

    try {
      Files.write(p, data);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
