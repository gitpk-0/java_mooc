public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getWinner() {
        if (homeScore > awayScore) {
            return homeTeam;
        } else {
            return awayTeam;
        }
    }

    public boolean teamPlayed(String team) {
        return team.equals(homeTeam) || team.equals(awayTeam);
    }
}
