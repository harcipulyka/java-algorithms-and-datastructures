package Sort.QuickSort;

import Sort.SortInterface;

import java.util.Random;

//this version of the quick sort uses randomized pivot element at each partition
public class QuickSortRandomized implements SortInterface {
    @Override
    public void sort(int[] A) {
        randomizedQuicksort(A, 0, A.length - 1);
    }

    //this section is for the randomized quick sort
    public void randomizedQuicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            randomizedQuicksort(A, p, q - 1);
            randomizedQuicksort(A,q + 1, r);
        }
    }

    //this section is for the randomized partition, only the randomized quicksort uses this
    public int randomizedPartition(int[] A, int p, int r) {
        //creating a random index between p and r, that will be the pivot
        Random rand = new Random();
        int low = p;
        int high = r;
        int randomIndex = rand.nextInt(high-low) + low;

        //exchanging the element at the random index with the one at the end
        int temp = A[randomIndex];
        A[randomIndex] = A[r];
        A[r] = temp;

        //calling normal partitioning
        return QuickSort.partition(A, p, r);
    }
}
