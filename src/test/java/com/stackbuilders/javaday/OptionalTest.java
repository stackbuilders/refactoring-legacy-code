package com.stackbuilders.javaday;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class OptionalTest {
  @Test
  public void fmapAppliesFunctionWhenValueIsNotNull() {
    Optional<Integer> optionalX = new Optional<Integer>(1);
    Integer y = optionalX.fmap(new Function<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    }).value();
    assertThat(y, equalTo(2));
  }

  @Test
  public void fmapDoesNothingWhenValueIsNull() {
    Optional<Integer> optionalX = new Optional<Integer>(null);
    Integer y = optionalX.fmap(new Function<Integer, Integer>() {
      public Integer apply(Integer x) {
        return x + 1;
      }
    }).value();
    assertThat(y, nullValue());
  }
}
