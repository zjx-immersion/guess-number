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

        if (record[0] == 4) {
            return "4A0B";
        } else if (record[0] == 1) {
            return "1A1B";
        } else {
            return "0A0B";
        }
    }
}
//            userAnswer.stream().forEach(num -> {
//                int index = userAnswer.indexOf(num);
//                if (index != -1) {
//                    long[] guessResult = new long[2];
//                    if (index == this.numList.indexOf(num)) {
//                        guessResult[0]++;
//                    } else {
//                        guessResult[1]++;
//                    }
//                }
//            });
