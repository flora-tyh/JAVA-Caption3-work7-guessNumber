package com.thoughtworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class RightAnswer implements MakeAnswer{
    private List<Integer> rightAnswer;

    public RightAnswer() {
    }

    @Override
    public String toString() {
        if (rightAnswer != null) {
            StringBuilder answer = new StringBuilder();
            for (Integer i : rightAnswer) {
                answer.append(i);
            }
            return answer.toString();
        } else {
            return "";
        }
    }

    public List<Integer> getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(List<Integer> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void readAnswer() {
        final int charToNum = 48;
        File answerFile = new File("./src/main/java/com/thoughtworks/answer.txt");
        try (FileInputStream fileInputStream = new FileInputStream(answerFile)){
            int i;
            while ((i = fileInputStream.read()) != -1) {
                rightAnswer.add(i - charToNum);
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
            rightAnswer = makeAnswer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> makeAnswer() {
        List<Integer> rightAnswer = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rightAnswer.add(i);
        }
        Collections.shuffle(rightAnswer);
        return rightAnswer.subList(0, 4);
    }
}
