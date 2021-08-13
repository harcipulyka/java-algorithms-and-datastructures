package Sort;

import Sort.MergeSort.MergeSort;
import Sort.QuickSort.QuickSort;
import Sort.QuickSort.QuickSortHoare;
import Sort.QuickSort.QuickSortRandomized;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTests {
    static Random random = new Random();

    static Stream<Arguments> localParameters() {
        return Stream.of(
                Arguments.of(new QuickSort()),
                Arguments.of(new QuickSortRandomized()),
                Arguments.of(new QuickSortHoare()),
                Arguments.of(new MergeSort())
        );
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void simpleTest(SortInterface s) {
        int[] array = {1, 3, 2};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void simpleTest2(SortInterface s) {
        int[] array = {1, 3, 2, 0, -1, -5, 10};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void alreadySorted1(SortInterface s) {
        int[] array = {-1, 0, 1, 2, 3};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void alreadySorted2(SortInterface s) {
        int[] array = {-1234456, -321, -12, 0, 12342, 12355};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void emptyArray(SortInterface s) {
        int[] array = {};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void oneMember(SortInterface s) {
        int[] array = {0};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void edgeCase(SortInterface s) {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 12, 0, Integer.MAX_VALUE};
        s.sort(array);
        int[] expArr = Arrays.stream(array).sorted().toArray();
        assertArrayEquals(expArr, array);
    }


    @ParameterizedTest
    @MethodSource("localParameters")
    public void repeatedRandomWith10Members(SortInterface s) {
        for (int j = 0; j < 20; j++) {
            int[] array = new int[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt();
            }
            s.sort(array);
            int[] expArr = Arrays.stream(array).sorted().toArray();
            assertArrayEquals(expArr, array);
        }
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void tenRandomWith9Members(SortInterface s) {
        for (int j = 0; j < 20; j++) {


            int[] array = new int[9];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt();
            }
            s.sort(array);
            int[] expArr = Arrays.stream(array).sorted().toArray();
            assertArrayEquals(expArr, array);
        }
    }

}
