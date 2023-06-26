package cs3500.pa05.model.io;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.WeekModel;
import java.util.List;

/**
 * Represents a tool for reading content from a file
 */
public interface FileReader {

  /**
   * Reads the content from a file
   *
   * @return the content of the file in json format
   */
  List<JsonNode> read();

  /**
   * Converts the given list of JsonNodes into their associated WeekModel
   *
   * @param nodes a list of json objects/nodes
   * @return a WeekModel based on information from the nodes
   */
  WeekModel jsonToWeek(List<JsonNode> nodes);
}
