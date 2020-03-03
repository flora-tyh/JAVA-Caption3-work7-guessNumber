package com.thoughtworks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAnswer {
    private List<Integer> rightAnswer;
    private List<Integer> inputAnswer;
    private boolean isCorrect;

    public CheckAnswer(List<Integer> inputAnswer, List<Integer> rightAnswer) {
        this.rightAnswer = rightAnswer;
        this.inputAnswer = inputAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        if (inputAnswer != null) {
            StringBuilder answer = new StringBuilder();
            for (Integer i : inputAnswer) {
                answer.append(i);
            }
            return answer.append(" ").toString() + VerifyAnswer().get(inputAnswer) + "\n";
        }
        return "";
    }

    public Map<List<Integer>, String> VerifyAnswer() {
        int correctCount = 0;
        int wrongPositionCount = 0;

        for (int i = 0; i < inputAnswer.size(); i++) {
            if (inputAnswer.get(i) == rightAnswer.get(i)) {
                correctCount++;
            }
            for (int j = 0; j < rightAnswer.size(); j++) {
                if (inputAnswer.get(i) == rightAnswer.get(j) && i != j) {
                    wrongPositionCount++;
                }
            }
        }
        Map<List<Integer>, String> checkResult = new HashMap<List<Integer>, String>();
        checkResult.put(inputAnswer, checkResultDes(correctCount, wrongPositionCount));
        return checkResult;
    }

    public String checkResultDes(int correctCount, int wrongPositionCount) {
        StringBuilder resultDes = new StringBuilder();
        if (correctCount == 4) {
            this.isCorrect = true;
            resultDes.append("Congratulations, you win!");
        } else {
            resultDes.append(correctCount).append("A").append(wrongPositionCount).append("B");
        }
        return resultDes.toString();
    }
}
