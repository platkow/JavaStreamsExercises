package org.example;

public class Main {
    public static void main(String[] args) {
        StreamExercises exercise = new StreamExercises();

        System.out.println("Exercise 1");
        exercise.countAverage();

        System.out.println("\nExercise 2");
        exercise.convertStringToUpperLowerCase();

        System.out.println("\nExercise 3");
        exercise.sumAllEvenNumbers();
        exercise.sumAllOddNumbers();

        System.out.println("\nExercise 4");
        exercise.removeDuplicatedElements();

        System.out.println("\nExercise 5");
        exercise.countStringStartsWithP();

        System.out.println("\nExercise 6");
        exercise.sortCountries("asc");
        exercise.sortCountries("desc");

        System.out.println("\nExercise 7");
        exercise.findMinMaxValue("min");
        exercise.findMinMaxValue("max");

        System.out.println("\nExercise 8");
        exercise.findSecondSmallestLargestValue("small");
        exercise.findSecondSmallestLargestValue("large");
    }
}