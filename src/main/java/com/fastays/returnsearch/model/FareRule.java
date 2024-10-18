package com.fastays.returnsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareRule {

    @JsonProperty("FareRuleDetail")
    private String fareRuleDetail;

    @JsonProperty("FareBasisCode")
    private String fareBasisCode;
}
