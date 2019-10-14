package com.hw.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Answer {

    private List<Integer> numList;
    private final String orginalAnswerStr;

    public Answer(String orginalAnswerStr) {
        this.orginalAnswerStr = orginalAnswerStr;
        this.numList = formatAnswer(orginalAnswerStr);
    }

    private List<Integer> formatAnswer(String orginalAnswerStr) {
        return Arrays.stream(orginalAnswerStr.split(" "))
                .mapToInt(numStr -> Integer.parseInt(numStr))
                .boxed()
                .collect(Collectors.toList());
    }

    public String check(String userAnswerStr) {
        List<Integer> userAnswer = formatAnswer(userAnswerStr);
        Record record = new Record();

        this.numList.forEach(originalNum -> {
            int indexOfIndicatedNum = userAnswer.indexOf(originalNum);
            if (indexOfIndicatedNum != -1) {
                if (this.numList.indexOf(originalNum) == indexOfIndicatedNum) {
                    record.increateCorrectCount();
                } else {
                    record.increateIncludeOnlyCount();
                }
            }
        });

        return record.getValue();
    }
}
