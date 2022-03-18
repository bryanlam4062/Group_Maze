import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuestionsTest.java
 *
 * Tests for correct and incorrect answers for multiple choice, short
 * answer, and true/false questions.
 *
 * @author Shad Malabad
 * @version Winter 2022
 */
class QuestionsTest {

    /**
     * Test for event of a correct multiple choice question
     */
    @Test
    public void correctMultipleChoice() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Jan 15");
        options.add("Aug 26");
        options.add("Dec 24");
        MultChoice actual = new MultChoice("When is Seong Gi-hun's birthday?", "April 26", options);
        assertTrue(actual.verifyAnswer("April 26"));
    }

    /**
     * Test for event of a wrong multiple choice question
     */
    @Test
    public void wrongMultipleChoice() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Jan 15");
        options.add("Aug 26");
        options.add("Dec 24");
        MultChoice actual = new MultChoice("When is Seong Gi-hun's birthday?", "April 26", options);
        assertFalse(actual.verifyAnswer("Dec 24"));
    }

    /**
     * Test for event of a correct short answer question
     */
    @Test
    public void correctShortAnswer() {
        ShortAnswer actual = new ShortAnswer("What country is Ali from?", "Pakistan");
        assertTrue(actual.verifyAnswer("Pakistan"));
    }

    /**
     * Test for event of a wrong short answer question
     */
    @Test
    public void wrongShortAnswer() {
        ShortAnswer actual = new ShortAnswer("What country is Ali from?", "Pakistan");
        assertFalse(actual.verifyAnswer("Canada"));
    }

    /**
     * Test for event of a correct true or false question
     */
    @Test
    public void correctTrueFalse() {
        TrueFalse actual = new TrueFalse("A square is one of the mask symbols", "T");
        assertTrue(actual.verifyAnswer("T"));
    }

    /**
     * Test for event of a wrong true or false question
     */
    @Test
    public void wrongTrueFalse() {
        TrueFalse actual = new TrueFalse("A square is one of the mask symbols", "T");
        assertFalse(actual.verifyAnswer("F"));
    }

}
