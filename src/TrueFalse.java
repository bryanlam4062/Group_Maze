/**
 * TrueFalse.java
 *
 * Responsible for creating the true/false questions and extends
 * AbstractQuestion
 *
 * @author Shad Malabad
 * @version Winter 2022
 */
public class TrueFalse extends AbstractQuestion {

    /**
     * Constructs the true/false type questions
     * @param theQuestion the true/false question
     * @param theAnswer the respective correct answer
     */
    public TrueFalse(String theQuestion, String theAnswer) {
        super(theQuestion, theAnswer);
    }

}
