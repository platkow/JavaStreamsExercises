package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercises {

    public StreamExercises() {
    }

    //Ex. 1
    public void countAverage() {
        int j = 10;
        int sum = 0;

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(j);
            sum += j;
            j = j + 10;
        }

        int size = integers.size();

        Double average = integers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Sum is: " + sum + "\n" + "Integers count is: " + size + "\n" + "Average is: " + average);
    }

    //Ex. 2
    public void convertStringToUpperLowerCase() {
        List<String> names = Arrays.asList("Joey", "Rachel", "Ross", "Monica", "Phoebe", "Chandler", "Ana", "Daniel", "Irma");
        System.out.println("Original list of names: " + String.join(", ", names));

        List<String> upperCaseNames = names.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        System.out.println("\nUpper Case names: " + String.join(", ", upperCaseNames));

        List<String> lowerCaseNames = names.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Lower Case names: " + String.join(", ", lowerCaseNames));
    }

    //Ex. 3
    public void sumAllEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.print("Original list of numbers: " + numbers);

        Double sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .sum();

        System.out.println("\nEven numbers sum is: " + sum);
    }

    public void sumAllOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        Double sum = numbers.stream()
                .filter(e -> e % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .sum();

        System.out.println("Odd numbers sum is: " + sum);
    }

    //Ex. 4
    public void removeDuplicatedElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 6, 6);

        System.out.println("List of numbers before removing duplicates: " + numbers);

        List<Integer> uniqueNumbers = numbers.stream()
                .mapToInt(v->v)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("List of numbers after removing duplicates: " + String.join(", ", String.valueOf(uniqueNumbers)));
    }

    //Ex. 5
    public void countStringStartsWithP() {
        List<String> nouns = Arrays.asList("pig", "knife", "Fork", "pork", "Soup", "Potato", "Police", "pigeon", "Bowl", "Bull");
        System.out.println("Original list of nouns: " + nouns);

        int count = (int) nouns.stream()
                .map(String::toLowerCase)
                .filter(e -> e.startsWith("p"))
                .count();
        System.out.println("Nouns count starting with 'P' is: " + count);
    }

    //Ex. 6
    public void sortCountries(String order) { //available order: asc or desc
        List<String> countries = Arrays.asList("USA", "India", "Germany", "Poland", "Romania", "Australia", "Canada", "China", "Ghana");
        System.out.println("Original list of countries: " + String.join(", ", countries));

        switch (order) {
            case "asc":
                System.out.println("\nSorting countries in ascending order: ");
                countries.stream()
                        .sorted()
                        .forEach(System.out::println);
                break;
            case "desc":
                System.out.println("\nSorting countries in descending order: ");
                countries.stream().sorted((o1, o2) -> o2.compareTo(o1))
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Order not selected.");
        }
    }

    //Ex. 7
    public void findMinMaxValue(String value) {
        List<Integer> numbers = Arrays.asList(-1, 2, -18, 20, 58);
        System.out.println("Original list of numbers: " + numbers);

        if (value == "min") {
            int minNumber = numbers.stream()
                    .mapToInt(v -> v)
                    .min()
                    .orElseThrow(NoSuchElementException::new);

            System.out.println("Min value is: " + minNumber);
        } else if (value == "max") {
            int maxNumber = numbers.stream()
                    .mapToInt(v -> v)
                    .max()
                    .orElseThrow(NoSuchElementException::new);

            System.out.println("Max value is: " + maxNumber);
        }
    }

    //Ex. 8
    public void findSecondSmallestLargestValue(String value) { //available options small or large
        List<Integer> numbers = Arrays.asList(-1, 2, -18, -7, -3, 20, 58, 44, 82);
        System.out.println("Original list of numbers: " + numbers);

        if (value == "small") {
            List<Integer> sortedNumbers = numbers.stream()
                    .mapToInt(v -> v)
                    .filter(e -> e < 0)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());

            int secondSmallestValue = sortedNumbers.get(1);
            System.out.println("Second smallest value is: " + secondSmallestValue);
        } else if (value == "large") {
            List<Integer> sortedNumbers =
                    numbers.stream()
                            .mapToInt(v -> v)
                            .filter(e -> e > 0)
                            .boxed()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList());

            int secondLargestValue = sortedNumbers.get(1);
            System.out.println("Second largest value is: " + secondLargestValue);
        } else {
            System.out.println("Value not selected");
        }
    }
}
