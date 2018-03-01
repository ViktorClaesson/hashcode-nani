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
            int rideTime = carLocation.distanceTo(ride.getFrom());
            //car can make it to ride?
            boolean canGetInTime = ride.getTimeSpan().withinSpan(atTime + rideTime);
            if (canGetInTime && rideTime < bestRideTime) {
                //find best ride car can make it to.
                bestRide = ride;
            }
        }
        //no more rides.
        if (bestRide == null) {
            return false;
        }
        //can't take ride twice.
        rides.remove(bestRide);
        //move car time and position.
        car.currentPosition = bestRide.getTo();
        car.addPassenger(bestRide, 0);
        car.lastTime = atTime + bestRideTime + bestRide.getTimeSpan().getFinish() - bestRide.getTimeSpan().getStart();
        return true;
    }
}

