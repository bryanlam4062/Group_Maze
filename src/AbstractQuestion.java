public class AbstractQuestion {
    private final String myQuestion;
    private final String myAnswer;

    public AbstractQuestion(final String theQuestion, final String theAnswer) {
        myQuestion = theQuestion;
        myAnswer = theAnswer;
    }

    public String getMyQuestion() {
        return myQuestion;
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public boolean verifyAnswer(String theAnswer) {
        return myAnswer.equalsIgnoreCase(theAnswer);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> a81e63cc84869cbf7396324643cf289663435bdb
