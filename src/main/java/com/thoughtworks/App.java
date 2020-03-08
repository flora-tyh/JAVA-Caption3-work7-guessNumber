package com.thoughtworks;

import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    System.out.println("猜数字游戏开始！请输入四个数字");
    guessNumber(6);
  }

  public static void guessNumber(int maxGuessCount) {
    RightAnswer rightAnswer = new RightAnswer();
    rightAnswer.readAnswer();
    CheckList checkList = new CheckList(new ArrayList<>());
    int count = 0;

    while (count < maxGuessCount) {
      try {
        InputAnswer inputAnswer = new InputAnswer();
        CheckAnswer checkAnswer = new CheckAnswer(inputAnswer.getInputAnswer(), rightAnswer.getRightAnswer());
        checkList.addCheckAnswer(checkAnswer);
        System.out.println(checkList);
        if (checkAnswer.isCorrect()) {
          break;
        }
        count++;
      } catch (WrongInputException e) {
        System.out.println(e.getMessage());
      }
    }
    if (count == maxGuessCount) {
      System.out.println("Unfortunately, you have no chance, the answer is " + rightAnswer + "!");
    }
  }
}
