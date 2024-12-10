package searchsort;

/**
 * Abstract class for sorting algorithms.
 * 
 */
public class MergeSort extends Sort {
    /**
     * Sort the array arr.
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Sort the array and return the time taken in milliseconds.
     */
    //public long timedSort(int[] arr) {
        //long startTime = System.currentTimeMillis();
        //sort(arr);
        //long endTime = System.currentTimeMillis();
        //return endTime - startTime;
    //}

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
