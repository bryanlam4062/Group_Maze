import java.util.Locale;
import java.util.Scanner;

public class TraversalSystem {

    private static boolean LEFT;
    private static boolean RIGHT;
    private static boolean UP;
    private static boolean DOWN;
    private static int playerRow = 0;
    private static int playerCol = 0;

    public static boolean isLEFT() {
        return LEFT;
    }

    public static void setLEFT(boolean LEFT) {
        TraversalSystem.LEFT = LEFT;
    }

    public static boolean isRIGHT() {
        return RIGHT;
    }

    public static void setRIGHT(boolean RIGHT) {
        TraversalSystem.RIGHT = RIGHT;
    }

    public static boolean isUP() {
        return UP;
    }

    public static void setUP(boolean UP) {
        TraversalSystem.UP = UP;
    }

    public static boolean isDOWN() {
        return DOWN;
    }

    public static void setDOWN(boolean DOWN) {
        TraversalSystem.DOWN = DOWN;
    }

    public static int getPlayerRow() {
        return playerRow;
    }

    public static void setPlayerRow(int theRow) {
        playerRow = theRow;
    }

    public static int getPlayerCol() {
        return playerCol;
    }

    public static void setPlayerCol(int theCol) {
        playerCol = theCol;
    }

    /**
     * checks surrounding doors that is available to travel to.
     * @param theRow row
     * @param theCol col
     * @param theBoard board
     */
    public static <T> void checkPaths(int theRow, int theCol, RoomNode<T>[][] theBoard) {
        setUP(false);
        setLEFT(false);
        setRIGHT(false);
        setDOWN(false);
        System.out.println("Path(s) available: ");
        if(theBoard[theRow][theCol].getRoom()){
            //left
            if (InitializeMaze.inBoard(theRow, theCol - 1)) {
                if (theBoard[theRow][theCol - 1].getRoom()) {
                    setLEFT(true);
                    System.out.println("left");
                }
            }
            //up
            if (InitializeMaze.inBoard(theRow - 1 , theCol)) {
                if (theBoard[theRow - 1][theCol].getRoom()) {
                    setUP(true);
                    System.out.println("up");
                }
            }
            //down
            if (InitializeMaze.inBoard(theRow + 1, theCol)) {
                if (theBoard[theRow + 1][theCol].getRoom()) {
                    setDOWN(true);
                    System.out.println("down");
                }
            }
            //right
            if (InitializeMaze.inBoard(theRow, theCol + 1)) {
                if (theBoard[theRow][theCol + 1].getRoom()) {
                    setRIGHT(true);
                    System.out.println("right");
                }
            }
        }
    }

    public static String nextMove(Scanner theScan) {
        boolean ansCheck = true;
        String ans = null;
        while(ansCheck) {
            System.out.println("Type next move (ex: right)");
            ans = theScan.next();

            switch(ans.toLowerCase(Locale.ROOT)) {
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
            }
            if(ansCheck){
                System.out.println("not a valid answer, try again.");
            }
        }
        return ans;
    }
    public static <T> void playerMove(String theMove, int theRow, int theCol, RoomNode<T>[][] theBoard) {
        theBoard[theRow][theCol] = new RoomNode<>();
        switch (theMove) {
            case "up" -> {
                theBoard[theRow - 1][theCol] = new RoomNode<>("Player");
                playerRow -= 1;
            }
            case "left" -> {
                theBoard[theRow][theCol - 1] = new RoomNode<>("Player");
                playerCol -= 1;
            }
            case "right" -> {
                theBoard[theRow][theCol + 1] = new RoomNode<>("Player");
                playerCol += 1;
            }
            case "down" -> {
                theBoard[theRow + 1][theCol] = new RoomNode<>("Player");
                playerRow += 1;
            }
        }
    }

    public static <T> void lockRoom(int theRow, int theCol, RoomNode<T>[][] theBoard) {
        theBoard[theRow][theCol] = new RoomNode<>(false);
    }



}
