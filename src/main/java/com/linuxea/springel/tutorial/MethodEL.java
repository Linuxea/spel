package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class MethodEL implements ApplicationRunner {


  @Override
  public void run(ApplicationArguments args) throws Exception {

    ExpressionParser expressionParser = new SpelExpressionParser();
    Double random = expressionParser.parseExpression("T(java.lang.Math).random()")
        .getValue(Double.class);
    System.out.println(random);

    String name = "linuxea";
    String biggerName = expressionParser.parseExpression("toUpperCase()")
        .getValue(name, String.class);
    System.out.println(biggerName);

    Integer length = expressionParser.parseExpression("length()").getValue(name, Integer.class);
    System.out.println(length);


  }
}
