package com.linuxea.springel.tutorial;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class PropertyEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    Person person = new Person("linuxea", 39);

    //1.root object
    ExpressionParser parser = new SpelExpressionParser();
    String name = parser.parseExpression("name").getValue(person, String.class);
    System.out.println(name);

    //2.context for reuse the object
    EvaluationContext evaluationContext = new StandardEvaluationContext(person);
    Integer age = parser.parseExpression("age")
        .getValue(evaluationContext, Integer.class);
    System.out.println(age);


  }

  @Data
  @AllArgsConstructor
  public static class Person {

    private String name;
    private Integer age;
  }
}
