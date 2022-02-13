import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static <T> void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int testRow = 4;
        RoomNode<T>[][] board = new RoomNode[4][4];
        boolean gameEndCheck = true;
        InitializeMaze.setROWS(testRow);
        InitializeMaze.setCOLUMN(testRow);
        InitializeMaze.buildBoard(board);
        InitializeMaze.playerSpawn(board);

        System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("[", "")
                .replace(",", ""));

        while(gameEndCheck) {
            InitializeMaze.endRoom(3, 3, board);
            TraversalSystem.checkPaths(TraversalSystem.getPlayerRow(),
                    TraversalSystem.getPlayerCol(), board);
            String move = TraversalSystem.nextMove(scan);
            TraversalSystem.playerMove(move, TraversalSystem.getPlayerRow(),
                    TraversalSystem.getPlayerCol(), board);
            System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                    .replace("[[", "")
                    .replace("]]", "")
                    .replace("[", "")
                    .replace(",", ""));
            gameEndCheck = (!InitializeMaze.checkEnd(board));
        }

//        System.out.println(Arrays.deepToString(board).replace("], ", "\n")
//                .replace("[[", "")
//                .replace("]]", "")
//                .replace("[", "")
//                .replace(",", ""));

    }

}
