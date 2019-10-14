package com.hw.domain;

public class Game {

    private final AnswerGenerator answerGeneratorStub;
    private final Answer originalAnswer;

    public Game(AnswerGenerator AnswerGenerator) {
        this.answerGeneratorStub = AnswerGenerator;
        this.originalAnswer = answerGeneratorStub.run();
    }

    public String guess(String userAnswer) {
        return this.originalAnswer.check(userAnswer);

    }
}
