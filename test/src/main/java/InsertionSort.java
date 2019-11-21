public class InsertionSort {

    static int insertionSort(int[] arr) {
        int nbShifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                nbShifts++;
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        return nbShifts;
    }

}
