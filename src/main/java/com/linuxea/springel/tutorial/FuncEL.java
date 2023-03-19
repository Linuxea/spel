package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class FuncEL implements ApplicationRunner {

  public static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
    standardEvaluationContext.registerFunction("reverse",
        FuncEL.class.getDeclaredMethod("reverse", String.class));

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    String value = spelExpressionParser.parseExpression("#reverse('hello')")
        .getValue(standardEvaluationContext,
            String.class);

    System.out.println(value);

  }
}
