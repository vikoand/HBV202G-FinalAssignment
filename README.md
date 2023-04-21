# HBV202G-FinalAssignment

A project skeleton for the final project for the course HBV202G.

The implementation is in the Java package `hi.verkefni.vidmot` and `vinnsla` and the test is in Java package `test`, they are also in the usual separate Maven `src` directories:

- `src/main/java`:
  - `hi.verkefni.vidmot`: Implementation for the frontend of the project.
  - `vinnsla`: Implementation for the backend of the project.

- `src/test/java`:
- `greidslaTest`: Test cases testing payment implementation that is observed by the cart (karfa) and courses(veitingar) implementation.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency.

## Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).
- `mvn exec:java` runs main method in TakeAwayApplication class.


## UML Diagram:

The Diagram for this project can be found [here](src/site/markdown/UmlDiagram.MD/uml.png)

## Design patterns:

This project uses the observer pattern. The pattern is necessary in this program because when something is added or removed from the cart the price has to update accordingly so the user pays the right amount for their selected products.
We used ObservableList for the cart and the menu for this to work.

## End user documentation:

### How to run jar file
Instructions on how to run the jar file can be found [here](runjar.cmd).


## License:

The license can be found [here](LICENSE.md).
