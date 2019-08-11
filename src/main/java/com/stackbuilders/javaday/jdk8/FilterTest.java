package com.stackbuilders.javaday.jdk8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterTest {
  public static void test1() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6};
    Stream.of(numbers).filter(x -> x % 2 ==0);
  }

  public static void test2() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6};
    Predicate<Integer> isEven = x -> x % 2 == 0;
    Stream.of(numbers).filter(isEven);
  }

  public static void test3() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6};
    Predicate<Integer> isEven = new Predicate<Integer>() {
      public boolean test(Integer x) {
        return x % 2 == 0;
      }
    };
    Stream.of(numbers).filter(isEven);
  }
}
