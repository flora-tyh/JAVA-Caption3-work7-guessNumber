package com.thoughtworks;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RightAnswer {
    private List<Integer> rightAnswer = new ArrayList<>();
    private static final Path ANSWER_PATH = Paths.get("answer.txt");

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

    public void readAnswer() {
        final int CHAR_TO_INT = 48;
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(ANSWER_PATH.toString())) {
            Objects.requireNonNull(inputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String number = reader.readLine();
            for (char i : number.toCharArray()) {
                rightAnswer.add(i - CHAR_TO_INT);
            }
        } catch (Exception e) {
            rightAnswer = makeAnswer();
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
