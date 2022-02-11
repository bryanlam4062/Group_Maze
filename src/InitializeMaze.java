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
    public static void startGame(RoomNode[][] theBoard) {
        for (int row = 0; row < COLUMN; row++) {
            for (int col = 0; col < ROWS; col++) {
                theBoard[col][row] = new RoomNode();
            }
        }
    }
    /**
     * checks that row and col given are within bound of the board.
     * @param theCol col
     * @param theRow row
     * @return boolean
     */
    public static  boolean inBoard(int theCol, int theRow) {
        return (theRow >= 0) && ( theRow < COLUMN) &&
                (theCol >= 0) && ( theCol < ROWS);
    }
}
