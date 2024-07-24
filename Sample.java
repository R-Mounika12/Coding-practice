package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args){

        /*
         *Calculate the age of the person in years given their birthday.
         */
        calculatePersonAgeInYears();

        /*
         * Get last element of an array using java8
         */
        getLastElementInAnArray();

        /*
         * convert char array into string using java 8
         */
        convertCharArrayIntoString();

        /*
         * print first 10 odd numbers using java 8
         */
        findFirstTenOddNumbers();

        /*
         * print last five ven numbers staring from 20 using java8
         */
        findLastFiveEvenNumbers();

        /*
         * find first non-repeating character in a string using java8
         */
        firstNonRepeatingCharacter();
    }

    public static void firstNonRepeatingCharacter() {
        String tempStr = "MounikaMouni";
        String[] stringArray = tempStr.split("");
        int fi = tempStr.indexOf("M");
        int la = tempStr.lastIndexOf("M");
        System.out.println(Arrays.stream(stringArray)
                .filter(str-> tempStr.indexOf(str)==tempStr.lastIndexOf(str))
                .findFirst()
                .orElse(""));
    }

    public static void findLastFiveEvenNumbers(){
        Stream.iterate(20,i-> i-2)
                .limit(5)
                .forEach(evenNum -> System.out.print(evenNum+" "));
    }

    public static void findFirstTenOddNumbers(){
        Stream.iterate(1, i->i+2)
                .limit(10)
                .forEach(oddNum-> System.out.print(oddNum+" "));
        System.out.println();
    }

    public static void convertCharArrayIntoString(){
        char[] charArray = {'a','b','c','d','e'};
        String charArrayToString = Arrays.toString(charArray);
        String string = IntStream.range(0,charArray.length)
                .mapToObj(c-> ""+c)
                .collect(Collectors.joining());
        List<String> stringList = IntStream.range(0, charArray.length)
                .mapToObj(c-> ""+c)
                .toList();
        System.out.println("char array to string "+ string);
        System.out.println("char array to string List"+ stringList);
    }


    public static void getLastElementInAnArray(){
        int[] intArray = {1,2,3,4,5};
        int[] intArr = {};
        int  lastElement = Arrays.stream(intArray)
                .boxed()
                .reduce((first,second)->second)
                .orElse(-1);
        System.out.println("last Element in an array "+lastElement);
    }

    private static void calculatePersonAgeInYears() {
        LocalDate birtDate = LocalDate.of(1998,4,12);
        LocalDate today = LocalDate.now();
        Period period = Period.between(birtDate, today);
        System.out.println("age "+period.getYears());

    }
}
