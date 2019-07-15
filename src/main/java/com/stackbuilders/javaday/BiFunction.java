package com.stackbuilders.javaday;

public abstract class BiFunction<A, B, C> implements F<A, F<B, C>> {
  public F<B, C> apply(final A x) {
    return new F<B, C>() {
      public C apply(B y) {
        return apply2(x, y);
      }
    };
  }

  public abstract C apply2(A x, B y);
}
