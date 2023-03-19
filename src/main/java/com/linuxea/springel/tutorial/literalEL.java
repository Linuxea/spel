package com.linuxea.springel.tutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class literalEL implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) {
    ExpressionParser parser = new SpelExpressionParser();

    //1.string
    String string = (String) parser.parseExpression("'Hello World'").getValue();
    System.out.println(string);

    //2.1 integer
    Integer integer = (Integer) parser.parseExpression("123").getValue();
    System.out.println(integer);
    //2.2 float
    Float aFloat = (Float) parser.parseExpression("123.3F").getValue();
    System.out.println(aFloat);
    //2.3 double
    Double aDouble = (Double) parser.parseExpression("1234.45D").getValue();
    System.out.println(aDouble);

    //3.boolean
    Boolean aTrue = (Boolean) parser.parseExpression("true").getValue();
    System.out.println(aTrue);
    Boolean aFalse = (Boolean) parser.parseExpression("false").getValue();
    System.out.println(aFalse);

    //4.null
    Object aNull = parser.parseExpression("null").getValue();
    System.out.println(aNull);

    //other
    String value = parser.parseExpression("'Hello World!'").getValue(String.class);
    System.out.println(value);

  }
}
