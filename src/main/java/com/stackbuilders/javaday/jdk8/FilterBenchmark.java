package com.stackbuilders.javaday.jdk8;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntPredicate;
import org.openjdk.jmh.annotations.*;

public class FilterBenchmark {
  @State(Scope.Benchmark)
  public static class ExecutionPlan {
    public int[] numbers;

    @Setup(Level.Invocation)
    public void setup() {
      Random random = new Random();
      numbers = random.ints(10, 0, 100).toArray();
    }
  }

  @Benchmark
  public int[] anonymousClass(ExecutionPlan plan) {
    IntPredicate isEven = new IntPredicate() {
      public boolean test(int x) {
        return x % 2 == 0;
      }
    };
    return Arrays.stream(plan.numbers).filter(isEven).toArray();
  }

  @Benchmark
  public int[] lambdaExpression(ExecutionPlan plan) {
    IntPredicate isEven = x -> x % 2 == 0;
    return Arrays.stream(plan.numbers).filter(isEven).toArray();
  }
}
