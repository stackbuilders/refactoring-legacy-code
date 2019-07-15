package com.stackbuilders.javaday;
// How to fake functions as first class citizens
// Explain A (input) and B (output)
public interface Function<A, B> {
  B apply(A x);
}
