package org.example.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapOps {

    public static void convertListToMap(List<User> users){
        //Collectors.toMap(keyMapper, ValueMapper)
        Map<Long, String> userMap = users.stream()
                .collect(Collectors.toMap(User::getId,User::getName));
        System.out.println("Map conversion of List");
        System.out.println(userMap);
    }

    public static void convertListToMapObject(List<User> users){
        Map<Long,User> userMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));//Function.identity() collects the object itself
        System.out.println("Map conversion of user object");
        System.out.println(userMap);
    }

    public static void mergeFunction(List<User> users) {
        //Collectors.toMap(keyMapper, ValueMapper, mergeFunction)
        // merge function lets you specify which value to consider when duplicate key issue occurs
        Map<String, Integer> userMap = users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge, (oldValue, newValue)-> oldValue));
        System.out.println("merge function output");
        System.out.println(userMap);
    }

    public static void concurrentHashMap(List<User> users){
        //Collectors.toMap(keyMapper, ValueMapper, mergeFunction, MapFactory)
        Map<String, Integer> userMap = users.stream()
                .collect((Collectors.toMap(User::getName, User::getAge,(oldValue, newValue)->oldValue, ConcurrentHashMap::new)));
        System.out.println("Concurrent HaspMap");
        System.out.println(userMap);
    }

    public static void hashMap(List<User> users){
        Map<String, Integer> userMap = users.stream()
                .collect((Collectors.toMap(User::getName, User::getAge,(oldValue, newValue)->oldValue, HashMap::new)));
        System.out.println(" HaspMap");
        System.out.println(userMap);
    }

    public static void treeMap(List<User> users){
        Map<String, Integer> userMap = users.stream()
                .collect((Collectors.toMap(User::getName, User::getAge,(oldValue, newValue)->oldValue, TreeMap::new)));
        System.out.println(" TreeMap");
        System.out.println(userMap);
    }

    public static void groupingByUsage(List<User> users) {
        //Collectors.groupingBy(keyMapper, ValueMapper)
        //specifying valueMapping function is optional and returns  a list by default
        Map<String,List<User>> userMap = users.stream()
                .collect(Collectors.groupingBy(User::getName));
        System.out.println("Map conversion using groupingBy");
        System.out.println(userMap);

    }

    public static void countUsersByName(List<User> users) {
        Map<String, Long> userMap = users.stream()
                .collect(Collectors.groupingBy(User::getName,Collectors.counting()));
        System.out.println("Users count ");
        System.out.println(userMap);
    }

    public static void summingAgeByName(List<User> users) {
        Map<String, Integer> sumAgeByName = users.stream()
                .collect(Collectors.groupingBy(User::getName,Collectors.summingInt(User::getAge)));
        System.out.println("Sum age By name");
        System.out.println(sumAgeByName);
    }

    public static void iterateKeys(List<User> users) {
        System.out.println("Map keys iteration");
        users.stream()
                .collect(Collectors.toMap(User::getId, User::getName))
                .keySet()
                .stream()
                .forEach(key-> System.out.print(key+" "));
        System.out.println("");
    }

    public static void iterateValues(List<User> users) {
        System.out.println("Map values iteration");
        users.stream()
                .collect(Collectors.toMap(User::getId, User::getName))
                .values()
                .stream()
                .forEach(name-> System.out.print(name+" "));
        System.out.println("");
    }

    public static void iterateEntries(List<User> users) {
        System.out.println("Map entries iteration");
        users.stream()
                .collect(Collectors.toMap(User::getId, User::toString))
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }

    public static void sortByKey(List<User> users){
        System.out.println("Sort map by key");
        users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge,(o1, o2)->o1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    public static void sortByKeyDesc(List<User> users) {
        Map<String, Integer> sortByKeyReverseOrder = users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge,(o1,o2)->o1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
        System.out.println(sortByKeyReverseOrder);
    }

    public static void sortByValue(List<User> users) {
        System.out.println("sort Map by value");
        users.stream()
                .collect(Collectors.toMap(User::getName,User::getAge, (o1,o2)->o1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    public static void sortByValueDesc(List<User> users) {
        System.out.println("Sort Map by value DESC");
        Map<String,Integer> sortByValueDesc = users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge,(o1,o2)->o1))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
        System.out.println(sortByValueDesc);
    }

    public static void sortByBothKeyAndValue(List<User> users) {
        //Sort the map by value in alphabetical order
        //and then sort by key in descending order and collect to LinkedhashMap
        System.out.println("Sort the Map by both key and value");
        Comparator<Map.Entry<Long,String>> valueComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<Long,String>> keyComparator = Map.Entry.comparingByKey(Collections.reverseOrder());
        Map<Long,String> sortByValueThenKey = users.stream()
                .collect(Collectors.toMap(User::getId,User::getName))
                .entrySet()
                .stream()
                .sorted(valueComparator.thenComparing(keyComparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
        System.out.println(sortByValueThenKey);
    }


    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Andrew",56));
        userList.add(new User(2L, "Charlie",32));
        userList.add(new User(3L, "Peter",44));
        userList.add(new User(4L, "Andrew",13));
        userList.add(new User(5L, "Samuel",67));
        userList.add(new User(6L, "David",43));
        userList.add(new User(7L, "David",54));

        convertListToMap(userList);
        convertListToMapObject(userList);
        mergeFunction(userList);
        concurrentHashMap(userList);
        hashMap(userList);
        treeMap(userList);
        groupingByUsage(userList);
        countUsersByName(userList);
        summingAgeByName(userList);
        iterateKeys(userList);
        iterateValues(userList);
        iterateEntries(userList);
        sortByKey(userList);
        sortByKeyDesc(userList);
        sortByValue(userList);
        sortByValueDesc(userList);
        sortByBothKeyAndValue(userList);
    }
}
