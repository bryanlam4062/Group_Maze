import java.util.ArrayList;

/**
 * MultChoice.java
 *
 * Responsible for creating the multiple choice questions and extends
 * AbstractQuestion
 *
 * @author Shad Malabad
 * @version Winter 2022
 */
public class MultChoice extends AbstractQuestion {

    private final ArrayList<String> myAnswerOptions;

    /**
     * Puts together the multiple choice question
     * @param theQuestion the trivia question
     * @param theAnswer appropriate correct answer
     * @param theAnswerOptions wrong answer options for the question
     */
    public MultChoice(String theQuestion, String theAnswer, ArrayList<String> theAnswerOptions) {
        super(theQuestion, theAnswer);
        myAnswerOptions = theAnswerOptions;
    }

    /**
     * Returns the arraylist of answer options
     * @return the answer options to the question
     */
    public ArrayList<String> getAnswerOptions() {
        return myAnswerOptions;
    }

    /**
     * Getter method for the trivia questions and its answer options
     * @return the trivia question and other answer options
     */
    public String getMyQuestion() {
        return super.getMyQuestion() + getAnswerOptions().toString();
    }

}
