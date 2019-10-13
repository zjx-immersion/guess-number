import com.hw.domain.Answer;
import org.junit.Assert;
import org.junit.Test;

public class AnswerTest {

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        Answer answer = new Answer(orginalAnswerStr);
        String userAnswerStr = "5 6 7 8";
        String expectedResult = "0A0B";

        // when
        String actualRestlt = answer.check(userAnswerStr);

        // then
        Assert.assertSame(expectedResult, actualRestlt);

    }

    @Test
    public void should_return_4A0B_when_1_2_3_4_are_all_correct() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        Answer answer = new Answer(orginalAnswerStr);
        String userAnswerStr = "1 2 3 4";
        String expectedResult = "4A0B";

        // when
        String actualRestlt = answer.check(userAnswerStr);

        // then
        Assert.assertSame(expectedResult, actualRestlt);

    }

    @Test
    public void should_return_1A1B_when_only_1_is_correct_and_2_is_included_with_wrong_location() {
        // given
        String orginalAnswerStr = "1 2 3 4";
        Answer answer = new Answer(orginalAnswerStr);
        String userAnswerStr = "1 5 2 7";
        String expectedResult = "1A1B";

        // when
        String actualRestlt = answer.check(userAnswerStr);

        // then
        Assert.assertSame(expectedResult, actualRestlt);

    }

}
