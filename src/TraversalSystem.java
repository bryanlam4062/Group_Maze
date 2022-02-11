public class TraversalSystem {

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
    public static void startGame(char[][] theBoard) {
        for (int row = 0; row < COLUMN; row++) {
            for (int col = 0; col < ROWS; col++) {
                theBoard[col][row] = '.';
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

    /**
     * checks surrounding doors that is available to travel to.
     *
     * @param TheCol col
     * @param theRow row
     * @param theBoard board
     */
    public static void checkPaths(int TheCol, int theRow, char[][] theBoard) {
        int count = 0;
        if(theBoard[theRow][TheCol] != '*') {
            //topmiddle
            if (inBoard(theRow, TheCol - 1)) {
                if (theBoard[theRow][TheCol - 1] == '*') {
                    count++;
                }
            }
            //leftmidlle
            if (inBoard(theRow - 1, TheCol)) {
                if (theBoard[theRow - 1][TheCol] == '*') {
                    count++;
                }
            }
            //rightmiddle
            if (inBoard(theRow + 1, TheCol)) {
                if (theBoard[theRow + 1][TheCol] == '*') {
                    count++;
                }
            }
            //middlebottom
            if (inBoard(theRow, TheCol + 1)) {
                if (theBoard[theRow][TheCol + 1] == '*') {
                    count++;
                }
            }
            theBoard[theRow][TheCol] = (char) (count+'0');
        }
    }


}
