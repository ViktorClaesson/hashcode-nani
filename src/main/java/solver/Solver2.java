package solver;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import car.Car;
import car.Ride;
import utils.Config;
import utils.Point;

public class Solver2 {
    HashMap<Integer,Ride> rides;
    Config config;

    public Solver2(Config config, List<Ride> rides) {
        this.config = config;
        for (Ride r : rides){
            this.rides.put(r.getId(),r);
        }
    }

    public List<Car> solve() {
        List<Car> cars = IntStream.range(1, config.vehicles).mapToObj((id) -> new Car(id, config.steps)).collect(Collectors.toList());
        int[][] temp;

            for (Car c : cars) {
                for (Ride r : rides.values()) {

                Point temppos = c.currentPosition;
                int temptime = c.currentTime;


            }
        }
        return cars;
    }

}
