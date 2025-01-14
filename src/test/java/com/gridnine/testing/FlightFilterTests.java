package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterTests {

    private final FlightFilter flightFilter = new FlightFilter();
    private final List<Flight> flights = FlightBuilder.createFlights();

    @Test
    @DisplayName("Flights without departure time before now:")
    public void testDepartureBeforeNowRule() {
        List<Flight> filteredFlights = flightFilter.applyFilterRule(flights, Filters.DEPARTURE_BEFORE_NOW);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    @DisplayName("Flights without arrival time before departure")
    public void testArrivalBeforeDepartureRule() {
        List<Flight> filteredFlights = flightFilter.applyFilterRule(flights, Filters.ARRIVAL_BEFORE_DEPARTURE);
        assertEquals(5, filteredFlights.size());
    }

    @Test
    @DisplayName("Flights without more than 2 hours on the ground")
    public void testMoreThanTwoHoursOnTheGroundTimeRule() {
        List<Flight> filteredFlights = flightFilter.applyFilterRule(flights, Filters.MORE_THAN_TWO_HOURS_ON_THE_GROUND);
        assertEquals(4, filteredFlights.size());
    }
}
