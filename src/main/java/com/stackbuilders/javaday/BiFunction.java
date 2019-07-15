package com.stackbuilders.javaday;

public abstract class BiFunction<A, B, C> implements Function<A, Function<B, C>> {
  public Function<B, C> apply(final A x) {
    return new Function<B, C>() {
      public C apply(B y) {
        return BiFunction.this.apply(x, y);
      }
    };
  }

  public abstract C apply(A x, B y);
}
