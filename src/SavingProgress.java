import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * SavingProgress.java
 *
 * Save and load game.
 *
 * @author Bryan Lam
 * @version Winter 2022
 */
public class SavingProgress {
    /**
     * Load game.
     * @param theBoard the board
     * @param theFile save data
     * @return the board
     */
    public static Room[][] load(Room[][] theBoard, Scanner theFile) {
        int row = theFile.nextInt();
        int col = theFile.nextInt();
        while(theFile.hasNext()) {
            for(int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    theBoard[r][c] = new Room(theFile.next());
                    if(theBoard[r][c].getDoor().equalsIgnoreCase("locked")) {
                        TraversalSystem.lockRoom(r, c, theBoard);
                    }
                    if(theBoard[r][c].getDoor().equalsIgnoreCase("Player")) {
                        TraversalSystem.setPlayerRow(r);
                        TraversalSystem.setPlayerCol(c);
                    }
                }
            }
        }

        return theBoard;
    }

    /**
     * Save current board.
     * @param theBoard the board
     */
    public static void save(Room[][] theBoard) {
        try {

            File file = new File("saveData.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(InitializeMaze.getROWS() + " " + InitializeMaze.getCOLUMN() + "\n");
                bw.write(Arrays.deepToString(theBoard).replace("], ", "\n")
                        .replace("[[", "")
                        .replace("]]", "")
                        .replace("[", "")
                        .replace(",", ""));
            }

            System.out.println("Your Game was saved with success !");
            System.out.println(file);

        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}
