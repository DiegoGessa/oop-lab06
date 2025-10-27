package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for(int i=1000; i<2000; i++){
            myArrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> myLinkedList = new LinkedList<>(myArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp=myArrayList.get(myArrayList.size()-1); //contiene l'ultimo elemento 1999
        //1000.............1999
        myArrayList.set(myArrayList.size()-1, myArrayList.get(0)); //1000.....1000
        myArrayList.set(0, tmp); //1999.......1000
            /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for(int j : myArrayList){
            System.out.println(j);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        
        for(int i=0; i<=100_000; i++){
            myArrayList.add(i);
        }
    
        time = System.nanoTime() - time;

        long time2 = System.nanoTime();

        for(int i=0; i<=100_000; i++){
            myLinkedList.add(i);
        }

        time2 = System.nanoTime() - time2;

        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(// NOPMD
                " inserting 100_000 number in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        System.out.println(// NOPMD
                " inserting 100_000 number in a LinkedList took "
                + time2
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

        long timeread = System.nanoTime();
        
        for(int i=0; i<=1000; i++){
            myArrayList.get(myArrayList.size()/2);
        }
    
        timeread = System.nanoTime() - timeread;

        long timeread2 = System.nanoTime();

        for(int i=0; i<=1000; i++){
            myLinkedList.get(myLinkedList.size()/2);
        }

        timeread2 = System.nanoTime() - timeread2;

        final var millis3 = TimeUnit.NANOSECONDS.toMillis(timeread);
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(timeread2);
        System.out.println(// NOPMD
                " reading 1000 number in a ArrayList took "
                + timeread
                + "ns ("
                + millis3
                + "ms)"
        );
        System.out.println(// NOPMD
                " reading 1000 number in a LinkedList took "
                + timeread2
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

         final Map<String, Long> map = new HashMap<>();

         map.put("Africa", 1_110_635_000L);
         map.put("Americas", 972_005_000L);
         map.put("Antarctica", 0L);
         map.put("Asia", 4_298_723_000L);
         map.put("Europe", 742_452_000L);
         map.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */

         long population=0;
         for(long l : map.values()){
            population+=l;
         }
         System.out.println(population);
    }
}
