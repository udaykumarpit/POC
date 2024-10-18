package com.fastays.returnsearch.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class Response {

    @JsonProperty("ResponseStatus")
    private int responseStatus;

    @JsonProperty("Error")
    private ErrorDetail error;

    @JsonProperty("TraceId")
    private String traceId;

    @JsonProperty("Origin")
    private String origin;

    @JsonProperty("Destination")
    private String destination;

    @JsonProperty("Results")
    private List<List<Result>> results;
}
