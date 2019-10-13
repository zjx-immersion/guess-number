package com.hw.domain;

import java.util.Arrays;
import java.util.List;
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
        Integer correctCount = 0;

        for (int i = 0; i < this.numList.size(); i++) {
            if (this.numList.get(i) == userAnswer.get(i)) {
                correctCount++;
                continue;
            }
        }
        if (correctCount == 4) {
            return "4A0B";
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
