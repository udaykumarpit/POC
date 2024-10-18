package com.fastays.returnsearch.service;


import com.fastays.returnsearch.model.FlightSearchRequest;
import com.fastays.returnsearch.model.FlightSearchResponse;

public interface FlightSearchService {
    FlightSearchResponse searchFlights(FlightSearchRequest flightSearchRequest);
}