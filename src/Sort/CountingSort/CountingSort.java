package Sort.CountingSort;

import Sort.SortInterface;

import java.util.Arrays;

public class CountingSort implements SortInterface {
    public void sort(int[] A) {
        //this way the sorting looses it's effectiveness, but the test can only run like this
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : A){
            if (i < min) min = i;
            if (i > max) max = i;
        }
        A = countingSort(A, max - 1);
    }

    public static int[] countingSort(int[] A, int k) {
        int[] C = new int[k];
        Arrays.fill(C, 0);
        for(int i : A) {
            C[i]++;
        }

        for (int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }

        int[] B = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] array = {1,0,3,4,2};
        int[] sorted = countingSort(array, 5);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sorted));
    }
}
