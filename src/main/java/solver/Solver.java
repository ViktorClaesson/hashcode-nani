package solver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

	public List<Car> solve() {
		List<Car> cars = Stream.generate(() -> new Car(config.steps)).limit(config.vehicles).collect(Collectors.toList());
		for (Ride r : rides) {
			for (Car c : cars) {
				if (c.addPassenger(r)) {
					break;
				}
			}
		}
		return cars;
	}

    public List<Car> nextSolveBoy() {
        List<Car> cars = IntStream.range(1, config.vehicles).mapToObj((id) -> new Car(config.steps)).collect(Collectors.toList());

        for (Car car : cars) {
            RideCalc.bestNextRide(car, rides);
        }

        return cars;
    }

}
