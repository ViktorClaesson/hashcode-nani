package app;

import IO.Input;
import IO.Output;
import car.Car;
import car.Ride;
import solver.Solver;
import utils.Config;

import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<String> files = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        files.add("a_example.in");
        files.add("b_should_be_easy.in");
        files.add("c_no_hurry.in");
        files.add("d_metropolis.in");
        files.add("e_high_bonus.in");

        output.add("output_a.txt");
        output.add("output_b.txt");
        output.add("output_c.txt");
        output.add("output_d.txt");
        output.add("output_e.txt");

        for (int i = 0; i < 5; i++) {
            input = new Input(files.get(i));
            config = input.readConfig();
            rides = input.readRides();
            solver = new Solver(config, rides);
            result = solver.nextSolveBoy();
            Output.writeResults(output.get(i), result);
        }
    }
}
