package utils;

import car.Car;
import car.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class RideCalc {
    public static void bestNextRide(Car car, List<Ride> rides) {
        while (hasNextRide(car, rides)) ;
    }

    private static boolean hasNextRide(Car car, List<Ride> rides) {
        Point carLocation = car.lastPosition();
        int atTime = car.lastTime;

        //Har vi redan missat riden?
        List<Ride> possibleRides = rides.stream().filter(x -> x.getTimeSpan().getFinish() >= atTime).collect(Collectors.toList());

        Ride bestRide = null;
        int bestRideTime = Integer.MAX_VALUE;
        for (Ride ride : possibleRides) {
            //
            int rideTime = carLocation.distanceTo(ride.getFrom());
            boolean canGetInTime = ride.getTimeSpan().withinSpan(atTime + rideTime);
            if (canGetInTime && rideTime < bestRideTime) {
                bestRide = ride;
            }
        }
        if (bestRide == null) {
            return false;
        }
        rides.remove(bestRide);
        car.currentPosition = bestRide.getTo();
        //car.addPassenger(bestRide, bestRideTime + atTime);
        return true;
    }
}

