import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);


        char[][] board = new char[4][4];
        int testRow = 4;

        TraversalSystem.setROWS(testRow);
        TraversalSystem.setCOLUMN(testRow);

        TraversalSystem.startGame(board);

        System.out.println(Arrays.deepToString(board).replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("[", "")
                .replace(",", ""));
    }
    public static void StartRoom(char theBoard) {

    }
    public static void endRoom() {

    }
}
