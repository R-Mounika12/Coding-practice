package org.example.collection;

import java.util.*;

public class VectorExample {

    public static int findMaxMethod_1(Vector<Integer> v){
        Optional<Integer> max = v.stream().max(Integer::compareTo);
        return max.orElse(0);
    }

    public static int findMaxMethod_2(Vector<Integer> v){
        int max = Collections.max(v);
        return max;
    }

    public static int findMaxMethod_3(Vector<Integer> v){
        int max = v.getFirst();
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()){
            if(it.next()>max)
                max = it.next();
        }
        return max;
    }

    public static void main(String[] args){

        Vector<Integer> v = new Vector<>(Arrays.asList(10,45,2,56,32,44,9,34));

        System.out.println("method 1 maxValue "+findMaxMethod_1(v));
        System.out.println("method 2 maxValue "+findMaxMethod_2(v));
        System.out.println("method 2 maxValue "+findMaxMethod_3(v));
    }
}
