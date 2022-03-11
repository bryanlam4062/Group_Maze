import java.util.ArrayList;

public class MultChoice extends AbstractQuestion {
    private final ArrayList<String> myAnswerOptions;

    public MultChoice(String theQuestion, String theAnswer, ArrayList<String> theAnswerOptions) {
        super(theQuestion, theAnswer);
        myAnswerOptions = theAnswerOptions;
    }

    public ArrayList<String> getAnswerOptions() {
        return myAnswerOptions;
    }

    public String getMyQuestion() {
        return super.getMyQuestion() + getAnswerOptions().toString();
    }
}