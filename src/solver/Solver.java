package solver;

import java.util.ArrayList;
import java.util.List;

import car.Car;
import car.Ride;
import utils.Config;

public class Solver {
	List<Car> cars;
	List<Ride> rides;
	Config config;

	public Solver(Config config, List<Ride> rides) {
		this.config = config;
		this.rides = rides;
		cars = new ArrayList<Car>();
		for (int i = 0; i < config.vehicles; i++) {
			cars.add(new Car(0, 0, config.steps));
		}
	}

	public void solve() {
		for (Ride r : rides) {
			for (Car c : cars) {
				if (c.addPassenger(r)) {
					break;
				}
			}
		}
	}

}
