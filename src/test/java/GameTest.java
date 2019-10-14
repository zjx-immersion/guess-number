import com.hw.domain.Answer;
import com.hw.domain.AnswerGenerator;
import com.hw.domain.AnswerGeneratorStub;
import com.hw.domain.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {


    @Test
    public void should_get_success_when_input_right_answer_first_time() {
        // given
        Answer answer = new Answer("1 2 3 4");
        AnswerGenerator answerGeneratorStub = new AnswerGeneratorStub(answer);
        Game game = new Game(answerGeneratorStub);
        String userAnswer = "1 2 3 4";
        String expectedGuessResult = "4A0B";

        // when
        String result = game.guess(userAnswer);

        // then
        Assert.assertEquals(expectedGuessResult, result);

    }

//    @Test
//    public void should_get_the_fail_status_when_guess_action_count_over_or_equal_6() {
//        // given
//        Answer answer = new Answer("1 2 3 4");
//        AnswerGenerator answerGeneratorStub = new AnswerGeneratorStub(answer);
//        Game game = new Game(answerGeneratorStub);
//        String userAnswer1 = "4 3 2 1";
//        String userAnswer2 = "4 3 2 1";
//        String userAnswer3 = "4 3 2 1";
//        String userAnswer4 = "4 3 2 1";
//        String userAnswer5 = "4 3 2 1";
//        String userAnswer6 = "4 3 2 1";
//
//        // when
//        String result1 = game.guess(userAnswer1);
//        String result2 = game.guess(userAnswer2);
//        String result3 = game.guess(userAnswer3);
//        String result4 = game.guess(userAnswer4);
//        String result5 = game.guess(userAnswer5);
//        String result6 = game.guess(userAnswer6);
//
//        // then
//        Assert.assertEquals("success", result); // ??
//
//    }
}
