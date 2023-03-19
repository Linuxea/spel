package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class LogicalEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    Boolean trueAndTrue = spelExpressionParser.parseExpression("true and true")
        .getValue(Boolean.class);
    System.out.println(trueAndTrue);

    Boolean trueAndFalse = spelExpressionParser.parseExpression("true and false")
        .getValue(Boolean.class);
    System.out.println(trueAndFalse);

    Boolean falseAndFalse = spelExpressionParser.parseExpression("false and false")
        .getValue(Boolean.class);
    System.out.println(falseAndFalse);

    Boolean falseOrTrue = spelExpressionParser.parseExpression("false or true")
        .getValue(Boolean.class);
    System.out.println(falseOrTrue);

  }
}
