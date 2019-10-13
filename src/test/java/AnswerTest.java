import com.hw.domain.Answer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnswerTest {

    private Answer answer;

    @Before
    public void setUp() throws Exception {

        String orginalAnswerStr = "1 2 3 4";
        answer = new Answer(orginalAnswerStr);
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        // given
        String userAnswerStr = "5 6 7 8";
        String expectedResult = "0A0B";
        validateGuessResult(userAnswerStr, expectedResult);

    }

    @Test
    public void should_return_4A0B_when_1_2_3_4_are_all_correct() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        String userAnswerStr = "1 2 3 4";
        String expectedResult = "4A0B";

        // when
        validateGuessResult(userAnswerStr, expectedResult);

    }

    @Test
    public void should_return_1A1B_when_only_1_is_correct_and_2_is_included_with_wrong_location() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        String userAnswerStr = "1 5 2 7";
        String expectedResult = "1A1B";

        // when
        validateGuessResult(userAnswerStr, expectedResult);

    }

    @Test
    public void should_return_0A1B_when_only_1_is_included_and_location_incorrect() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        String userAnswerStr = "8 5 2 7";
        String expectedResult = "0A1B";

        // when
        validateGuessResult(userAnswerStr, expectedResult);

    }

    private void validateGuessResult(String userAnswerStr, String expectedResult) {
        // when
        String actualRestlt = answer.check(userAnswerStr);

        // then
        Assert.assertEquals(expectedResult, actualRestlt);
    }


}
