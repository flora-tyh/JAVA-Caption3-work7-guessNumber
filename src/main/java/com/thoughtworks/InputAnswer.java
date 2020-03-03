package com.thoughtworks;

import java.util.*;
import java.util.regex.Pattern;

public class InputAnswer {
    private ArrayList<Integer> inputAnswer;

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

    public void setInputAnswer(ArrayList<Integer> inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    public List<Integer> getInputAnswer() throws WrongInputException {
        List<Integer> inputAnswer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String i = sc.next();
        String[] numbers = i.split("");

        if (isFourNumber(numbers)) {
            int inputNumber = Integer.parseInt(i);
            for (int n = 0; n < 4; n++) {
                inputAnswer.add(inputNumber % 10);
                inputNumber /= 10;
            }
            if (isNumberRepeat(inputAnswer)) {
                throw new WrongInputException("Wrong input repeat");
            }
            Collections.reverse(inputAnswer);
            return inputAnswer;
        } else {
            System.out.println(i);
            throw new WrongInputException("Wrong input is not four");
        }
    }

    public boolean isFourNumber(String[] numbers) {
        if (numbers.length != 4) {
            return false;
        } else {
            String pattern = "\\d";
            for (String number : numbers) {
                boolean isNumber = Pattern.matches(pattern, number);
                if (!isNumber) {
                    return false;
                };
            }
        }
        return true;
    }

    public boolean isNumberRepeat(List inputAnswer) {
        Set<Integer> noRepeatAnswer = new HashSet<>(inputAnswer);
        return !(inputAnswer.size() == noRepeatAnswer.size());
    }
}
