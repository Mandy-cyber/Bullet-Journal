package cs3500.pa05.model.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.WeekModel;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a BujoFileReader
 */
public class BujoFileReaderTest {
  private FileReader reader;
  private FileReader badReader;

  /**
   * Initializes BujoFileReaders for testing
   */
  @BeforeEach
  public void setUp() {
    reader = new BujoFileReader(new File("src/test/resources/one.bujo"));
    badReader = new BujoFileReader(new File("src/test/resources/bad.bujo"));
    assertThrows(RuntimeException.class, () ->
        new BujoFileReader(new File("")));
  }

  /**
   * Tests that a bujo file is read correctly
   */
  @Test
  public void read() {
    List<JsonNode> readNodes = reader.read();
    assertEquals(readNodes.size(), 8);
    assertEquals(readNodes.get(0).toString(),
        "{\"week-name\":\"WEEK ONE\",\"theme\":\"LIGHT\",\"font\":"
            + "\"ARIAL\",\"font-size\":\"12\",\"font-color\":\"#000000\","
            + "\"max-events\":\"10\",\"max-tasks\":\"10\",\"password\":\"password123\"}");

    assertThrows(RuntimeException.class, () -> badReader.read());
  }

  /**
   * Tests that a list of JsonNodes are correctly converted into a WeekModel
   */
  @Test
  public void jsonToWeek() {
    WeekModel week = reader.jsonToWeek(reader.read());
    System.out.println(week.toString());
    assertEquals(2506, week.toString().length());
  }
}