package Sort.MergeSort;

import Sort.SortInterface;

public class MergeSort implements SortInterface {
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] A, int p, int r){
        if (p < r) {
            int q = p + (r - p) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        //calculates the 2 subarrays size
        int n1 = q - p + 1;
        int n2 = r - q;

        //creates two subarrays, +1 because of the sentinel value
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        //fills up the two subarrays
        System.arraycopy(A, p, L, 0, n1);
        System.arraycopy(A,q+1,R,0,n2);

        //placing the sentinel value
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        //merging the two subarrays back to the array
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
        }
    }
}


