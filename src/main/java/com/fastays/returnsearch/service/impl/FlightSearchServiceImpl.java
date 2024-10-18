package com.fastays.returnsearch.service.impl;

import com.fastays.returnsearch.client.TboFlightClient;
import com.fastays.returnsearch.model.FlightSearchRequest;
import com.fastays.returnsearch.model.FlightSearchResponse;
import com.fastays.returnsearch.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    TboFlightClient tboFlightClient;

    @Override
    public FlightSearchResponse searchFlights(FlightSearchRequest flightSearchRequest) {
        // Call the Feign client to fetch flight search results
        return tboFlightClient.getSearchFromTbo(flightSearchRequest);
    }
}