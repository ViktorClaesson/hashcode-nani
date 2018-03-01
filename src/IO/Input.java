package IO;

import car.Ride;
import utils.Config;
import utils.Point;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Input implements InputReader {
    BufferedReader br;
    Config config;

    public Input() {
        init();
    }


    private void init() {
        {
            try {
                br = new BufferedReader(new FileReader(getClass().getResource("a_example.in").getPath()));
                List<String> lines = br.lines().collect(Collectors.toList());
                config = Config.parse(lines.get(0));
                List<Ride> rides = lines.subList(1, lines.size()).stream().map(line -> createRide(line));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Ride createRide(String line) {
        String[] splitLines = line.split(" ");
        Point from = new Point(Integer.parseInt(splitLines[0], Integer.parseInt(splitLines[1])));
        Point to = new Point(Integer.parseInt(splitLines[2], Integer.parseInt(splitLines[3])));
        return x;
    }


    @Override
    public Config readConfig() {
        return config;
    }

    @Override
    public List<Ride> readRides() {
        return null;
    }
}
