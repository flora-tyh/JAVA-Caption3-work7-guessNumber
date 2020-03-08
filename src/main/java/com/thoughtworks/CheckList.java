package com.thoughtworks;

import java.util.List;

public class CheckList {
    private List<CheckAnswer> checkAnswerList;
    private boolean isCorrect;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CheckAnswer answer : checkAnswerList) {
            stringBuilder.append(answer);
        }
        return stringBuilder.toString() ;
    }

    public CheckList(List<CheckAnswer> checkAnswerList) {
        this.checkAnswerList = checkAnswerList;
    }

    public void addCheckAnswer(CheckAnswer checkAnswer) {
        this.isCorrect = checkAnswer.isCorrect();
        checkAnswerList.add(checkAnswer);
    }
}
