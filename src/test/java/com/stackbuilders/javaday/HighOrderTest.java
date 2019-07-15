package com.stackbuilders.javaday;

import static com.stackbuilders.javaday.HighOrder.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HighOrderTest {
  @Test
  public void filterEmptyListReturnsEmptyList() {
    Integer[] numbers = new Integer[] {};
    Predicate<Integer> isEven = new Predicate<Integer>() {
      public Boolean apply(Integer x) {
        return x % 2 == 0;
      }
    };
    assertThat(filter(isEven, numbers), empty());
  }

  @Test
  public void filterNonEmptyListReturnsElementsMatchingPredicate() {
    Integer[] numbers = new Integer[] { 1, 2, 3, 4 };
    Predicate<Integer> isEven = new Predicate<Integer>() {
      public Boolean apply(Integer x) {
        return x % 2 == 0;
      }
    };
    assertThat(filter(isEven, numbers), contains(2, 4));
  }

  @Test
  public void foldEmptyListReturnsInitialValue() {
    Integer[] numbers = new Integer[] {};
    // EXPLAIN: currying
    BiFunction<Integer, Integer, Integer> sum = new BiFunction<Integer, Integer, Integer>() {
      public Integer apply(Integer x, Integer y) {
        return x + y;
      }
    };
    assertThat(fold(sum, numbers, 0), equalTo(0));
  }

  @Test
  public void foldNonEmptyListReducesList() {
    Integer[] numbers = new Integer[] { 1, 2, 3, 4 };
    BiFunction<Integer, Integer, Integer> sum = new BiFunction<Integer, Integer, Integer>() {
      // EXPLAIN: why final is required
      // Too verbose... Explain currying?
      public Integer apply(Integer x, Integer y) {
        return x + y;
      }
    };
    assertThat(fold(sum, numbers, 0), equalTo(10));
  }

  @Test
  public void mapEmptyListReturnsEmptyList() {
    Integer[] numbers = new Integer[] {};
    Function<Integer, Integer> addOne = new Function<Integer, Integer>() {
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
    Function<Integer, Integer> addOne = new Function<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    };
    // EXPLAIN: passing a function as an argument
    assertThat(map(addOne, numbers), contains(2, 3, 4, 5));
  }
}
