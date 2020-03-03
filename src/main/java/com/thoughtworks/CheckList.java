package com.thoughtworks;

import java.util.List;
import java.util.Map;

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

    public CheckList() {
    }

    public CheckList(List<CheckAnswer> checkAnswerList) {
        this.checkAnswerList = checkAnswerList;
    }

    public List<CheckAnswer> getCheckAnswerList() {
        return checkAnswerList;
    }

    public void setCheckAnswerList(List<CheckAnswer> checkAnswerList) {
        this.checkAnswerList = checkAnswerList;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void addCheckAnswer(CheckAnswer checkAnswer) {
        this.isCorrect = checkAnswer.isCorrect();
        checkAnswerList.add(checkAnswer);
    }
}
