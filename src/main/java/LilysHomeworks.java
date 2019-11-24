import java.util.Arrays;
import java.util.HashMap;

class LilysHomeworks {

    static long lilysHomework(int[] arr) {
        long swapsInOrder = getSwaps(Arrays.copyOf(arr, arr.length));
        long swapsInReverseOrder = getSwaps(java.util.stream.IntStream.range(0, arr.length).map(i -> arr[arr.length - i - 1]).toArray());

        return java.lang.Math.min(swapsInOrder, swapsInReverseOrder);
    }

    static long getSwaps(int[] arr) {
        long swaps = 0;

        java.util.Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexByValue.put(arr[i], i);
        }
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i]) {
                swaps++;

                int currentValue = arr[i];
                int currentSortedValue = sortedArr[i];

                swap(arr, i, indexByValue.get(currentSortedValue));

                indexByValue.put(currentValue, indexByValue.get(currentSortedValue));
            }
        }

        return swaps;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

}
