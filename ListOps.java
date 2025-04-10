package org.example.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOps {

    public static void evenNumberList(List<Integer> numList){
        System.out.println("Even number List");
        numList.stream().filter(n-> n%2==0).forEach(System.out::println);
    }

    public static void numStartingWith_1(List<Integer> numList){
        System.out.println("Number starting with 1");
        numList.stream().map(num-> num+"").filter(num->num.startsWith("1")).forEach(System.out::println);
    }

    public static void numStartingWith_1Method_2(List<Integer> numList){
        System.out.println("Number starting with 1");
        List<Integer> numStartsWith1=numList.stream().filter(num->String.valueOf(num).startsWith("1")).toList();
        System.out.println(numStartsWith1);
    }

    public static void findDuplicate(){
        System.out.println("duplicates elements in the list");
        List<Integer> numList = Arrays.asList(10,4,3,6,78,55,34,35,99,15,91,91,3,4);
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> duplicates=numList.stream().filter(num -> !numSet.add(num)).collect(Collectors.toSet());
        System.out.println(duplicates);
    }

    public static void uniqueElements(){
        System.out.println("Unique elements");
        List<Integer> numList = Arrays.asList(10,4,3,6,78,55,34,35,99,15,91,91,3,4);
        System.out.println(numList.stream().distinct().toList());
        System.out.println("Unique elements using set ");
        System.out.println(new HashSet<>(numList));
    }

    public static void findFirstElement(List<Integer> numList){
        System.out.println("first element in the list");
        numList.stream().findFirst().ifPresent(System.out::println);
    }

    public static void totalElementInAList(List<Integer> numList){
        System.out.println("total elements in the list");
        System.out.println(numList.stream().count());
        System.out.println("total elements in the list using Collectors method "+numList.size());
    }
    public static void maxValueInAList(List<Integer> numList){
        System.out.println("max element in the list");
        numList.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }

    public static void sortElementsInAList(List<Integer> numList){
        List<Integer> sortedList = numList.stream().sorted().toList();
        System.out.println("Sorted List "+sortedList);
    }

    public static void sortElementsInDesc(List<Integer> numList){
        List<Integer> descSortedList = numList.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println("desc List "+descSortedList);
    }

    public static void iterateElementsInReverseOrder(List<Integer> numList) {
        System.out.println("Actual List "+numList);
        int length = numList.size();
        List<Integer> reversedList = Stream.iterate(length-1, i-> i>=0, i->i-1)
                .map(numList::get)
                .toList();
        System.out.println("reversed List "+reversedList);
    }

    public static void containDuplicates() {
        int[] arr = {21,34,22,45,67,22,78,45,56};
        List<Integer> numList = Arrays.stream(arr).boxed().toList();
        Set<Integer> numSet = new HashSet<>(numList);
        if(numSet.size()==numList.size())
            System.out.println("array does not contains duplicates");
        else
            System.out.println("array contains duplicate elements");
    }

    public static void cubicNum(List<Integer> numList){
        System.out.println("cube of the elements");
        numList.stream().map(num-> num*num*num)
                .filter(num -> num>50)
                .forEach(num-> System.out.print(num+" "));
        System.out.println("");
    }

    public static void sortAnArray(){
        int[] arr = {21,34,22,45,67,22,78,45,56};
        System.out.println("Sorted Array");
//        Arrays.sort(arr);
        Arrays.stream(arr).sorted().forEach(num-> System.out.print(num+" "));
        System.out.println("");
    }

    public static void maxElementInAnArray(){
        int[] arr = {21,34,22,45,67,22,78,45,56};
        System.out.print("max element in an array ");
        Arrays.stream(arr).max().ifPresent(System.out::println);
    }

        public static  void findFirstAndLast(List<Integer> numbers) {
        System.out.println("First and last:");
        System.out.println("First: "+ numbers.getFirst());
        numbers.stream().findFirst().ifPresent(System.out::println);
        System.out.println("Last: "+ numbers.getLast());
        numbers.stream().reduce((first, last) -> last).ifPresent(System.out::println);
    }

        public static void findMaxAndMin(List<Integer> numbers) {
        System.out.println("Max :");
        numbers.stream().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println("Min :");
        numbers.stream().min(Integer::compareTo).ifPresent(System.out::println);
        List<String> strList = Arrays.asList("a", "b", "c");
        System.out.println("Max and Min of String list");
        strList.stream().max(String::compareTo).ifPresent(System.out::println);
        strList.stream().min(String::compareTo).ifPresent(System.out::println);
    }

        public static  void findSecondLargest(List<Integer> numbers) {
        System.out.println("Second largest number: ");
        numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
        System.out.println("Third largest number using stream: ");
        numbers.stream().sorted(Collections.reverseOrder()).skip(2).findFirst().ifPresent(System.out::println);
    }

    public static void findSecondSmallestNumber(List<Integer> numbers) {
        System.out.println("Second smallest number: ");
       numbers.stream().sorted().skip(1).findFirst().ifPresent(System.out::println);
       System.out.println("Third smallest number using stream: ");
       numbers.stream().sorted().skip(2).findFirst().ifPresent(System.out::println);
    }

      public static  void findMaxAndMinElementInAnArray() {
        int[] arr = {1,2,3,4,5,6,7,7,9,10,11,12,13,13,15,16,17};
        System.out.println("Max element:");
        Arrays.stream(arr).boxed().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println("Min element:");
        Arrays.stream(arr).boxed().min(Integer::compareTo).ifPresent(System.out::println);
    }
        public static void sortElementsInALists(List<Integer> numbers) {
        System.out.println("Sorted List "+numbers.stream().sorted().toList());
        System.out.println("Sorted List in reverse order "+numbers.stream().sorted(Collections.reverseOrder()).toList());
        List<String> strList = Arrays.asList("a", "b", "c", "x", "d", "m", "j");
        System.out.println("sorting String list "+ strList.stream().sorted().toList());
        System.out.println("sorting String list in reverse order "+strList.stream().sorted(Collections.reverseOrder()).toList());

    }

    public static void main(String[] args){
        List<Integer> numList = Arrays.asList(10,4,3,6,78,55,34,35,99,15,91);
        evenNumberList(numList);
        numStartingWith_1(numList);
        numStartingWith_1Method_2(numList);
        findDuplicate();
        uniqueElements();
        findFirstElement(numList);
        totalElementInAList(numList);
        maxValueInAList(numList);
        sortElementsInAList(numList);
        sortElementsInDesc(numList);
        iterateElementsInReverseOrder(numList);
        containDuplicates();
        cubicNum(numList);
        sortAnArray();
        maxElementInAnArray();
        findFirstAndLast(numList);
        findMaxAndMin(numList);
        findSecondLargest(numList);
        findSecondSmallestNumber(numList);
        findMaxAndMinElementInAnArray(numList);
        sortElementsInALists(numList);
    }
}
