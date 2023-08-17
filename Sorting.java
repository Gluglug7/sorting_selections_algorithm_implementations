public class Sorting {

    /**
     * Swap sort finds the minimum value in the array and swaps it with the current
     * value until the array is sorted. O(n^2) complexity.
     * 
     * @param array to be sorted
     */
    public static void swapSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minInd]) {
                    minInd = j;
                }
            }
            int temp = array[minInd];
            array[minInd] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Insertion sort goes through the array and sees where the next element should
     * be placed. O(n^2) complexity.
     * 
     * @param array to be sorted
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    /**
     * Merge sort splits the array into two parts and combines them to sort them.
     * O(nlog(n)) complexity (becuase of combine method).
     * 
     * @param array to be sorted
     * @param start index of area to be sorted
     * @param end   index of area to be sorted
     */
    public static void merge(int[] array, int start, int end) {
        if (start == end)
            return;
        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid + 1, end);
        combine(array, start, mid, end);
    }

    /**
     * Helper method for merge sort to appropriately combine the two parts of the
     * array to be sorted correctly.
     * 
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private static void combine(int[] array, int start, int mid, int end) {
        int[] a = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        for (int i = 0; i < end - start + 1; i++) {
            if (p1 > mid)
                a[i] = array[p2++];
            else if (p2 > end)
                a[i] = array[p1++];
            else if (array[p1] <= array[p2])
                a[i] = array[p1++];
            else
                a[i] = array[p2++];
        }
        for (int i = start; i <= end; i++)
            array[i] = a[i - start];
    }
}