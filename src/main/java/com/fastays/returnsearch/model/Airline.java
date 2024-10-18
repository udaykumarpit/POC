package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

    @JsonProperty("AirlineCode")
    private String airlineCode;

    @JsonProperty("AirlineName")
    private String airlineName;

    @JsonProperty("FlightNumber")
    private String flightNumber;

    @JsonProperty("FareClass")
    private String fareClass;

    @JsonProperty("OperatingCarrier")
    private String operatingCarrier;
}
