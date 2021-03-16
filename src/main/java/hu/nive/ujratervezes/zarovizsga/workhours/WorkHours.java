package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {


    public String minWork(String file) {
        Path readFile = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(readFile)) {
            return getMinWorkNameWithDate(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read the file!", ioe);
        }
    }

    private String getMinWorkNameWithDate(BufferedReader reader) throws IOException {
        String name = "";
        String date = "";
        String line;
        long actualWorkhours;
        long minWorkhours = Long.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            actualWorkhours = Integer.parseInt(parts[1]);
            if (actualWorkhours < minWorkhours) {
                minWorkhours = actualWorkhours;
                name = parts[0];
                date = parts[2];
            }
        }
        return name + ": " + date;
    }
}
