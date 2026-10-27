package it.unibo.collections;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/**
 * Example class using {@link List} and {@link Map}.
 *
 */

public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    
     
    public static void main() {
        final int ELEMS = 100_000;
        final int TIMES = 1000;
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
         List<Integer> lista = new ArrayList<>();

         for(int i = 1000; i <2000;i++){
            Integer e=i;
            lista.add(e);
         }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> list = new LinkedList<>();
        list.addAll(0,lista);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp;
        temp=lista.get(0);
        int size= lista.size()-1;
        lista.set(0,lista.get(size));
        lista.set(size,temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer i : lista){
            IO.println(i.intValue());
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeLista = System.nanoTime();
         for(int i = 0; i < ELEMS;i++){
            Integer e=i;
            lista.add(0,e);
         }
        timeLista= System.nanoTime()-timeLista;
        final var millis = TimeUnit.NANOSECONDS.toMillis(timeLista);
        IO.println(
            "Converting "
                + lista.size()
                + " ints to String and inserting them in a Set took "
                + timeLista
                + "ns ("
                + millis
                + "ms)"
        );    

         long timeLista2 = System.nanoTime();
         for(int i = 0; i < ELEMS;i++){
            Integer e=i;
            list.add(0,e);
         }
        timeLista2= System.nanoTime()-timeLista2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(timeLista2);
        IO.println(
            "Converting "
                + list.size()
                + " ints to String and inserting them in a Set took "
                + timeLista2
                + "ns ("
                + millis2
                + "ms)"
        ); 
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        timeLista = System.nanoTime();

        int index= lista.size()/2;
        for(int i = 0; i < TIMES; i++){
            Integer elem = lista.get(index);
        }
        timeLista= System.nanoTime()-timeLista;

        final var millis3 = TimeUnit.NANOSECONDS.toMillis(timeLista);
        IO.println(
            "Converting "
                + lista.size()
                + " ints to String and inserting them in a Set took "
                + timeLista
                + "ns ("
                + millis3
                + "ms)"
        );    

        timeLista = System.nanoTime();

        int index2= list.size()/2;
        for(int i = 0; i < TIMES; i++){
            Integer elem = list.get(index2);
        }
        
        timeLista= System.nanoTime()-timeLista;

        final var millis4 = TimeUnit.NANOSECONDS.toMillis(timeLista);
        IO.println(
            "Converting "
                + list.size()
                + " ints to String and inserting them in a Set took "
                + timeLista
                + "ns ("
                + millis4
                + "ms)"
        ); 
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, BigInteger> map = new HashMap<>();
        map.put("Africa",BigInteger.valueOf(1110635000));
        map.put("Americas",BigInteger.valueOf(972005000));
        map.put("Antartica",BigInteger.valueOf(0));
        map.put("Asia",BigInteger.valueOf(4298723000L));
        map.put("Europe",BigInteger.valueOf(743452000));
        map.put("Oceania",BigInteger.valueOf(38304000));
        /*
         * 8) Compute the population of the world
         */
        BigInteger population= BigInteger.ZERO;
        for(final String s : map.keySet()){
            population = population.add(map.get(s));
        }
        IO.println("the world population is "+population);
    }
}
