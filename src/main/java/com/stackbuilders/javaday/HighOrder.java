package com.stackbuilders.javaday;

import java.util.ArrayList;
import java.util.List;

// Concepts to explain:
// - First class citizens
// - High order functions
public class HighOrder {
  public static <A> List<A> filter(F<A, Boolean> f, A[] xs) {
    List<A> ys = new ArrayList<A>();
    for (A x : xs) {
      if (f.apply(x)) {
        ys.add(x);
      }
    }
    return ys;
  }

  // Too verbose... Explain currying?
  // Explain why final is required
  public static <A, B> B fold(F<A, F<B, B>> f, A[] xs, B initialValue) {
    B acc = initialValue;
    for (A x : xs) {
      acc = f.apply(x).apply(acc);
    }
    return acc;
  }

  // Explain <A, B>
  // explain high order function
  public static <A, B> List<B> map(F<A, B> f, A[] xs) {
    List<B> ys = new ArrayList<B>();
    for (A x : xs) {
      ys.add(f.apply(x));
    }
    return ys;
  }
}
