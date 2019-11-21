import java.util.TreeMap;

public class InsertionSort {

    static int insertionSort(int[] arr) {
        int nbShifts = 0;

        TreeMap<Integer, Integer> ordered = new TreeMap<>();
        ordered.put(arr[0], 1);

        for (int i = 1; i < arr.length; i++) {
            if (ordered.lastKey() > arr[i]) {
                for (Integer current : ordered.descendingKeySet()) {
                    if (current > arr[i]) {
                        nbShifts += ordered.get(current);
                    } else {
                        break;
                    }
                }
            }
            ordered.put(arr[i], ordered.get(arr[i]) != null ? ordered.get(arr[i]) + 1 : 1);
        }
        return nbShifts;
    }

}
