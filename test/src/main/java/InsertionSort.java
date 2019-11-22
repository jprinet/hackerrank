import java.util.Comparator;
import java.util.stream.IntStream;

class InsertionSort {

    static void update(int[] bit, int index, int value) {
        index++;
        while (index < bit.length) {
            bit[index] += value;
            index += index & (-index);
        }
    }

    static long query(int[] bit, int index) {
        long sum = 0;
        index++;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    static long insertionSort(int[] arr) {
        long inversionCount = 0;

        Comparator<Integer> comp = Comparator.comparingInt(i -> arr[i]);
        int[] orderedIndexedArr = IntStream.range(0, arr.length).boxed().sorted(comp).mapToInt(i -> i).toArray();
        int[] bit = new int[orderedIndexedArr.length + 1];

        for (int i = orderedIndexedArr.length - 1; i >= 0; i--) {
            inversionCount += query(bit, orderedIndexedArr[i]);
            update(bit, orderedIndexedArr[i], 1);
        }

        return inversionCount;
    }

}
