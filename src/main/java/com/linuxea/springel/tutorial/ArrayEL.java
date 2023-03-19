package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ArrayEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    ExpressionParser parser = new SpelExpressionParser();
    int[] number1 = parser.parseExpression("new int[4]").getValue(int[].class);
    System.out.println(number1);

    // Array with initializer
    int[] numbers2 = parser.parseExpression("new int[]{1,2,3}").getValue(int[].class);
    System.out.println(numbers2);

// Multi dimensional array
    int[][] numbers3 = parser.parseExpression("new int[4][5]").getValue(int[][].class);
    System.out.println(numbers3);

  }
}
