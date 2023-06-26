package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A record purely for the purpose of testing JsonUtils
 */
public record TestRecord(
    @JsonProperty("name") String name,
    @JsonProperty("age") int age) {
}
