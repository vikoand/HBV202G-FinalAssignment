# HBV202G-FinalAssignment


The implementation is in the Java pacakage 'hi.verkefni.vidmot' and 'vinnsla' and the test is in Java package `test`, in the usual separate Maven `src` directories:

- `src/main/java`:
  - `is.hi.hbv202g.ass9.composite`: Your implementation of the composite pattern has to go there. Choose class, interface, and method names so that they fit the provided test cases.
  - `is.hi.hbv202g.ass9.compositeLeafObservedByComposite`: Your implementation of the composite pattern that is combined with the observable patterns has to go there. Choose class, interface, and method names so that they fit the provided test cases.
  - `is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod`: Your refactoring of the above patterns inspired by the template method pattern.
  -
- `src/test/java`: (each package contains an `Alltests` class that collects all the test cases for the respective package in one test suite)
  - `is.hi.hbv202g.ass9.composite`: Test cases testing a composite implementation.
  - `is.hi.hbv202g.ass9.compositeLeafObservedByComposite`: Test cases testing an implementation of a composite where the leafs are observed by the composite implementation.
  - `is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod`: The same test cases for testing the refactoring of the above patterns inspired by the template method pattern.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency.

## Maven:

- 'mvn compile' compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).
- `mvn exec:java` runs main method in TakeAwayApplication class.


## UML Diagram

The Diagram for this project can be found [here](src/site/markdown/UmlDiagram.MD)

## Design patterns

This project uses the observer pattern. We used ObservableList for the cart and the courses on the menu. The pattern is necessary in this program because when something is added or removed from the cart
the price has to update accordingly.

## End user documentation

### How to run jar file
Instructions on how to run the jar file can be found [here](runjar.cmd).


## License:

The license can be found [here](LICENSE.md).
