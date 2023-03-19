package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ConstructorEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    String value = spelExpressionParser.parseExpression("new String('hello')")
        .getValue(String.class);
    System.out.println(value);

    Integer length = spelExpressionParser.parseExpression("length").getValue(value, Integer.class);
    System.out.println(length);

  }
}
