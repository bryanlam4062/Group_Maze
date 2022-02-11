import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);


        //char[][] board = new char[4][4];
        int testRow = 4;

        RoomNode[][] board = new RoomNode[4][4];


        InitializeMaze.setROWS(testRow);
        InitializeMaze.setCOLUMN(testRow);
        InitializeMaze.startGame(board);


        System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("[", "")
                .replace(",", ""));

    }

}
