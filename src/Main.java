import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean gameContinue = true;
        boolean game = true;

        while(game) {
            //sets up rows and column
            int row = 4;
            int col = 4;
            InitializeMaze.setROWS(row);
            InitializeMaze.setCOLUMN(col);

            //sets up board
            Room[][] board = new Room[InitializeMaze.getROWS()][InitializeMaze.getCOLUMN()];
            InitializeMaze.buildBoard(board);
            InitializeMaze.playerSpawn(board);
            InitializeMaze.endRoom(board);

            System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                    .replace("[[", "")
                    .replace("]]", "")
                    .replace("[", "")
                    .replace(",", ""));

//            String source = "C:\\Users\\bryan\\Documents\\git old\\";
//            File file = new File(source + "saveData.txt");
//            Scanner sc = new Scanner(file);
//
//            board = SavingProgress.load(board, sc);
//            SavingProgress.save(board);
            while(gameContinue) {
                //checks and move
                TraversalSystem.checkPaths(board);
                String move = TraversalSystem.nextMove(scan);
                TraversalSystem.playerMove(move, board);

                System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                        .replace("[[", "")
                        .replace("]]", "")
                        .replace("[", "")
                        .replace(",", ""));
                gameContinue = (!InitializeMaze.checkEnd(board));
            }
            //restarts if user wants
            System.out.println("Start Over? (start) \n" + "End? (default)");
            String ans = scan.next();
            if(!ans.equalsIgnoreCase("start")) {
                game = false;
            }
            gameContinue = true;
        }

    }

}
