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

            String source = "E:\\UWT 2018 - present\\UWT 2021 - 2022\\Winter\\TCSS 360\\Group_Maze\\";
            File file = new File(source + "saveData.txt");
            Scanner sc = new Scanner(file);

            System.out.println("load board? (y or n)");
            String load = scan.next();

            //load board
            if(load.equalsIgnoreCase("y")) {
                board = SavingProgress.load(board, sc);
            }

            System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                    .replace("[[", "")
                    .replace("]]", "")
                    .replace("[", "")
                    .replace(",", ""));

            while(gameContinue) {
                //checks if game is winnable
                if(TraversalSystem.winnableCheck(board)) {
                    //checks and move
                    TraversalSystem.checkPaths(board);
                    System.out.println("\nsave game? (type save)");
                    String move = TraversalSystem.nextMove(scan);
                    //question
                    TraversalSystem.playerMove(move, board);
                    //inform user right or wrong

                    //update board
                    System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                            .replace("[[", "")
                            .replace("]]", "")
                            .replace("[", "")
                            .replace(",", ""));

                    //game end when player reach end or user save game
                    gameContinue = (!InitializeMaze.checkEnd(board));
                    if(move.equalsIgnoreCase("save")) {
                        SavingProgress.save(board);
                        gameContinue = false;
                    }
                }
                else {
                    System.out.println("GameOver.");
                    gameContinue = false;
                }
            }
            //restarts if user wants
            System.out.println("""
                    Start Over? (re)\s
                    End? (default)
                    """);
            String ans = scan.next();
            if(!ans.equalsIgnoreCase("re")) {
                game = false;
            }
            gameContinue = true;
        }

    }

}
