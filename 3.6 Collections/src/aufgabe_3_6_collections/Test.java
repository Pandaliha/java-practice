package aufgabe_3_6_collections;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.binarySearch;


public class Test {
    private static ArrayList<Long> time = new ArrayList<>();

    /**
     * amount Einträge hinten in die list anhängen, dies repetitions-mal.
     * @param collection
     * @param repetitions
     * @param amount
     */
    public static void insertEnd(Collection<Integer> collection, int repetitions, int amount) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            collection.clear();

            long start = System.currentTimeMillis();

            for (int j = 0; j <= amount; j++) {
                Collections.addAll(collection, j);
            }

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        
        System.out.println("\tDatenstruktur: " + collection.getClass());
        System.out.println("\tTest: Am Ende anhängen");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }




    /**
     * amount Einträge vorne in die list anhängen, dies repetitions-mal.
     * @param list
     * @param repetitions
     * @param amount
     */
    public static void insertBeginning(List<Integer> list, int repetitions, int amount) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            list.clear();

            long start = System.currentTimeMillis();

            for (int j = 0; j <= amount; j++) {
                list.add(j, 0);
            }

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        
        System.out.println("\tDatenstruktur: " + list.getClass());
        System.out.println("\tTest: Am Anfang anhängen");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }




    /**
     * Durchläuft die collection bis zum letzten Wert und wiederholt dies repetitions-mal.
     * @param collection
     * @param repetitions
     * @param value
     */
    public static void searchIterator(Collection<Integer> collection, int repetitions, int value) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();

            Iterator<Integer> iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == value) {
                    break;
                }
            }
            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }

        System.out.println("\tDatenstruktur: " + collection.getClass());
        System.out.println("\tTest: Iterator sucht letzten Wert");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }

    /**
     * Sucht den Wert an der Stelle value und wiederholt dies repetitions-mal.
     * @param list
     * @param repetitions
     * @param value
     */
    public static void searchBinary(List<Integer> list, int repetitions, int value) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();

            binarySearch(list, value);

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }

        System.out.println("\tDatenstruktur: " + list.getClass());
        System.out.println("\tTest: Letzten Wert mit Binärsuche finden");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }

    /**
     * Prüft ob die übergebene collection einen bestimmten Wert enthält und wiederholt dies repetitions-mal                           .
     * @param collection
     * @param repetitions
     * @param value
     */
    public static void search(Collection<Integer> collection, int repetitions, int value) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();
            collection.contains(value);
            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        System.out.println("\tDatenstruktur: " + collection.getClass());
        System.out.println("\tTest: Suche mit contains()");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }



    // #################### Iteratoren und Stream-Klassen ####################
    private static Random rand = new Random();

    /**
     *
     * @param liste
     * @param repetitions
     * @param length
     */
    public static void fillArrayListGENERATE(List<Integer> liste, int repetitions, int length) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            liste.clear();
            long start = System.currentTimeMillis();

            /* Start Test */
            Stream<Integer> str = Stream.generate(()->rand.nextInt(length)).limit(length);
            liste = str.collect(Collectors.toList());
            /* Ende Test */

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        System.out.println("\tDatenstruktur: " + liste.getClass());
        System.out.println("\tTest: Zuffalszahlen");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }

    /**
     *
     * @param liste
     * @param repetitions
     * @param length
     */
    public static void fillArrayListADD(ArrayList<Integer> liste, int repetitions, int length) {
        time.clear();
        liste.clear();

        for (int i = 0; i < repetitions; i++) {
            liste.clear();
            long start = System.currentTimeMillis();

            for (int j = 0; j <= length; j++) {
                liste.add(rand.nextInt(length));
            }

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        System.out.println("\tDatenstruktur: " + liste.getClass());
        System.out.println("\tTest: Zufallswerte addieren");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }


    public static void sumStream(ArrayList<Integer> liste, int repetitions) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();

            /* Start Test */
            int sum = liste.stream().filter(v -> v % 2 == 0).mapToInt(Integer::valueOf).sum();
            /* Ende Test */

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        System.out.println("\tDatenstruktur: " + liste.getClass());
        System.out.println("\tTest: sumStream");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }

    public static void sumStreamParallel(ArrayList<Integer> liste, int repetitions) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            long start = System.currentTimeMillis();

            /* Start Test */
            int sum = liste.parallelStream().filter(v -> v % 2 == 0).mapToInt(Integer::valueOf).sum();
            /* Ende Test */

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        System.out.println("\tDatenstruktur: " + liste.getClass());
        System.out.println("\tTest: sumStreamParallel");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }

    public static void sumIterator(ArrayList<Integer> liste, int repetitions) {
        time.clear();

        for (int i = 0; i < repetitions; i++) {
            int sum = 0;
            long start = System.currentTimeMillis();

            /* Start Test */
            for (Iterator<Integer> iterator = liste.iterator(); iterator.hasNext(); ) {
                Integer item = iterator.next();
                if (item % 2 == 0) {
                    sum += item;
                }
            }
            /* Ende Test */

            long end = System.currentTimeMillis();
            long duration = (end - start);
            time.add(duration);
        }
        
        System.out.println("\tDatenstruktur: " + liste.getClass());
        System.out.println("\tTest: sumIterator");
        System.out.println("\tMin.: " + getMinimum() + " | " + "Max.: " + getMaximum() + " | " + "Avg.: " + getAverage());
        System.out.println("\t***********************");
    }






    // #################### Methoden für die Zeitberechnung ####################
    private static long getMinimum() {
        long minimum = time.get(0);
        for (Long i : time) {
            if (i < minimum) {
                minimum = i;
            }
        }
        return minimum;
    }

    private static long getMaximum() {
        long maximum = time.get(0);
        for (Long i : time) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }

    private static double getAverage() {
        long summe = 0;
        for (Long i : time) {
            summe += i;
        }
        return (summe / (double) time.size());
    }
}