package ru.vsu.cs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static double readVar(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);
        return scanner.nextDouble();
    }

    private static void printResult(String phrase, double resultOfSum) {
        System.out.printf("The sum %s: %f\n", phrase, resultOfSum);
    }

    private static double pow(double base, int index) {
        double result = 1;
        for (int i = 0; i < index; i++) {
            result *= base;
        }
        return result;
    }

    private static double abs(double x) {
        return x < 0 ? - x : x;
    }

    private static double getNMemberOfSequence(double x, int n) {
        double numerator = pow(-1, n-1) * pow(x, 2 * n - 1);
        double denominator = 2 * n - 1;
        return numerator / denominator;
    }

    private static double calculateSumOfSequence(double x, double numberOfMembers) {
        double sum = 0;
        for (int i = 1; i <= numberOfMembers; i++) {
            sum += getNMemberOfSequence(x, i);
        }
        return sum;
    }

    private static double calculateSumOfSequenceWithEpsilon(double x, double numberOfMembers, double epsilon) {
        double sum = 0;
        for (int i = 1; i <= numberOfMembers; i++) {
            double nMemberOfSequence = getNMemberOfSequence(x, i);
            if (abs(nMemberOfSequence) > epsilon) {
                sum += getNMemberOfSequence(x, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readVar("x");
        double numberOfMembers = readVar("numberOfMembers");
        double epsilon = readVar("epsilon");

        double sumOfSequence = calculateSumOfSequence(x, numberOfMembers);
        printResult("of N terms", sumOfSequence);

        double sumOfSequenceWithEpsilon = calculateSumOfSequenceWithEpsilon(x, numberOfMembers, epsilon);
        printResult("of N terms of which the absolute value of more than epsilon", sumOfSequenceWithEpsilon);

        double sumOfSequenceWithEpsilonDividedBy10 = calculateSumOfSequenceWithEpsilon(x, numberOfMembers, epsilon / 10);
        printResult("of N terms of which the absolute value of more than epsilon divided by 10",
                sumOfSequenceWithEpsilonDividedBy10);

        double sumOfSequenceWithMath = Math.atan(x);
        printResult("using Math", sumOfSequenceWithMath);
    }
}