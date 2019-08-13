[![Build Status](https://travis-ci.org/stackbuilders/refactoring-legacy-code.svg?branch=master)](https://travis-ci.org/stackbuilders/refactoring-legacy-code)

# Refactoring legacy code using functional programming

Code snippets used during [JavaDay][javaday] presentation.

## Requirements

- [JDK 8][jdk-8]
- [Maven][maven]

## Getting Started

Clone the repository:

```
git clone https://github.com/stackbuilders/refactoring-legacy-code-using-functional-programming.git
```

Compile the source code:

```
mvn compile
```

Run the tests:

```
mvn test
```

## Benchmark

Compile the source code:

```
mvn compile -Pjdk8
```

Run benchmark:

```
mvn exec:java -Pjdk8
```

## License

Licensed under [MIT](LICENSE).

[javaday]: https://www.javaday.ec
[jdk-8]: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[maven]: https://maven.apache.org/install.html
