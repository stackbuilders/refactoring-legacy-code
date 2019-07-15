package com.stackbuilders.javaday;

public class Optional<A> {
  private final A value;

  public Optional(A value) {
    this.value = value;
  }

  public <B> Optional<B> fmap(Function<A, B> f) {
    if (value == null) {
      return new Optional<B>(null);
    }
    return new Optional<B>(f.apply(value));
  }

  public A value() {
    return value;
  }

  public A value(A defaultValue) {
    return value == null ? defaultValue : value;
  }
}
