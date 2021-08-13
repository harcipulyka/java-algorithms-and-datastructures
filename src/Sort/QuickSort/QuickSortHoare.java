package Sort.QuickSort;

import Sort.SortInterface;

//this version uses hoare's partitioning algorithm, one line changes in the quicksort algorithm as well
public class QuickSortHoare implements SortInterface {

    public void sort(int[] A) {
        quicksort(A, 0, A.length - 1);
    }

    public void quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q); //this has to change with hoare's algo
            quicksort(A,q + 1, r);
        }
    }

    //this uses hoare's partitioning algorithm, it's faster
    public int partition(int[]A, int p, int r){
        int x = A[p];
        int i = p - 1;
        int j = r + 1;
        while(true) {
            do {
                i++;
            } while (A[i] < x);

            do {
                j--;
            } while (A[j] > x);

            if (i >= j) return j;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
