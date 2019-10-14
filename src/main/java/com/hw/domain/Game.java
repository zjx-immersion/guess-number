package com.hw.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final AnswerGenerator answerGeneratorStub;
    private final Answer originalAnswer;
    private final List<String> guessResults;

    public Game(AnswerGenerator AnswerGenerator) {
        this.answerGeneratorStub = AnswerGenerator;
        this.originalAnswer = answerGeneratorStub.run();
        this.guessResults = new ArrayList<>();
    }

    public String guess(String userAnswer) throws OutOfGuessCountException {
        if (this.guessResults.size() >= 6) {
            throw new OutOfGuessCountException("Guess count cant over 6!");
        }
        String guessResult = this.originalAnswer.check(userAnswer);
        this.guessResults.add(guessResult);
        return guessResult;
    }

    public String checkStatus() {
        boolean isSuccess = guessResults.stream().anyMatch(result -> result.equals("4A0B"));
        if (isSuccess) {
            return "success";
        } else if (guessResults.size() == 6) {
            return "fail";
        } else {
            return "continue";
        }
    }
}
