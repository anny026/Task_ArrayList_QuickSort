package aston.java66.anna;

import java.util.Comparator;

public class QuickSort  {


    /**
     * The method performs a quick sort algorithm using a Comparable and accepting an MyArrayList
     */
    public static <N extends Comparable<N>> void quickSortWithComparable(MyArrayList<N> arr) {
        sortWithComparable(arr, 0, arr.size() - 1);
    }


    /**
     * The method performs a quick sort algorithm using a Comparator and accepting an MyArrayList
     */
    public static <N> void quickSortWithComparator(MyArrayList<N> arr, Comparator <N> comparator) {
        sortWithComparator(arr, 0, arr.size() - 1, comparator);

    }
    private static <N extends Comparable<N>> void sortWithComparable(MyArrayList<N> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionWithComparable(arr, low, high);
            sortWithComparable(arr, low, partitionIndex - 1);
            sortWithComparable(arr, partitionIndex + 1, high);
        }
    }
    private static <N> void sortWithComparator(MyArrayList<N> arr, int low, int high, Comparator <N> comparator) {
        if (low < high) {
            int partitionIndex = partitionWithComparator(arr, low, high, comparator);
            sortWithComparator(arr, low, partitionIndex - 1,  comparator);
            sortWithComparator(arr, partitionIndex + 1, high,  comparator);
        }
    }

    private static <N extends Comparable<N>> int partitionWithComparable(MyArrayList<N> arr, int low, int high) {
        N pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;
                N temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        N temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    private static <N> int partitionWithComparator(MyArrayList<N> arr, int low, int high, Comparator <N> comparator) {
        N pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr.get(j),pivot) < 0) {
                i++;
                N temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        N temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

}
