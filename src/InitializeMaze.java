public class InitializeMaze {

    private static int ROWS;
    private static int COLUMN;

    /**
     * sets rows
     * @param theRows side
     */
    public static void setROWS(int theRows) {
        ROWS = theRows;
    }

    /**
     * sets column
     * @param theColumn depth
     */
    public static void setCOLUMN(int theColumn) {
        COLUMN = theColumn;
    }

    /**
     * Set up the board without any bombs.
     *
     * @param theBoard board
     */
    public static <T> void buildBoard(RoomNode<T>[][] theBoard) {
        for (int row = 0; row < COLUMN; row++) {
            for (int col = 0; col < ROWS; col++) {
                theBoard[col][row] = new RoomNode<>();
            }
        }
    }
    public static <T> void playerSpawn(RoomNode<T>[][] theBoard) {
        theBoard[0][0] = new RoomNode<>("Player");
    }



    public static <T> void endRoom(int theRows, int theCol, RoomNode<T>[][] theBoard) {
        theBoard[theRows][theCol] = new RoomNode<>("end");
    }
    public static <T> boolean checkEnd(RoomNode<T>[][] theBoard) {
        if(theBoard[ROWS-1][COLUMN-1].getDoor().equals("Player")) {
            System.out.println("Congratulation!!!\n" + "You Escape!");
            return true;
        }
        return false;
    }
    /**
     * checks that row and col given are within bound of the board.
     * @param theRow row
     * @param theCol col
     * @return boolean
     */
    public static boolean inBoard(int theRow, int theCol) {
        return (theRow >= 0) && ( theRow < ROWS) &&
                (theCol >= 0) && ( theCol < COLUMN);
    }

}
