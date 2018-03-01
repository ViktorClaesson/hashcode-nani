package app;

import IO.Input;
import car.Car;
import car.Ride;
import solver.Solver;
import utils.Config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        Input input = new Input("a_example.in");
        Config config = input.readConfig();
        List<Ride> rides = input.readRides();
        Solver solver = new Solver(config, rides);
        List<Car> result = solver.solve();
        result.forEach(System.out::println);
    }

}
