package com.hw.domain;

public class Answer {

    private final String orginalAnswerStr;

    public Answer(String orginalAnswerStr) {
        this.orginalAnswerStr = orginalAnswerStr;
    }

    public String check(String userAnswerStr) {
        if (userAnswerStr.equals(this.orginalAnswerStr)) {
            return "4A0B";
        } else {
            return "0A0B";
        }
    }
}
