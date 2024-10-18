package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @JsonProperty("ResultIndex")
    private String resultIndex;

    @JsonProperty("Source")
    private int source;

    @JsonProperty("IsLCC")
    private boolean isLCC;

    @JsonProperty("IsRefundable")
    private boolean isRefundable;

    @JsonProperty("AirlineRemark")
    private String airlineRemark;

    @JsonProperty("Fare")
    private Fare fare;

    @JsonProperty("FareBreakdown")
    private List<FareBreakdown> fareBreakdown;

    @JsonProperty("Segments")
    private List<List<ResponseSegment>> segments;

    @JsonProperty("LastTicketDate")
    private String lastTicketDate;

    @JsonProperty("TicketAdvisory")
    private String ticketAdvisory;

    @JsonProperty("FareRules")
    private List<FareRule> fareRules;

    @JsonProperty("AirlineCode")
    private String airlineCode;

    @JsonProperty("ValidatingAirline")
    private String validatingAirline;
}
