package com.gridnine.testing;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();

        System.out.println("\nAll flights:");
        flightList.forEach(System.out::println);

        System.out.println("\nFlights without departure time before now:");
        flightFilter.applyFilterRule(flightList, Filters.DEPARTURE_BEFORE_NOW).forEach(System.out::println);

        System.out.println("\nFlights without arrival time before departure:");
        flightFilter.applyFilterRule(flightList, Filters.ARRIVAL_BEFORE_DEPARTURE).forEach(System.out::println);

        System.out.println("\nFlights without more than 2 hours on the ground:");
        flightFilter.applyFilterRule(flightList, Filters.MORE_THAN_TWO_HOURS_ON_THE_GROUND).forEach(System.out::println);
    }
}
