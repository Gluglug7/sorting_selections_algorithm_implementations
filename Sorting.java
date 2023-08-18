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

    /**
     * Quick sort algorithm partitions elements into those greater or less than a
     * pivot recursively to sort. O(nlogn) complexity on average.
     * 
     * @param array to be sorted
     * @param start index of the section
     * @param end   index of the section
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int partition = partitionLomuto(array, start, end);
        quickSort(array, start, partition - 1);
        quickSort(array, partition + 1, end);
    }

    /**
     * Helper partition method to split up the arrays for quick sort. Returns the
     * new index of the pivot.
     * 
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partitionLomuto(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }

    // Heapifying from the start
    public static void heapSort(int[] array) {
        int end = array.length;
        while (end > 0) {
            for (int i = 1; i < end; i++) {
                int j = i;
                while (j > 0 && array[j] > array[(j-1)/2]) {
                    int temp = array[j];
                    array[j] = array[(j-1)/2];
                    array[(j-1)/2] = temp;
                    j = (j-1)/2;
                }
            }
            int temp2 = array[0];
            array[0] = array[end - 1];
            array[end - 1] = temp2;
            end--;
        }
    }

    // Heapifying from the end
    public static void heapSort2(int[] array) {
        for (int i = array.length/2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i-1];
            array[i-1] = temp;
            heapify(array, i-1, 0);
        }
    }

    private static void heapify(int[] array, int end, int i) {
        int largest = i;
        int left = (2*i) + 1;
        int right = (2*i) + 2;
        if (left < end && array[left] > array[largest]) largest = left;
        if (right < end && array[right] > array[largest]) largest = right;
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, end, largest);
        }
    }
}