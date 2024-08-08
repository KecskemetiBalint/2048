import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implements the leaderboard logic, saves the leaderboard to file and read it.
 */
public class LeaderBoard {
    public static final int MAX_LEADERBOARD_ITEMS = 30;
    private ArrayList<LeaderBoardEntry> players;

    public LeaderBoard() {
        readLeaderBoardDataFromFile();
    }

    /**
     * Add player to leaderbord.
     * 
     * @param name   name of the player
     * @param points earned points
     */
    public void addPlayer(String name, int points) {
        players.add(new LeaderBoardEntry(name, points));

        Collections.sort(players, new Comparator<LeaderBoardEntry>() {
            @Override
            public int compare(LeaderBoardEntry lhs, LeaderBoardEntry rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getPoints() > rhs.getPoints() ? -1
                        : (lhs.getPoints() < rhs.getPoints()) ? 1 : 0;
            }
        });

        if (players.size() > MAX_LEADERBOARD_ITEMS) {
            players.removeAll(players.subList(MAX_LEADERBOARD_ITEMS, players.size()));
        }
        writeLeaderBoardToFile();
    }

    public ArrayList<LeaderBoardEntry> getPlayers() {
        return players;
    }

    /**
     * Returns the position of a player by name.
     * 
     * @param playerName name of the player
     * @param points     points of the player
     * @return current top position of player or max position
     */
    public int getPositionOfPlayer(String playerName, int points) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerName().equals(playerName)
                    && players.get(i).getPoints() == points) {
                return i + 1;
            }
        }
        return MAX_LEADERBOARD_ITEMS + 1;
    }

    private void writeLeaderBoardToFile() {
        try {
            FileOutputStream writeData = new FileOutputStream("leaderboard.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(players);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readLeaderBoardDataFromFile() {
        try {
            FileInputStream readData = new FileInputStream("leaderboard.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            players = (ArrayList<LeaderBoardEntry>) readStream.readObject();
            readStream.close();
        } catch (Exception e) {
            players = new ArrayList<LeaderBoardEntry>();
        }
    }

}
