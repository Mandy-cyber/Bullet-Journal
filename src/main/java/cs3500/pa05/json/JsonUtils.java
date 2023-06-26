package cs3500.pa05.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple utils class used to hold json-related static methods
 */
public class JsonUtils {

  /**
   * Converts a given record object to a JsonNode. Source = Lab 6
   *
   * @param record the record to convert
   * @return the JsonNode representation of the given record
   * @throws IllegalArgumentException if the record could not be converted correctly
   */
  public static JsonNode serializeRecord(Record record) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.convertValue(record, JsonNode.class);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Given record cannot be serialized");
    }
  }

  /**
   * Converts a given list of entries (in json format) into Entry objects
   *
   * @param entries a list of entries as json nodes
   * @return a list of entries as Java objects
   */
  public static List<Entry> toEntries(JsonNode entries) {
    ObjectMapper mapper = new ObjectMapper();
    List<Entry> convertedEntries = new ArrayList<>();

    for (JsonNode entry : entries) {
      Entry convertedEntry;
      if (entry.get("type").toString().contains("Event")) {
        convertedEntry = mapper.convertValue(entry, Event.class);
      } else {
        convertedEntry = mapper.convertValue(entry, Task.class);
      }
      convertedEntries.add(convertedEntry);
    }

    return convertedEntries;
  }
}