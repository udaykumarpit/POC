package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareBreakdown {

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("PassengerType")
    private int passengerType;

    @JsonProperty("PassengerCount")
    private int passengerCount;

    @JsonProperty("BaseFare")
    private double baseFare;

    @JsonProperty("Tax")
    private double tax;

    @JsonProperty("YQTax")
    private double yqTax;

    @JsonProperty("AdditionalTxnFeeOfrd")
    private double additionalTxnFeeOfrd;

    @JsonProperty("AdditionalTxnFeePub")
    private double additionalTxnFeePub;
}
