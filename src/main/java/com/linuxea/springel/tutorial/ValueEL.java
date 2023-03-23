package com.linuxea.springel.tutorial;

import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class ValueEL implements ApplicationRunner {

  @Value("${numbers}")
  private Set<Integer> integers;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(integers);
  }
}
