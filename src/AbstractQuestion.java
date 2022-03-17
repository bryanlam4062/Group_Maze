/**
 * AbstractQuestion.java
 *
 * Defines general characteristics of a question. Applies to multiple
 * choice, short answer, and true/false questions.
 *
 * @author Shad Malabad
 * @version Winter 2022
 */
public class AbstractQuestion {

    private final String myQuestion;
    private final String myAnswer;

    /**
     * Constructor uses the trivia question and its answer
     * @param theQuestion is the trivia question
     * @param theAnswer is the answer to the respective trivia question
     */
    public AbstractQuestion(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    /**
     * Getter method for the question
     * @return the trivia question
     */
    public String getMyQuestion() {
        return myQuestion;
    }

    /**
     * Getter method for the answer to the question
     * @return the answer to the question
     */
    public String getMyAnswer() {
        return myAnswer;
    }

    /**
     *
     * @param theAnswer the answer to the question
     * @return boolean value based on if the answer is correct
     */
    public boolean verifyAnswer(String theAnswer) {
        return myAnswer.equalsIgnoreCase(theAnswer);
    }

}
