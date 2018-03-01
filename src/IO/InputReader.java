package IO;

import car.Ride;
import utils.Config;

import java.util.List;

public interface InputReader {
    Config readConfig();
    List<Ride> readRides();
}
