package org.example.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringOps {

    public static void reversedString() {
        String input = "Java articles are awesome";
        int length = input.length();
        String reversed = Stream.iterate(length-1,i-> i>=0, i-> i-1)
                .map(input::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(" after reversal the "+input+" would be "+reversed);

    }

    public static void palindrome() {
        String input = "abcba";
        int size = input.length();
        StringBuilder reversed = IntStream.range(0,size)
                .mapToObj(i->input.charAt(size-1-i))
                .collect(StringBuilder::new, StringBuilder::append,StringBuilder::append);
        if(reversed.toString().equals(input))
            System.out.println(input+" is palindrome");
        else
            System.out.println(input+ " is not a palindrome");
        StringBuilder rev = IntStream.range(0,size)
                .mapToObj(input::charAt)
                .collect(StringBuilder::new, StringBuilder::append,StringBuilder::append).reverse();

        System.out.println(input+" is a palindrome"+rev.toString().equals(input));
    }

    public static void firstNonRepeatingCharacter(){
        String input = "Java articles are awesome";
        char nonRepeatedCharacter = input.chars()
                .mapToObj(str -> Character.toLowerCase((char) str))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("First Non repeating character "+nonRepeatedCharacter);

    }

    public static void reversedWords(){
        String input = "Java articles are awesome";
        System.out.println(input+ " after reversing ");
        String[] inputArray = input.split(" ");
        Stream.iterate(inputArray.length-1,i-> i>=0, i->i-1)
                .map(i-> inputArray[i])
                .forEach(str-> System.out.print(str+ " "));
        System.out.println(" ");
    }

    public static void concatenateTwoStreams(){
        List<String> list1 =Arrays.asList("Java", "8");//mutable list
        List<String> list2 = List.of("explained", "through","programs");//immutable list
        System.out.println("list after Concatenation");
                Stream.concat(list1.stream(),list2.stream())
                .forEach(str -> System.out.print(str+ " "));
        System.out.println(" ");
    }

    public static void convertStringToUppercase(){
        List<String> names = List.of("aa","bB","cC","DD");
        System.out.println("List after converting into uppercase");
        names.stream()
                .map(String::toUpperCase)
                .forEach(name-> System.out.print(name+" "));
        System.out.println(" ");
    }

    public static void countElementFromAStringList() {
        List<String> names = Arrays.asList("AA","BB","AA","DD","CC","CC");
        Map<String,Long> namesCount=names.stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        System.out.println(namesCount);
    }

    public static void duplicateStringWithCount(){
        List<String> names = Arrays.asList("AA","BB","AA","DD","CC","CC");
        Map<String,Long> duplicateNamesCount=names.stream()
                .filter(str-> Collections.frequency(names,str)>1)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        System.out.println("Duplicate name with it's count "+duplicateNamesCount);
    }

    public static void countEachCharacterInAString(){
        String input = "Java articles are awesome";
        Map<String,Long> nameCount = Arrays.stream(input.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(nameCount);
    }

    public static void main(String[] args){
        palindrome();
        reversedString();
        firstNonRepeatingCharacter();
        reversedWords();
        concatenateTwoStreams();
        convertStringToUppercase();
        countElementFromAStringList();
        duplicateStringWithCount();
        countEachCharacterInAString();
    }
}
