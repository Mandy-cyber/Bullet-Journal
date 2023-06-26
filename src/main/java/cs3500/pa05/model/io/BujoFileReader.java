package cs3500.pa05.model.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.JsonUtils;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.WeekModel;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.settings.Settings;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a tool for reading and processing content from a .bujo file
 */
public class BujoFileReader implements FileReader {
  private final ObjectMapper mapper;
  private final Scanner scanner;

  /**
   * Initializes a new BujoFileReader to read from the given file
   *
   * @param bujoFile the .bujo file to read from
   * @throws RuntimeException if the file could not be found
   */
  public BujoFileReader(File bujoFile) {
    this.mapper = new ObjectMapper();
    try {
      scanner = new Scanner(bujoFile);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * Reads the content from a file
   *
   * @return the content of the file in json format
   * @throws RuntimeException if the content of the file could not be processed into json
   */
  @Override
  public List<JsonNode> read() {
    List<JsonNode> nodes = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      try {
        nodes.add(mapper.readTree(str));
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }

    return nodes;
  }


  /**
   * Converts the given list of JsonNodes into their associated WeekModel
   *
   * @param nodes a list of json objects/nodes
   * @return a WeekModel based on information from the nodes
   */
  public WeekModel jsonToWeek(List<JsonNode> nodes) {
    List<Day> days = new ArrayList<>();
    Settings settings = mapper.convertValue(nodes.get(0), Settings.class);

    for (int i = 1; i < nodes.size(); i++) {
      JsonNode node = nodes.get(i);
      DayType dayType = mapper.convertValue(node.get("day"), DayType.class);
      List<Entry> entries = JsonUtils.toEntries(node.get("entries"));
      days.add(new Day(dayType, entries));
    }

    return new WeekModel(days, settings);
  }
}
