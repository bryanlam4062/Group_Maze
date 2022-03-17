/**
 * ShortAnswer.java
 *
 * Responsible for creating the short answer questions and extends
 * AbstractQuestion
 *
 * @author Shad Malabad
 * @version Winter 2022
 */
public class ShortAnswer extends AbstractQuestion{

    /**
     * Constructs the short answer type questions
     * @param theQuestion the short answer question
     * @param theAnswer the question's correct answer
     */
    public ShortAnswer(String theQuestion, String theAnswer) {
        super(theQuestion, theAnswer);
    }

}
