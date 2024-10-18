package com.fastays.returnsearch.rest;

import com.fastays.returnsearch.model.FlightSearchRequest;
import com.fastays.returnsearch.model.FlightSearchResponse;
import com.fastays.returnsearch.service.FlightSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightSearchController {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchController.class);

    @Autowired
    FlightSearchService flightSearchService;

    @PostMapping("/search")
    public FlightSearchResponse getFlightSearch(@RequestBody FlightSearchRequest flightSearchRequest) {
        logger.debug("Received flight search request: {}", flightSearchRequest);
        FlightSearchResponse response = flightSearchService.searchFlights(flightSearchRequest);
        logger.debug("Flight search response: {}", response);
        return response;
    }
}
