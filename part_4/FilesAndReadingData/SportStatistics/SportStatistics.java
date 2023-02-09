
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String file = scan.nextLine();

        System.out.println("Team:");
        String team = scan.nextLine();

        int gameCount = 0;
        int wins = 0;
        int losses = 0;

        ArrayList<Game> results = readRecordsFromFile(file);

        for (Game game: results) {
            /* calculate number of games played */
            // if teamPlayed method returns true add a game to the count
            if (game.teamPlayed(team)) {
                gameCount++;
                // calculate wins
                if (game.getWinner().equals(team)) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }

        System.out.println("Games: " + gameCount);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }

    public static ArrayList<Game> readRecordsFromFile(String file) {
        ArrayList<Game> games = new ArrayList<>();

        try (Scanner read = new Scanner(Paths.get(file))) {
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(",");

                String homeTeam = parts[0];
                String awayTeam = parts[1];
                int homeScore = Integer.valueOf(parts[2]);
                int awayScore = Integer.valueOf(parts[3]);

                games.add(new Game(homeTeam, awayTeam, homeScore, awayScore));
            }
        } catch (Exception e) {
            System.out.println("Error1");
            System.out.println(e.getMessage());
        }
        return games;
    }

}
