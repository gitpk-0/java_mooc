
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {

        sortedStats("literacy.csv").stream().forEach(line -> System.out.println(line));

    }

    public static List<LiteracyStat> sortedStats(String file) {

        ArrayList<LiteracyStat> stats = new ArrayList<>();

        try {
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .map(parts -> new LiteracyStat(parts[2].substring(0, parts[2].length() - 4).trim(), parts[3], Integer.valueOf(parts[4]), parts[5]))
                    .forEach(book -> stats.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Collections.sort(stats, (s1, s2) -> s1.getLiteracyRate() > s2.getLiteracyRate() ? 1 : s1.getLiteracyRate() < s2.getLiteracyRate() ? -1 : 0);
        // Collections.sort(stats, (s1, s2) -> Double.compare(s1.getLiteracyRate(),s2.getLiteracyRate()));
        Collections.sort(stats, Comparator.comparingDouble(LiteracyStat::getLiteracyRate)); // best
        return stats;
    }
}
