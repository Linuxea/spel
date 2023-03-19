package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ElvisEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    Boolean value = spelExpressionParser.parseExpression("1 == 1 ? true : false")
        .getValue(Boolean.class);
    System.out.println(value);
    
  }
}
