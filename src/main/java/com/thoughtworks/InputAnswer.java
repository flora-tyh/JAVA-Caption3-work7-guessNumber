package com.thoughtworks;

import java.util.*;
import java.util.regex.Pattern;

public class InputAnswer {
    private ArrayList<Integer> inputAnswer;
    private final static int answerLength = 4;

    @Override
    public String toString() {
        if (inputAnswer != null) {
            StringBuilder answer = new StringBuilder();
            for (Integer i : inputAnswer) {
                answer.append(i);
            }
            return answer.toString();
        }
        return "";
    }

    public List<Integer> getInputAnswer() throws WrongInputException {
        List<Integer> inputAnswer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String i = sc.next();
        for (char letter : i.toCharArray()) {
            inputAnswer.add(letter - '0');
        }
        if (!isFourNumber(i)) {
            throw new WrongInputException("Wrong input is not four");
        }
        if (isNumberRepeat(inputAnswer)) {
            throw new WrongInputException("Wrong input repeat");
        }
        return inputAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputAnswer)) return false;
        InputAnswer that = (InputAnswer) o;
        return Objects.equals(inputAnswer, that.inputAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputAnswer);
    }

    public boolean isFourNumber(String numbers) {
        String pattern = "\\d{" + answerLength + "}";
        boolean isNumber = Pattern.matches(pattern, numbers);
        return isNumber;
    }

    public boolean isNumberRepeat(List inputAnswer) {
        Set<Integer> noRepeatAnswer = new HashSet<>(inputAnswer);
        return !(inputAnswer.size() == noRepeatAnswer.size());
    }
}
