package com.stackbuilders.javaday;

import static com.stackbuilders.javaday.HighOrder.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HighOrderTest {
  @Test
  public void filterEmptyListReturnsEmptyList() {
    Integer[] numbers = new Integer[] {};
    F<Integer, Boolean> isEven = new F<Integer, Boolean>() {
      public Boolean apply(Integer x) {
        return x % 2 == 0;
      }
    };
    assertThat(filter(isEven, numbers), empty());
  }

  @Test
  public void filterNonEmptyListReturnsElementsMatchingPredicate() {
    Integer[] numbers = new Integer[] { 1, 2, 3, 4 };
    F<Integer, Boolean> isEven = new F<Integer, Boolean>() {
      public Boolean apply(Integer x) {
        return x % 2 == 0;
      }
    };
    assertThat(filter(isEven, numbers), contains(2, 4));
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

  @Test
  public void mapNonEmptyListAppliesFunctionToEachElement() {
    Integer[] numbers = new Integer[] { 1, 2, 3, 4 };
    // EXPLAIN: Assign a function to a variable
    F<Integer, Integer> addOne = new F<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    };
    // EXPLAIN: passing a function as an argument
    assertThat(map(addOne, numbers), contains(2, 3, 4, 5));
  }
}
