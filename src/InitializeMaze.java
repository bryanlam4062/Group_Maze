/**
 * InitializeMaze.java
 *
 * Sets up the maze to start game.
 *
 * @author Bryan lam
 * @version Winter 2022
 */
public class InitializeMaze {

    private static int ROWS;
    private static int COLUMN;

    /**
     * Get rows.
     * @return the rows
     */
    public static int getROWS() {
        return ROWS;
    }

    /**
     * Get column.
     * @return the column
     */
    public static int getCOLUMN() {
        return COLUMN;
    }

    /**
     * Sets rows
     * @param theRows side
     */
    public static void setROWS(int theRows) {
        ROWS = theRows;
    }

    /**
     * sets column.
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
    public static void buildBoard(Room[][] theBoard) {
        for (int row = 0; row < COLUMN; row++) {
            for (int col = 0; col < ROWS; col++) {
                theBoard[col][row] = new Room();
            }
        }
    }

    /**
     * Spawns player at top left of board.
     * @param theBoard the board
     */
    public static void playerSpawn(Room[][] theBoard) {
        TraversalSystem.setPlayerRow(0);
        TraversalSystem.setPlayerCol(0);
        theBoard[0][0] = new Room("Player");
    }

    /**
     * Sets end room at bottom left of board.
     * @param theBoard the board
     */
    public static void endRoom(Room[][] theBoard) {
        theBoard[ROWS-1][COLUMN-1] = new Room("end");
    }

    /**
     * Checks if player is at end room.
     * @param theBoard the board
     * @return boolean
     */
    public static boolean checkEnd(Room[][] theBoard) {
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
