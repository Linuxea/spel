package com.linuxea.springel.tutorial;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class ThisEl implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    List<Integer> numbers = new ArrayList<>() {
      {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(10);
      }
    };
    StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
    standardEvaluationContext.setVariable("numbers", numbers);

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    spelExpressionParser.parseExpression("#numbers.?[#this%2==0]")
        .getValue(standardEvaluationContext, List.class)
        .forEach(System.out::println);
  }

}
