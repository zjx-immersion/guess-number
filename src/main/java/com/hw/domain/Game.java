package com.hw.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final AnswerGenerator answerGeneratorStub;
    private final Answer originalAnswer;
    private final List<String> guessResults;
    private final String CORRECT_ANSWER_RESULT_STANDAR = "4A0B";
    private final String GAME_SUCCESS_STATUS = "success";
    private final String GAME_CONTIMUE_STATUS = "continue";

    public Game(AnswerGenerator AnswerGenerator) {
        this.answerGeneratorStub = AnswerGenerator;
        this.originalAnswer = answerGeneratorStub.run();
        this.guessResults = new ArrayList<>();
    }

    public String guess(String userAnswer) throws OutOfGuessCountException {
        if (this.checkStatus() != "continue") {
            throw new OutOfGuessCountException("Guess count cant over 6!");
        }
        String guessResult = this.originalAnswer.check(userAnswer);
        this.guessResults.add(guessResult);
        return guessResult;
    }

    public String checkStatus() {
        boolean isSuccess = guessResults.stream().anyMatch(result -> result.equals(CORRECT_ANSWER_RESULT_STANDAR));
        if (isSuccess) {
            return GAME_SUCCESS_STATUS;
        } else if (guessResults.size() == 6) {
            String GAME_FAIL_STATUS = "fail";
            return GAME_FAIL_STATUS;
        } else {
            return GAME_CONTIMUE_STATUS;
        }
    }
}
