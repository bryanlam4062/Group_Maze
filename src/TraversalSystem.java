
public class TraversalSystem {

    private static boolean LEFT;
    private static boolean RIGHT;
    private static boolean UP;
    private static boolean DOWN;
    private static boolean CHEAT;
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

    public static void setCHEAT(boolean b) {
        CHEAT = b;
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
        String print = "Path(s) available: ";
        if(theBoard[theRow][theCol].getRoom()){
            //left
            if (InitializeMaze.inBoard(theRow, theCol - 1)) {
                if (theBoard[theRow][theCol - 1].getRoom()) {
                    setLEFT(true);
                    print += "left ";
                }
            }
            //up
            if (InitializeMaze.inBoard(theRow - 1 , theCol)) {
                if (theBoard[theRow - 1][theCol].getRoom()) {
                    setUP(true);
                    print += "up ";
                }
            }
            //down
            if (InitializeMaze.inBoard(theRow + 1, theCol)) {
                if (theBoard[theRow + 1][theCol].getRoom()) {
                    setDOWN(true);
                    print += "down ";
                }
            }
            //right
            if (InitializeMaze.inBoard(theRow, theCol + 1)) {
                if (theBoard[theRow][theCol + 1].getRoom()) {
                    setRIGHT(true);
                    print += "right";
                }
            }
        }
        System.out.println(print);
        //set print to label.
    }

    public static <T> void lockRoom(int theRow, int theCol, RoomNode<T>[][] theBoard) {
        theBoard[theRow][theCol] = new RoomNode<>(false);
    }

    public static <T> void moveLeftButton(String theMove, int theRow, int theCol, RoomNode<T>[][] theBoard){
        if (isLEFT()){
            //give question, return answer
            boolean answer = true;
            if(answer || CHEAT) {
                //set label CORRECT!
                theBoard[theRow][theCol] = new RoomNode<>();
                theBoard[theRow - 1][theCol] = new RoomNode<>("Player");
                setPlayerRow(theRow-1);
            } else {
                //set label WRONG!
                lockRoom(theRow-1, theCol, theBoard);
            }
        } else {
            //set label to "left not available"
        }
    }
    public static <T> void moveRightButton(String theMove, int theRow, int theCol, RoomNode<T>[][] theBoard){
        if(isRIGHT()) {
            //give question, return answer
            boolean answer = true;
            if(answer || CHEAT) {
                //set label CORRECT!
                theBoard[theRow][theCol] = new RoomNode<>();
                theBoard[theRow][theCol - 1] = new RoomNode<>("Player");
                setPlayerCol(theCol-1);
            } else {
                //set label WRONG!
                lockRoom(theRow, theCol-1, theBoard);
            }
        } else {
            //set label to "right not available"
        }

    }
    public static <T> void moveUpButton(String theMove, int theRow, int theCol, RoomNode<T>[][] theBoard){
        if(isUP()) {
            //give question, return answer
            boolean answer = true;
            if(answer|| CHEAT) {
                //set label CORRECT!
                theBoard[theRow][theCol] = new RoomNode<>();
                theBoard[theRow][theCol + 1] = new RoomNode<>("Player");
                setPlayerCol(theCol+1);
            }  else {
                //set label WRONG!
                lockRoom(theRow, theCol+1, theBoard);
            }
        } else {
            //set label to "up not available"
        }

    }
    public static <T> void moveDownButton(String theMove, int theRow, int theCol, RoomNode<T>[][] theBoard){
        if(isDOWN()) {
            //give question, return answer
            boolean answer = true;
            if(answer|| CHEAT) {
                //set label CORRECT!
                theBoard[theRow][theCol] = new RoomNode<>();
                theBoard[theRow + 1][theCol] = new RoomNode<>("Player");
                setPlayerRow(theRow+1);
            } else {
                //set label WRONG!
                lockRoom(theRow+1, theCol, theBoard);
            }
        } else {
            //set label to "down not available"
        }
    }


}
