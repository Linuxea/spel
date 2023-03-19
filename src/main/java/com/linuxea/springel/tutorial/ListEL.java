package com.linuxea.springel.tutorial;

import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class ListEL implements ApplicationRunner {


  @Override
  public void run(ApplicationArguments args) throws Exception {

    ExpressionParser parser = new SpelExpressionParser();
    List value = parser.parseExpression("{1, 2, 3, 4}").getValue(List.class);
    System.out.println(value);

  }
}
