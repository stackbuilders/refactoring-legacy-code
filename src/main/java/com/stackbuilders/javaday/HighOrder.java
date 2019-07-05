import java.util.ArrayList;
import java.util.List;

// Concepts to explain:
// - First class citizens
// - High order functions
public class HighOrder {
  // How to fake functions as first class citizens
  // Explain A (input) and B (output)
  interface F<A, B> {
    B apply(A x);
  }

  // Explain <A, B>
  // explain high order function
  public <A, B> List<B> map(F<A, B> f, A[] xs) {
    List<B> ys = new ArrayList<B>();
    for (A x : xs) {
      ys.add(f.apply(x));
    }
    return ys;
  }

  public <A> List<A> filter(F<A, Boolean> f, A[] xs) {
    List<A> ys = new ArrayList<A>();
    for (A x : xs) {
      if (f.apply(x)) {
        ys.add(x);
      }
    }
    return ys;
  }

  // Java 1.6
  public void highOrder() {
    Integer[] numbers =  new Integer[] { 1, 2, 3, 4, 5, 6 };
    // Functions that take other functions as parameters
    map(new F<Integer, Integer>() {
      public Integer apply(Integer number) {
        return number + 2;
      }
    }, numbers);

    // Assign a function to a variable
    F<Integer, Integer> addOne = new F<Integer, Integer>() {
      public Integer apply(Integer number) {
        return number + 1;
      }
    };
    map(addOne, numbers);
  }
}
