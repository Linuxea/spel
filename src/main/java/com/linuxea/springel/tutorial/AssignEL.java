package com.linuxea.springel.tutorial;

import java.util.Arrays;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class AssignEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    //build context for reuse
    Person person = new Person();
    StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(person);
    // assign value
    spelExpressionParser.parseExpression("scores[0]").setValue(standardEvaluationContext, 100);
    // get value
    Integer[] scores = person.getScores();
    System.out.println(Arrays.toString(scores));

  }

  @Data
  public static class Person {

    private Integer[] scores = new Integer[5];
  }
}
