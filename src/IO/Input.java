package IO;

import car.Ride;
import utils.Config;
import utils.Point;
import utils.TimeSpan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input implements InputReader {
    private Config config;
    private List<Ride> rides;

    public Input(String fileName) {
        init(fileName);
    }


    private void init(String fileName) {
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/inputs/" + fileName));
                List<String> lines = br.lines().collect(Collectors.toList());
                config = Config.parse(lines.get(0));
                List<Ride> rides = lines.subList(1, lines.size()).stream().map(line -> createRide(line)).collect(Collectors.toList());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Ride createRide(String line) {
        String[] splitLines = line.split(" ");
        List<Integer> numbers = Arrays.stream(line.split(" ")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
        Point from = new Point(numbers.get(0), numbers.get(1));
        Point to = new Point(numbers.get(1), numbers.get(2));
        TimeSpan ts = new TimeSpan(numbers.get(3), numbers.get(4));
        return new Ride(from, to, ts);
    }

    @Override
    public Config readConfig() {
        return config;
    }

    @Override
    public List<Ride> readRides() {
        return rides;
    }
}
