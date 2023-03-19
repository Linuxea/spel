package com.linuxea.springel.tutorial;


import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class MapEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    ExpressionParser parser = new SpelExpressionParser();

    Person person = new Person();
    StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(person);

    String name = parser.parseExpression("map['name']")
        .getValue(standardEvaluationContext, String.class);
    System.out.println(name);

  }

  @Data
  public static class Person {

    private final Map<String, String> map = new HashMap<>() {{
      put("name", "linuxea");
      put("age", "39");
    }};
  }
}
