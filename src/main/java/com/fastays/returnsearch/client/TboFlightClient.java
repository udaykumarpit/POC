package com.fastays.returnsearch.client;

import com.fastays.returnsearch.config.FeignConfig;
import com.fastays.returnsearch.model.FlightSearchRequest;
import com.fastays.returnsearch.model.FlightSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tbo-flight-client", url = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest", configuration = FeignConfig.class)
public interface TboFlightClient {

    @PostMapping("/Search")
    FlightSearchResponse getSearchFromTbo(@RequestBody FlightSearchRequest flightSearchRequest);
}
