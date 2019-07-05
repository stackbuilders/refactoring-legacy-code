// Concepts to explain:
// - First class citizens
// - High order functions
public class Foo {
  // How to fake functions as first class citizens
  // Explain A (input) and B (output)
  interface F<A, B> {
    B apply(A arg);
  }

  // Explain <A, B>
  public <A, B> B[] map(F<A, B> f, A[] xs) {


    return null;
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
