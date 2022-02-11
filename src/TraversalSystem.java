import java.util.Locale;
import java.util.Scanner;

public class TraversalSystem {

    private static boolean left;
    private static boolean right;
    private static boolean up;
    private static boolean down;

    public static boolean isLeft() {
        return left;
    }

    public static void setLeft(boolean left) {
        TraversalSystem.left = left;
    }

    public static boolean isRight() {
        return right;
    }

    public static void setRight(boolean right) {
        TraversalSystem.right = right;
    }

    public static boolean isUp() {
        return up;
    }

    public static void setUp(boolean up) {
        TraversalSystem.up = up;
    }

    public static boolean isDown() {
        return down;
    }

    public static void setDown(boolean down) {
        TraversalSystem.down = down;
    }

    /**
     * checks surrounding doors that is available to travel to.
     * @param TheCol col
     * @param theRow row
     * @param theBoard board
     */
    public static void checkPaths(int TheCol, int theRow, RoomNode[][] theBoard) {
        System.out.println("choose your path: ");
        if(theBoard[theRow][TheCol].getRoom()){
            //topmiddle
            if (InitializeMaze.inBoard(theRow, TheCol - 1)) {
                if (theBoard[theRow][TheCol - 1].getRoom()) {
                    setUp(true);
                    System.out.println("up");
                }
            }
            //leftmidlle
            if (InitializeMaze.inBoard(theRow - 1, TheCol)) {
                if (theBoard[theRow - 1][TheCol].getRoom()) {
                    setLeft(true);
                    System.out.println("left");
                }
            }
            //rightmiddle
            if (InitializeMaze.inBoard(theRow + 1, TheCol)) {
                if (theBoard[theRow + 1][TheCol].getRoom()) {
                    setRight(true);
                    System.out.println("right");
                }
            }
            //middlebottom
            if (InitializeMaze.inBoard(theRow, TheCol + 1)) {
                if (theBoard[theRow][TheCol + 1].getRoom()) {
                    setDown(true);
                    System.out.println("down");
                }
            }
        }
    }

    public int nextMove(Scanner theScan) {
        String ans = theScan.next();

        switch(ans.toLowerCase(Locale.ROOT)) {
            case "up":
                return 1;
            case "left":
                return 2;
            case "right":
                return 3;
            case "down":
                return 4;
        }
        return -1;
    }


}
