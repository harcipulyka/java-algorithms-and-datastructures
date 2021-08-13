package Sort.QuickSort;

import Sort.SortInterface;

import java.util.Random;

//basic quick sort implementation, the pivot element is always the last one
public class QuickSort implements SortInterface {

    public void sort(int[] A) {
        quicksort(A, 0, A.length - 1);
    }

    public static void quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A,q + 1, r);
        }
    }

    //this is lomuto's partitioning algorithm, inferior to hoare's
    public static int partition(int[] A, int p, int r) {
        int x = A[r]; //pivot
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;

        return i + 1;
    }
}
