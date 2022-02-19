import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SavingProgress {
    public static <T> RoomNode<T>[][] Load(RoomNode<T>[][] theBoard, Scanner theFile, int theRow, int theCol) {
        while(theFile.hasNext()) {
            for(int r = 0; r <= theRow; r++) {
                for (int c = 0; c <= theCol; c++) {
                    theBoard[r][c] = new RoomNode<>(theFile.next());
                }
            }
        }
        return theBoard;
    }

    public static <T> void save(RoomNode<T>[][] theBoard) {
        try {

            File file = new File("saveData.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(Arrays.deepToString(theBoard).replace("], ", "\n")
                        .replace("[[", "")
                        .replace("]]", "")
                        .replace("[", "")
                        .replace(",", ""));
            }

            System.out.println("Your Game was saved with success !");
            System.out.println(file);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
