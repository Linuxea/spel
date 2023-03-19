package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class MathEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    Integer sum = spelExpressionParser.parseExpression("1 + 1").getValue(Integer.class);
    System.out.println(sum);

    String fullName = spelExpressionParser.parseExpression("'linuxea' + 'lin'")
        .getValue(String.class);
    System.out.println(fullName);

    Integer mod = spelExpressionParser.parseExpression("10 % 3").getValue(Integer.class);
    System.out.println(mod);

    Integer div = spelExpressionParser.parseExpression("10 / 3").getValue(Integer.class);
    System.out.println(div);

  }
}
