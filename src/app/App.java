package app;

import IO.Input;
import car.Car;
import car.Ride;
import solver.Solver;
import utils.Config;

import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println(App.class.getResource("a_example.in"));
        /*
        Input input = new Input("a_example.in");
        Config config = input.readConfig();
        List<Ride> rides = input.readRides();
        Solver solver = new Solver(config, rides);
        List<Car> result = solver.solve();
        result.forEach(System.out::println);
        */
    }

}
