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
}
