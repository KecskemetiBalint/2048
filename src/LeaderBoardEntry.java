import java.io.Serializable;

/**
 * Serializable leaderboard entry item.
 */
public class LeaderBoardEntry implements Serializable {
    private String name;
    private int points;

    /**
     * Creates a new leaderboard entry with the given name and points.
     * 
     * @param name   name
     * @param points points
     */
    public LeaderBoardEntry(String name, int points) {
        super();
        this.name = name;
        this.points = points;
    }

    public String getPlayerName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
