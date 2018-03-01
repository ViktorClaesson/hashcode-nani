package app;

import IO.Input;
import IO.Output;
import car.Car;
import car.Ride;
import solver.Solver;
import utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {


    public static void main(String[] args) throws IOException {

        Input input;
        Config config;
        List<Ride> rides;
        Solver solver;
        List<Car> result;

        input = new Input("a_example.in");
        config = input.readConfig();
        rides = input.readRides();
        solver = new Solver(config, rides);
        result = solver.solve();
        Output.writeResults("output_a.txt", result);

        input = new Input("b_should_be_easy.in");
        config = input.readConfig();
        rides = input.readRides();
        solver = new Solver(config, rides);
        result = solver.solve();
        Output.writeResults("output_b.txt", result);

        input = new Input("c_no_hurry.in");
        config = input.readConfig();
        rides = input.readRides();
        solver = new Solver(config, rides);
        result = solver.solve();
        Output.writeResults("output_c.txt", result);

        input = new Input("d_metropolis.in");
        config = input.readConfig();
        rides = input.readRides();
        solver = new Solver(config, rides);
        result = solver.solve();
        Output.writeResults("output_d.txt", result);

        input = new Input("e_high_bonus.in");
        config = input.readConfig();
        rides = input.readRides();
        solver = new Solver(config, rides);
        result = solver.solve();
        Output.writeResults("output_e.txt", result);

    }
}
