package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

public enum Filters implements Predicate<Flight> {
    DEPARTURE_BEFORE_NOW {
        @Override
        public boolean test(Flight flight) {
            return flight.getSegments()
                    .stream()
                    .noneMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));
        }
    },

    ARRIVAL_BEFORE_DEPARTURE {
        @Override
        public boolean test(Flight flight) {
            return flight.getSegments()
                    .stream()
                    .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
        }
    },

    MORE_THAN_TWO_HOURS_ON_THE_GROUND {
        @Override
        public boolean test(Flight flight) {
            List<Segment> segments = flight.getSegments();
            long hoursOnTheGround = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                hoursOnTheGround += segments.get(i).getArrivalDate().until(segments.get(i + 1).getDepartureDate(), ChronoUnit.HOURS);
            }
            return hoursOnTheGround < 2;
        }
    };

}
