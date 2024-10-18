package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    @JsonProperty("Currency")
    private String currency;

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

    @JsonProperty("OtherCharges")
    private double otherCharges;

    @JsonProperty("ChargeBU")
    private List<ChargeBU> chargeBU;

    @JsonProperty("Discount")
    private double discount;

    @JsonProperty("PublishedFare")
    private double publishedFare;

    @JsonProperty("CommissionEarned")
    private double commissionEarned;

    @JsonProperty("PLBEarned")
    private double plbEarned;

    @JsonProperty("IncentiveEarned")
    private double incentiveEarned;

    @JsonProperty("OfferedFare")
    private double offeredFare;

    @JsonProperty("TdsOnCommission")
    private double tdsOnCommission;

    @JsonProperty("TdsOnPLB")
    private double tdsOnPLB;

    @JsonProperty("TdsOnIncentive")
    private double tdsOnIncentive;

    @JsonProperty("ServiceFee")
    private double serviceFee;
}
