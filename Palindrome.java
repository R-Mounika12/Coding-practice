package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Palindrome {

    public static boolean checkPalindrome_1(String input){
        StringBuilder reverse = new StringBuilder();
        char[] inputArray = input.toCharArray();
        List<Character> charList = IntStream.range(0,input.length()).mapToObj(i->inputArray[i]).toList();
        charList.reversed();
        for(Character c :charList)
                reverse.append(c);
        if(reverse.toString().equals(input))
            return true;

        return false;
    }

    public static boolean checkPalindrome(String input){

        int size = input.length();
        List<Character> charList = IntStream.range(0,size).mapToObj(input::charAt).toList();
        String reversed = IntStream.range(0,size).mapToObj(i-> input.charAt(size-1-i)).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        String reverse = Stream.iterate(size-1, i->i>=0,i-> i-1)
                .map(charList::get)
                        .map(String::valueOf)
                                .collect(Collectors.joining());
        System.out.println("reversedstring "+reverse);
        if(reversed.equals(input))
            return true;
        return false;
    }

    public static void main(String[] args){
        String input = "abcbae";
        System.out.println(checkPalindrome(input));
        System.out.println(checkPalindrome_1(input));
    }
}
