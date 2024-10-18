package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSegment {

    @JsonProperty("TripIndicator")
    private int tripIndicator;

    @JsonProperty("SegmentIndicator")
    private int segmentIndicator;

    @JsonProperty("Airline")
    private Airline airline;

    @JsonProperty("Origin")
    private AirportDetail origin;

    @JsonProperty("Destination")
    private AirportDetail destination;

    @JsonProperty("Duration")
    private int duration;

    @JsonProperty("GroundTime")
    private int groundTime;

    @JsonProperty("Mile")
    private int mile;

    @JsonProperty("StopOver")
    private boolean stopOver;

    @JsonProperty("StopPoint")
    private String stopPoint;

    @JsonProperty("StopPointArrivalTime")
    private String stopPointArrivalTime;

    @JsonProperty("StopPointDepartureTime")
    private String stopPointDepartureTime;

    @JsonProperty("Craft")
    private String craft;

    @JsonProperty("IsETicketEligible")
    private boolean isETicketEligible;

    @JsonProperty("FlightStatus")
    private String flightStatus;

    @JsonProperty("Status")
    private String status;
}
