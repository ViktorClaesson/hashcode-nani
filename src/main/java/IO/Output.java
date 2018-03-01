package IO;

import car.Car;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

    public static void writeResults(String fileName, List<Car> results) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
        results.forEach(s -> {
            try {
                bw.write(s.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
    }

}
