import com.hw.domain.Answer;
import com.hw.domain.AnswerGenerator;

public class AnswerGeneratorStub implements AnswerGenerator {

    private final Answer answer;

    public AnswerGeneratorStub(Answer answer) {
        this.answer = answer;
    }

    @Override
    public Answer run() {
        return this.answer;
    }
}
