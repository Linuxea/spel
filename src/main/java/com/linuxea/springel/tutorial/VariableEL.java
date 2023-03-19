package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class VariableEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    // context variable
    StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
    standardEvaluationContext.setVariable("hello", "hello world");

    String value = spelExpressionParser.parseExpression("#hello")
        .getValue(standardEvaluationContext, String.class);
    System.out.println(value);

  }
}
