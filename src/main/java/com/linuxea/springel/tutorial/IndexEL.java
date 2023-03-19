package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class IndexEL implements ApplicationRunner {

  public String[] members = new String[]{"linuxea", "linuxea2"};

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    String value = spelExpressionParser.parseExpression("[1]")
        .getValue(members, String.class);
    System.out.println(value);

  }
}
