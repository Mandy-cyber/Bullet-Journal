package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.DayJson;
import cs3500.pa05.model.DayType;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.entries.Entry;
import cs3500.pa05.model.entries.Event;
import cs3500.pa05.model.entries.Task;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a JsonUtils
 */
public class JsonUtilsTest {
  private JsonNode entries;
  private DayJson dayJson;
  private TestRecord testRecord;

  /**
   * Initializes records and entries for testing
   *
   * @throws JsonProcessingException if the json could not be processed
   */
  @BeforeEach
  public void setup() throws JsonProcessingException {
    Entry entry1 = new Event("Event", "Sample Event 1",
        "some description here", DayType.MONDAY, new Time("12:30"),
        new Time(1, 5));
    Entry entry2 = new Task("Task", "Sample Task 1", "some description here",
        DayType.MONDAY, false);
    dayJson = new DayJson(DayType.MONDAY, new ArrayList<>(List.of(entry1, entry2)));
    testRecord = new TestRecord("mandi", 19);

    String jsonString = "[{\"type\": \"Event\", \"name\": "
        + "\"Sample Event 1\", \"description\": \"some description would go here\", "
        + "\"day-of-week\": \"SUNDAY\", \"start-time\": \"10:40\", \"duration\": \"0:30\"}, "
        + "{\"type\": \"Task\", \"name\": \"Sample Task 1\", \"description\": "
        + "\"some description would go here\", \"dayOfWeek\": \"SUNDAY\","
        + " \"isComplete\": false}]";
    entries = new ObjectMapper().readTree(jsonString);
  }

  /**
   * Tests that records are correctly converted into JsonNodes
   */
  @Test
  public void serializeRecord() {
    assertThrows(IllegalArgumentException.class, () ->
        JsonUtils.serializeRecord(dayJson), "Given record cannot be serialized");

    JsonNode actualNode = JsonUtils.serializeRecord(testRecord);
    assertEquals(actualNode.toString(), "{\"name\":\"mandi\",\"age\":19}");
  }

  /**
   * Tests that a list of json entries is correctly converted into a list of Entry objects
   */
  @Test
  public void toEntries() {
    List<Entry> entryList = JsonUtils.toEntries(entries);
    assertEquals(entryList.size(), 2);
    assertEquals(entryList.get(0).toString(),
        "{\"type\": \"Event\", \"name\": \"Sample Event 1\", \"description\":"
            + " \"some description would go here\", \"day-of-week\": \"SUNDAY\", \"start-time\": "
            + "\"10:40\", \"duration\": \"0:30\"}");
    assertEquals(entryList.get(1).toString(),
        "{\"type\": \"Task\", \"name\": \"Sample Task 1\", \"description\":"
            + " \"some description would go here\", \"day-of-week\": \"SUNDAY\", "
            + "\"is-complete\": \"false\"}");
  }
}