package solver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import IO.Input;
import car.Car;
import car.Ride;
import utils.RideCalc;
import utils.Config;

public class Solver {
    List<Ride> rides;
    Config config;

    public Solver(Config config, List<Ride> rides) {
        this.config = config;
        this.rides = rides;
    }
    /*
    public List<Car> solve() {
        List<Car> cars = IntStream.range(1, config.vehicles).mapToObj((id) -> new Car(id, config.steps)).collect(Collectors.toList());
        for (Ride r : rides) {
            for (Car c : cars) {
                if (c.addPassenger(r)) {
                    break;
                }
            }
        }
        return cars;
    }*/

    public List<Car> nextSolveBoy() {

        //Imply car can run whenever it likes.
        List<Car> cars = IntStream.range(1, config.vehicles).mapToObj((id) -> new Car(id, config.steps)).collect(Collectors.toList());

        for (Car car : cars) {
            RideCalc.bestNextRide(car, rides);
            System.out.println(car);
        }

        return cars;
    }
}
