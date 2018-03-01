package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    public final int width, height, vehicles, bonus, steps;

    private Config(List<Integer> values) {
        this.width = values.get(0);
        this.height = values.get(1);
        this.vehicles = values.get(2);
        this.bonus = values.get(4);
        this.steps = values.get(5);
    }

    public static Config parse(String s) {
        return new Config(Arrays.stream(s.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
    }
}
