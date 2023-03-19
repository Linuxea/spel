package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class TypeEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    Class<Integer> value = spelExpressionParser.parseExpression("T(Integer)").getValue(Class.class);
    System.out.println(value);

    Class<String> string = spelExpressionParser.parseExpression("T(java.lang.String)")
        .getValue(Class.class);
    System.out.println(string);

  }
}
