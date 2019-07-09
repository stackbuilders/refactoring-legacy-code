package com.stackbuilders.javaday;

import static com.stackbuilders.javaday.HighOrder.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HighOrderTest {
  @Test
  public void mapNonEmptyListAppliesFunctionToEachElement() {
    Integer[] numbers = new Integer[] { 1, 2, 3, 4 };
    F<Integer, Integer> addOne = new F<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    };
    assertThat(map(addOne, numbers), contains(2, 3, 4, 5));
  }

  @Test
  public void mapEmptyListReturnsEmptyList() {
    Integer[] numbers = new Integer[] {};
    F<Integer, Integer> addOne = new F<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    };
    assertThat(map(addOne, numbers), empty());
  }
}
