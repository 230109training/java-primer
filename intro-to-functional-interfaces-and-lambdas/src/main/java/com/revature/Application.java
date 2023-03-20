package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // Regular class implementing an interface
        MyClass obj1 = new MyClass();
        System.out.println(obj1.test("testing"));

        // Anonymous class
        MyFunctionalInterface obj2 = new MyFunctionalInterface() {
            @Override
            public boolean test(String s) {
                return s.length() > 10;
            }
        };

        System.out.println(obj2.test("testing"));

        // Lambda expressions
        MyFunctionalInterface obj3 = (String s) -> {
            return s.length() < 3;
        };

        System.out.println(obj3.test("hi"));

        // Demonstrating type inferencing (don't need (String s)) and we also don't need the return keyword, since there's just 1 single line
        // in the lambda expression
        MyFunctionalInterface obj4 = s -> s.length() < 5;


        // Functional interfaces are especially useful when using the Streams API
        // Java 8 introduced the streams API, which allows for us to do declarative processing of our data
        List<String> fruits = List.of("grapes", "grapefruits", "bananas", "apples", "peaches", "pears", "tomatoes");

        List<String> fruitsWithLengthLessThan7 = fruits.stream()
                .filter((s) -> s.length() < 7) // intermediate operations (chain): filter, map
                .collect(Collectors.toList()); // terminal operation: takes our stream modifications and turns it into something "tangible"

        System.out.println(fruitsWithLengthLessThan7);

        List<Integer> characterLengths = fruits.stream()
                .map((s) -> s.length())
                .collect(Collectors.toList());

        System.out.println(characterLengths);

        Predicate<String> myPredicate = (s) -> s.startsWith("g");
        Function<String, Integer> myFunction = s -> s.length();
        BinaryOperator<Integer> myBinaryOperator = (acc, element) -> acc + element;

        int totalLength = fruits.stream()
                .filter(myPredicate)
                .map(myFunction)
                .reduce(0, myBinaryOperator); // reduce is an example of a "terminal operation"

        System.out.println(totalLength);

        Consumer<String> myConsumer = (s) -> System.out.println(s);
        myConsumer.accept("testing123");

        Supplier<String> mySupplier = () -> "my string";
        System.out.println(mySupplier.get());
    }

}
