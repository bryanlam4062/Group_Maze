import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static <T> void main(String[] arg) {
        int testRow = 4;
        RoomNode<T>[][] board = new RoomNode[4][4];
        boolean gameEndCheck = true;
        InitializeMaze.setROWS(testRow);
        InitializeMaze.setCOLUMN(testRow);
        InitializeMaze.buildBoard(board);
        InitializeMaze.playerSpawn(board);

        while (gameEndCheck) {
            InitializeMaze.endRoom(3, 3, board);
            TraversalSystem.checkPaths(TraversalSystem.getPlayerRow(),
                    TraversalSystem.getPlayerCol(), board);
            //four buttons to move in 2d
            gameEndCheck = (!InitializeMaze.checkEnd(board));
        }

//        System.out.println(Arrays.deepToString(board).replace("], ", "\n")
//                .replace("[[", "")
//                .replace("]]", "")
//                .replace("[", "")
//                .replace(",", ""));

    }


}