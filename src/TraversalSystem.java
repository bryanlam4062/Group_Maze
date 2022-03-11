import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

/**
 * TraversalSystem.java
 *
 * player movement on the board.
 *
 * @author Bryan Lam
 * @version Winter 2022
 */
public class TraversalSystem {

    private static boolean LEFT;
    private static boolean RIGHT;
    private static boolean UP;
    private static boolean DOWN;
    private static boolean CHEAT = true;
    private static int playerRow;
    private static int playerCol;

    /**
     * Get left.
     *
     * @return boolean
     */
    public static boolean isLEFT() {
        return LEFT;
    }

    /**
     * Set left.
     *
     * @param LEFT left
     */
    public static void setLEFT(boolean LEFT) {
        TraversalSystem.LEFT = LEFT;
    }

    /**
     * Get right.
     *
     * @return boolean
     */
    public static boolean isRIGHT() {
        return RIGHT;
    }

    /**
     * Set right.
     *
     * @param theRIGHT right
     */
    public static void setRIGHT(final boolean theRIGHT) {
        RIGHT = theRIGHT;
    }

    /**
     * Get up.
     *
     * @return boolean
     */
    public static boolean isUP() {
        return UP;
    }

    /**
     * Set up.
     *
     * @param theUP up
     */
    public static void setUP(boolean theUP) {
        UP = theUP;
    }

    /**
     * Get down.
     *
     * @return boolean
     */
    public static boolean isDOWN() {
        return DOWN;
    }

    /**
     * Set down.
     *
     * @param theDOWN down
     */
    public static void setDOWN(final boolean theDOWN) {
        DOWN = theDOWN;
    }

    /**
     * Get player row.
     *
     * @return int
     */
    public static int getPlayerRow() {
        return playerRow;
    }

    /**
     * Get player column.
     *
     * @return int
     */
    public static int getPlayerCol() {
        return playerCol;
    }

    /**
     * Set player row.
     *
     * @param theplayerRow int player rows
     */
    public static void setPlayerRow(int theplayerRow) {
        playerRow = theplayerRow;
    }

    /**
     * Set player column.
     *
     * @param thePlayerCol int player column
     */
    public static void setPlayerCol(int thePlayerCol) {
        playerCol = thePlayerCol;
    }

    /**
     * Get cheat.
     *
     * @return boolean
     */
    public static boolean isCHEAT() {
        return CHEAT;
    }

    /**
     * Set cheat.
     *
     * @param theCheat boolean
     */
    public static void setCHEAT(boolean theCheat) {
        CHEAT = theCheat;
    }

    /**
     * Check the paths available to traverse.
     *
     * @param theBoard the board
     */
    public static void checkPaths(final Room[][] theBoard) {
        setUP(false);
        setLEFT(false);
        setRIGHT(false);
        setDOWN(false);
        System.out.println("\nPath(s) available: ");
        if (theBoard[playerRow][playerCol].getKey()) {
            //left
            if (InitializeMaze.inBoard(playerRow, playerCol - 1)) {
                if (theBoard[playerRow][playerCol - 1].getKey()) {
                    setLEFT(true);
                    System.out.print("left ");
                }
            }
            //up
            if (InitializeMaze.inBoard(playerRow - 1, playerCol)) {
                if (theBoard[playerRow - 1][playerCol].getKey()) {
                    setUP(true);
                    System.out.print("up ");
                }
            }
            //down
            if (InitializeMaze.inBoard(playerRow + 1, playerCol)) {
                if (theBoard[playerRow + 1][playerCol].getKey()) {
                    setDOWN(true);
                    System.out.print("down ");
                }
            }
            //right
            if (InitializeMaze.inBoard(playerRow, playerCol + 1)) {
                if (theBoard[playerRow][playerCol + 1].getKey()) {
                    setRIGHT(true);
                    System.out.print("right ");
                }
            }
        }
    }

    /**
     * Check for validity of the user's input.
     *
     * @param theScan Scanner
     * @return the move
     */
    public static String nextMove(final Scanner theScan) {
        boolean ansCheck = true;
        String ans = null;

        while (ansCheck) {
            System.out.println("\nType next move (ex: right)");
            ans = theScan.next();
            switch (ans.toLowerCase(Locale.ROOT)) {
                case "up":
                    if (isUP()) {
                        ansCheck = false;
                    }
                    break;
                case "left":
                    if (isLEFT()) {
                        ansCheck = false;
                    }
                    break;
                case "right":
                    if (isRIGHT()) {
                        ansCheck = false;
                    }
                    break;
                case "down":
                    if (isDOWN()) {
                        ansCheck = false;
                    }
                    break;
                case "save":
                case "load":
                    ansCheck = false;
                    break;
            }
            if (ansCheck) {
                System.out.println("not a valid answer, try again.");
            }
        }
        return ans;
    }

