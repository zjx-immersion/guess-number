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
        final Integer[] record = {0, 0};

        this.numList.forEach(originalNum -> {
            int indexOfIndicatedNum = userAnswer.indexOf(originalNum);
            if (indexOfIndicatedNum != -1) {
                if (this.numList.indexOf(originalNum) == indexOfIndicatedNum) {
                    record[0]++;
                } else {
                    record[1]++;
                }
            }
        });

        String result = String.format("%1$sA%2$sB", record[0], record[1]);
        return result;
    }
}
