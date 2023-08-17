package com.example.demo.challenges.platformChallenge;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem: Find the minimum number of platform required to accommodate the given arrival and departure timings in a station.
 * A = { 20:00, 12:00, 15:15, 18:30, 13:45 }
 * D = { 23:55, 18:45, 17:55, 19:45, 17:10 }
 * Index 0 of A -> Arrival time and D -> departure time and so on.
 * <p>
 * <p>
 * Explanation:
 * The code sorts the arrival and departure arrays in ascending order.
 * Then, it uses two pointers (arrivalPointer and departurePointer) to simulate the arrivals and departures.
 * The platformsNeeded variable keeps track of the number of platforms needed at a particular time.
 * Whenever a new train arrives before the departure of another train, it increments the platformsNeeded,
 * and if it exceeds the current minPlatforms, minPlatforms is updated.
 */
@Slf4j
public class ChatGptPlatformChallenge {

    public static void main(String... args) {
        ArrayList<LocalTime> arrivalList = new ArrayList();
        arrivalList.add(LocalTime.parse("20:00"));
        arrivalList.add(LocalTime.parse("15:15"));
        arrivalList.add(LocalTime.parse("12:00"));
        arrivalList.add(LocalTime.parse("18:30"));
        arrivalList.add(LocalTime.parse("13:45"));
        Collections.sort(arrivalList);

        ArrayList<LocalTime> departureList = new ArrayList();
        departureList.add(LocalTime.parse("23:55"));
        departureList.add(LocalTime.parse("17:55"));
        departureList.add(LocalTime.parse("18:45"));
        departureList.add(LocalTime.parse("19:45"));
        departureList.add(LocalTime.parse("17:10"));
        Collections.sort(departureList);

        log.info("ArrivalList : {}", arrivalList);
        log.info("DepartureList : {}", departureList);

        /* ParamGroup-1
        Either of the 2 initial parameter group will work
        int i = 0, j = 0;
        Integer platformNeeded = 0, minPlatformRequired = 0;
        */

        /* ParamGroup-2
        Initializing i =1 because at the min 1 platform is needed by default.
        * As such iteration is being started from 2 arriving train*/
        int i = 1, j = 0;
        Integer platformNeeded = 1, minPlatformRequired = 1;
        int noOfTrains = arrivalList.size();

        while (i < noOfTrains && j < noOfTrains) {
            if (arrivalList.get(i).isBefore(departureList.get(j))) {
                platformNeeded++;
                i++;

                if (minPlatformRequired < platformNeeded) {
                    minPlatformRequired = platformNeeded;
                }
            } else {
                platformNeeded--;
                j++;
            }

        }
        log.info("Min no of platform required : {}", minPlatformRequired);
    }

}