    /**
     * Player move.
     *
     * @param theMove  String move
     * @param theBoard the board
     */
    public static void playerMove(final String theMove, final Room[][] theBoard) {
        theBoard[playerRow][playerCol] = new Room();
        switch (theMove) {
            case "up" -> {
                if(isCHEAT()) {
                theBoard[playerRow - 1][playerCol] = new Room("Player");
                playerRow -= 1;
                } else {
                    lockRoom(playerRow - 1, playerCol, theBoard);
                }
            }
            case "left" -> {
                if(isCHEAT()) {
                theBoard[playerRow][playerCol - 1] = new Room("Player");
                playerCol -= 1;
                } else {
                    lockRoom(playerRow - 1, playerCol, theBoard);
                }
            }
            case "right" -> {
                if(isCHEAT()) {
                theBoard[playerRow][playerCol + 1] = new Room("Player");
                playerCol += 1;
                } else {
                    lockRoom(playerRow - 1, playerCol, theBoard);
                }
            }
            case "down" -> {
                if(isCHEAT()) {
                theBoard[playerRow + 1][playerCol] = new Room("Player");
                playerRow += 1;
                } else {
                    lockRoom(playerRow - 1, playerCol, theBoard);
                }
            }
        }
    }


    /**
     * Locks room.
     *
     * @param theBoard the board
     */
    public static void lockRoom(final String theMove, final Room[][] theBoard) {
        switch (theMove) {
            case "up" -> {
                theBoard[playerRow - 1][playerCol] = new Room(false);
            }
            case "left" -> {
                theBoard[playerRow][playerCol - 1] = new Room(false);
            }
            case "right" -> {
                theBoard[playerRow][playerCol + 1] = new Room(false);
            }
            case "down" -> {
                theBoard[playerRow + 1][playerCol] = new Room(false);
            }
        }
    }

    /**
     * Lock room load.
     *
     * @param theRow   the row of room
     * @param theCol   column of room
     * @param theBoard the board
     */
    public static void lockRoom(final int theRow, final int theCol, final Room[][] theBoard) {
        theBoard[theRow][theCol] = new Room(false);
    }


    /**
     * Checks if player can reach end room.
     * @param theBoard the board
     * @return boolean
     */
    public static boolean winnableCheck(final Room[][] theBoard) {
        int[][] copyBoard = new int[InitializeMaze.getROWS()][InitializeMaze.getCOLUMN()];

        //use to build the paths
        class pair {
            final int Item1;
            final int Item2;

            pair(int f, int s) {
                Item1 = f;
                Item2 = s;
            }
        }
        int[][] dir
                = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<pair> q = new LinkedList<>();

        // Insert the top right corner.
        q.add(new pair(playerRow, playerCol));

        // Until queue is empty
        while (q.size() > 0) {
            pair p = (q.peek());
            q.remove();

            // Mark as visited
            copyBoard[p.Item1][p.Item2] = -1;

            // Check all four directions
            for (int i = 0; i < 4; i++) {

                int a = p.Item1 + dir[i][0];
                int b = p.Item2 + dir[i][1];

                // Not blocked and valid
                if (a >= 0 && b >= 0 && a < InitializeMaze.getROWS() && b < InitializeMaze.getCOLUMN()
                        && !theBoard[a][b].getDoor().equalsIgnoreCase("close") ) {
                    if(copyBoard[a][b] != -1)
                        q.add(new pair(a, b));
                }

                // reach end room
                if (p.Item1 == InitializeMaze.getROWS() - 1 && p.Item2 == InitializeMaze.getCOLUMN() - 1) {
                    theBoard[InitializeMaze.getROWS()-1][InitializeMaze.getCOLUMN()-1].setDoor("end");
                    return true;
                }
            }
        }
        theBoard[InitializeMaze.getROWS()-1][InitializeMaze.getCOLUMN()-1].setDoor("end");
        return false;
    }
}
