package com.gridnine.testing;

import java.util.List;

public class FlightFilter {
    public List<Flight> applyFilterRule(List<Flight> flightList, Filters filterRule) {
        return flightList.stream()
                .filter(filterRule::test)
                .toList();
    }
}
