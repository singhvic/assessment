package com.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String input) {
        int sum = 0;

        if(input.isBlank() == false) {
            Matcher matcher = getPatternMatcherForNonNegativeNums(input);
            List<Integer> numbers = getNumbers(matcher);
            ensureNonNegatives(numbers);
            sum= numbers.stream().reduce(0, Integer::sum);
        }
        return  sum;
    }

    private static void ensureNonNegatives(List<Integer> numbers) {
        List<Integer> negativeNumbers = numbers.stream().filter(num -> num < 0).collect(Collectors.toList());
        if(negativeNumbers.isEmpty() == false) {
            throw new RuntimeException(String.format("negative numbers not allowed %s", negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(","))));
        }
    }

    private static List<Integer> getNumbers(Matcher matcher) {
        List<Integer> numbers = new ArrayList<>();
        while(matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    private static Matcher getPatternMatcherForNonNegativeNums(String input) {
        Pattern findDigits = Pattern.compile("-?\\d+");
        return findDigits.matcher(input);
    }
}
