import java.awt.Color;
import java.util.Random;

/**
 * Implements the game's core logic, the table, movements, points.
 */
public class GameLogic {
    private int[][] table = new int[4][4];
    private int points = 0;
    private String playerName = "";

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        playerName = name;
    }

    private void createGameField() {
        for (int i = 0; i < 4; i++) {
            for (int l = 0; l < 4; l++) {
                table[i][l] = 0;
            }
        }
    }

    private int countEmptyFields() {
        int emptyFields = 0;

        for (int i = 0; i < 4; i++) {
            for (int l = 0; l < 4; l++) {
                if (table[i][l] == 0) {
                    emptyFields++;
                }
            }
        }

        return emptyFields;
    }

    /**
     * Spawns a 2 or 4 on a random free place on the field if can.
     * @return spawn was made or not.
     */
    public boolean spawnNumber() {
        int emptyFields = countEmptyFields();

        if (emptyFields == 0) {
            return false;
        }
        Random rand = new Random();

        int spawnTo = rand.nextInt(emptyFields);
        int numberToSpawn = rand.nextInt(2);

        for (int i = 0; i < 4; i++) {
            for (int l = 0; l < 4; l++) {
                if (table[i][l] == 0) {
                    if (spawnTo == 0) {
                        if (numberToSpawn == 0) {
                            table[i][l] = 2;
                        } else {
                            table[i][l] = 4;
                        }
                    }
                    spawnTo--;
                }
            }
        }
        return true;
    }

    /**
     * Starts a game, empties the field and points and spawns two random number.
     */
    public void startGame() {
        createGameField();
        spawnNumber();
        spawnNumber();
        points = 0;
    }

    private int[] flow(int i1, int i2, int i3, int i4, boolean testOnly) {
        int[] collapsed = collapse(i1, i2, i3, i4);

        if (collapsed[3] == collapsed[2]) {
            collapsed[3] = collapsed[2] * 2;
            collapsed[2] = 0;
            if (!testOnly) {
                points = points + collapsed[3];
            }
        }
        if (collapsed[2] == collapsed[1]) {
            collapsed[2] = collapsed[1] * 2;
            collapsed[1] = 0;
            if (!testOnly) {
                points = points + collapsed[2];
            }
        }
        if (collapsed[1] == collapsed[0]) {
            collapsed[1] = collapsed[0] * 2;
            collapsed[0] = 0;
            if (!testOnly) {
                points = points + collapsed[1];
            }
        }
        int[] retArray = collapse(collapsed[0], collapsed[1], collapsed[2], collapsed[3]);
        return retArray;
    }

    private int[] collapse(int i1, int i2, int i3, int i4) {
        if (i4 == 0) {
            if (i3 != 0) {
                i4 = i3;
                i3 = 0;
            } else if (i2 != 0) {
                i4 = i2;
                i2 = 0;
            } else if (i1 != 0) {
                i4 = i1;
                i1 = 0;
            }
        }
        if (i3 == 0) {
            if (i2 != 0) {
                i3 = i2;
                i2 = 0;
            } else if (i1 != 0) {
                i3 = i1;
                i1 = 0;
            }
        }
        if (i2 == 0) {
            if (i1 != 0) {
                i2 = i1;
                i1 = 0;
            }
        }
        int[] retArray = new int[4];
        retArray[0] = i1;
        retArray[1] = i2;
        retArray[2] = i3;
        retArray[3] = i4;
        return retArray;
    }

    /**
     * Moves the tiles in the RIGHT direction if possible.
     * 
     * @param testOnly set true if you dont want to make changes just want to test
     *                 if movement is possible.
     * @return true if movement was made or possible.
     */
    public boolean moveRight(boolean testOnly) {
        boolean didMoveHappen = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = flow(table[i][0], table[i][1], table[i][2], table[i][3], testOnly);
            if (newRow[0] != table[i][0] || newRow[1] != table[i][1] || newRow[2] != table[i][2]
                    || newRow[3] != table[i][3]) {
                didMoveHappen = true;
            }
            if (!testOnly) {
                table[i][0] = newRow[0];
                table[i][1] = newRow[1];
                table[i][2] = newRow[2];
                table[i][3] = newRow[3];
            }
        }
        if (!testOnly && didMoveHappen) {
            spawnNumber();
        }
        return didMoveHappen;
    }

    /**
     * Moves the tiles in the LEFT direction if possible.
     * 
     * @param testOnly set true if you dont want to make changes just want to test
     *                 if movement is possible.
     * @return true if movement was made or possible.
     */
    public boolean moveLeft(boolean testOnly) {
        boolean didMoveHappen = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = flow(table[i][3], table[i][2], table[i][1], table[i][0], testOnly);
            if (newRow[0] != table[i][3] || newRow[1] != table[i][2] || newRow[2] != table[i][1]
                    || newRow[3] != table[i][0]) {
                didMoveHappen = true;
            }
            if (!testOnly) {
                table[i][3] = newRow[0];
                table[i][2] = newRow[1];
                table[i][1] = newRow[2];
                table[i][0] = newRow[3];
            }
        }

        if (!testOnly && didMoveHappen) {
            spawnNumber();
        }
        return didMoveHappen;
    }

    /**
     * Moves the tiles in the DOWN direction if possible.
     * 
     * @param testOnly set true if you dont want to make changes just want to test
     *                 if movement is possible.
     * @return true if movement was made or possible.
     */
    public boolean moveDown(boolean testOnly) {
        boolean didMoveHappen = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = flow(table[0][i], table[1][i], table[2][i], table[3][i], testOnly);
            if (newRow[0] != table[0][i] || newRow[1] != table[1][i] || newRow[2] != table[2][i]
                    || newRow[3] != table[3][i]) {
                didMoveHappen = true;
            }
            if (!testOnly) {
                table[0][i] = newRow[0];
                table[1][i] = newRow[1];
                table[2][i] = newRow[2];
                table[3][i] = newRow[3];
            }
        }

        if (!testOnly && didMoveHappen) {
            spawnNumber();
        }
        return didMoveHappen;
    }

    /**
     * Moves the tiles in the UP direction if possible.
     * 
     * @param testOnly set true if you dont want to make changes just want to test
     *                 if movement is possible.
     * @return true if movement was made or possible.
     */
    public boolean moveUp(boolean testOnly) {
        boolean didMoveHappen = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = flow(table[3][i], table[2][i], table[1][i], table[0][i], testOnly);
            if (newRow[0] != table[3][i] || newRow[1] != table[2][i] || newRow[2] != table[1][i]
                    || newRow[3] != table[0][i]) {
                didMoveHappen = true;
            }
            if (!testOnly) {
                table[3][i] = newRow[0];
                table[2][i] = newRow[1];
                table[1][i] = newRow[2];
                table[0][i] = newRow[3];
            }
        }

        if (!testOnly && didMoveHappen) {
            spawnNumber();
        }
        return didMoveHappen;
    }

    /**
     * Returns the given tile value if it has any.
     * 
     * @param i row
     * @param j column
     * @return text representation of tile value.
     */
    public String getTileValue(int i, int j) {
        if (table[i][j] == 0) {
            return "";
        }
        return String.format("%d", table[i][j]);
    }

    /**
     * Returns the preferred color of tile.
     * 
     * @param i row
     * @param j column
     * @return RGB color object.
     */
    public Color getTileColor(int i, int j) {
        if (table[i][j] == 0) {
            return new Color(242, 242, 242, 255);
        }
        return new Color(242, 106, 47, 60);
    }

    /**
     * Gets the actual earned points in the game.
     * 
     * @return actual points
     */
    public int getScore() {
        return points;
    }

    /**
     * Returns true if the game can go on, false if ended.
     * 
     * @return true or false if player can continue playing or not.
     */
    public boolean canGameGoOn() {
        return moveDown(true) || moveUp(true) || moveRight(true) || moveLeft(true);
    }

}
