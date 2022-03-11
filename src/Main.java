import org.sqlite.SQLiteDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean gameContinue = true;
        boolean game = true;

        Scanner input = new Scanner(System.in);
        boolean result;

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
//            String source = "C:\\Users\\shadp\\TriviaMaze\\";
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
                result = false; //Just added---------------------------------------

                //checks if game is winnable
                if(TraversalSystem.winnableCheck(board)) {
                    //checks and move
                    TraversalSystem.checkPaths(board);
                    System.out.println("\nsave game? (type save)");
                    String move = TraversalSystem.nextMove(scan);
                    //question

                    if(!move.equalsIgnoreCase("save")) {
                        result = promptQuestion(input);
                        if (result) {
                            System.out.println("Correct!");
                            TraversalSystem.playerMove(move, board);
                        } else {
                            System.out.println("Incorrect!");
                            TraversalSystem.lockRoom(move, board);
                        }
                    }


//                    TraversalSystem.playerMove(move, board);
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

    private static boolean promptQuestion(Scanner theInput) {
        Random randy = new Random();
        int randomNum = randy.nextInt(3) + 1;
//        int randomNum = 3;  //For Testing
        SQLiteDataSource ds = new SQLiteDataSource();;
        try {
            ds.setUrl("jdbc:sqlite:identifier.sqlite");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        if (randomNum == 1) {           //multiple choice
            MultChoice questionMC;
            String query = "SELECT * FROM MultipleChoice ORDER BY RANDOM() LIMIT 1";
            try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rSet = stmt.executeQuery(query);
                ArrayList<String> options = new ArrayList<>();
                options.add(rSet.getString("Answer"));
                options.add(rSet.getString("Wrong1"));
                options.add(rSet.getString("Wrong2"));
                options.add(rSet.getString("Wrong3"));
                questionMC = new MultChoice(rSet.getString("Question"), rSet.getString("Answer"), options);
                System.out.println(questionMC.getMyQuestion());
                String userInput = theInput.nextLine();
                return questionMC.verifyAnswer(userInput);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }

        } else if (randomNum == 2) {    //short answer
            ShortAnswer questionSA;
            String query = "SELECT * FROM ShortAnswer ORDER BY RANDOM() LIMIT 1";
            try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rSet = stmt.executeQuery(query);
                questionSA = new ShortAnswer(rSet.getString("Question"), rSet.getString("Answer"));
                System.out.println(questionSA.getMyQuestion());
                String userInput = theInput.nextLine();
                return questionSA.verifyAnswer(userInput);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }

        } else if (randomNum == 3) {    //true false
            TrueFalse questionTF;
            String query = "SELECT * FROM TrueFalse ORDER BY RANDOM() LIMIT 1";
            try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
                ResultSet rSet = stmt.executeQuery(query);
                questionTF = new TrueFalse(rSet.getString("Question"), rSet.getString("Answer"));
                System.out.println(questionTF.getMyQuestion());
                String userInput = theInput.nextLine();
                return questionTF.verifyAnswer(userInput);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        return false;
    }

}













