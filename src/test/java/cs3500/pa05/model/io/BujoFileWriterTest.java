package cs3500.pa05.model.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for writing to a bujo file
 */
public class BujoFileWriterTest {
  private String content;
  private FileWriter writer;
  private String path;

  /**
   * Initializes a BujoFileWriter and some content to write
   */
  @BeforeEach
  public void setUp() {
    path = "src/test/resources/random.bujo";
    content = "Just some random text to write.\nDoesn't even need to be json <3";
    writer = new BujoFileWriter(new File(path));
  }

  /**
   * Tests that content is successfully written to a bujo file
   *
   * @throws FileNotFoundException if the file being scanned cannot be found
   */
  @Test
  public void write() throws FileNotFoundException {
    Scanner sc = new Scanner(new File(path));
    StringBuilder sb = new StringBuilder();
    while (sc.hasNextLine()) {
      sb.append(sc.nextLine());
    }

    assertEquals(sb.toString(), "YADA YADA YADA");

    writer.write(content);

    sc = new Scanner(new File(path));
    sb = new StringBuilder();
    while (sc.hasNextLine()) {
      sb.append(sc.nextLine()).append("\n");
    }
    assertEquals(sb.toString(), content + "\n");

    assertThrows(RuntimeException.class, () ->
        new BujoFileWriter(new File("")).write("Testing123"));
  }

  /**
   * Reset the testing file back to its regular nonsense
   */
  @AfterEach
  public void reset() {
    writer.write("YADA YADA YADA");
  }
}


