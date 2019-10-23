import com.hw.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        this.game = initGame();
    }

    private Game initGame() {
        Answer answer = new Answer("1 2 3 4");
        AnswerGenerator answerGeneratorStub = new AnswerGeneratorStub(answer);
        return new Game(answerGeneratorStub);
    }

    @Test
    public void should_get_success_when_input_right_answer_first_time() throws OutOfGuessCountException {
        // given
        String userAnswer = "1 2 3 4";
        String expectedGuessResult = "4A0B";
        String expectedStatus = "success";

        // when
        String result = game.guess(userAnswer);
        String statusOfGame = game.checkStatus();

        // then
        Assert.assertEquals(expectedGuessResult, result);
        Assert.assertEquals(expectedStatus, statusOfGame);

    }

    @Test
    public void should_get_the_fail_status_when_guess_action_count_over_or_equal_6() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "4 3 2 1";
        String userAnswer3 = "4 3 2 1";
        String userAnswer4 = "4 3 2 1";
        String userAnswer5 = "4 3 2 1";
        String userAnswer6 = "4 3 2 1";

        String expectStatusOfGame = "fail";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String result3 = game.guess(userAnswer3);
        String result4 = game.guess(userAnswer4);
        String result5 = game.guess(userAnswer5);
        String result6 = game.guess(userAnswer6);
        String statusOfGame = game.checkStatus();

        // then
        Assert.assertEquals(expectStatusOfGame, statusOfGame);
    }

    @Test
    public void should_get_the_success_status_when_second_guess_input_is_correct() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "1 2 3 4";

        String expectStatusOfGame = "success";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String statusOfGame = game.checkStatus();

        // then
        Assert.assertEquals(expectStatusOfGame, statusOfGame);
    }

    @Test
    public void should_get_the_continue_status_when_guess_action_count_less_than_6() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "4 3 2 1";

        String expectStatusOfGame = "continue";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String statusOfGame = game.checkStatus();

        // then
        Assert.assertEquals(expectStatusOfGame, statusOfGame);
    }

    @Test
    public void should_get_the_success_status_when_the_sixth_guess_input_is_correct() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "4 3 2 1";
        String userAnswer3 = "4 3 2 1";
        String userAnswer4 = "4 3 2 1";
        String userAnswer5 = "4 3 2 1";
        String userAnswer6 = "1 2 3 4";

        String expectStatusOfGame = "success";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String result3 = game.guess(userAnswer3);
        String result4 = game.guess(userAnswer4);
        String result5 = game.guess(userAnswer5);
        String result6 = game.guess(userAnswer6);
        String statusOfGame = game.checkStatus();

        // then
        Assert.assertEquals(expectStatusOfGame, statusOfGame);
    }

    @Test(expected = OutOfGuessCountException.class)
    public void should_throw_exception_when_call_guess_after_incorrect_guess_action_number_over_6() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "4 3 2 1";
        String userAnswer3 = "4 3 2 1";
        String userAnswer4 = "4 3 2 1";
        String userAnswer5 = "4 3 2 1";
        String userAnswer6 = "4 3 2 1";
        String userAnswer7 = "1 2 3 4";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String result3 = game.guess(userAnswer3);
        String result4 = game.guess(userAnswer4);
        String result5 = game.guess(userAnswer5);
        String result6 = game.guess(userAnswer6);
        String result7 = game.guess(userAnswer7);

        // then throw execption


    }

    @Test(expected = OutOfGuessCountException.class)
    public void should_throw_exception_when_call_guess_after_correct_guess_action_number_less_6() throws OutOfGuessCountException {
        // given
        String userAnswer1 = "4 3 2 1";
        String userAnswer2 = "1 2 3 4";
        String userAnswer3 = "1 2 3 4";

        // when
        String result1 = game.guess(userAnswer1);
        String result2 = game.guess(userAnswer2);
        String result3 = game.guess(userAnswer3);

        // then throw execption


    }

}
