package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class OperatorEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    ExpressionParser parser = new SpelExpressionParser();
    // evaluates to true
    boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
    System.out.println(trueValue);

    // evaluates to false
    boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
    System.out.println(falseValue);

    // evaluates to true
    boolean value = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
    System.out.println(value);

  }
}
