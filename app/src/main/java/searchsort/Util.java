package searchsort;

import java.util.Random;

/**
 * Utility class for providing helper methods for search and sort algorithms.
 */
public class Util {
    /**
     * Shuffle the elements in the given array using Fisher-Yates shuffle algorithm.
     * 
     * Fisher-Yates Shuffle Algorithm:
     * 1. Iterate over the array from the last element to the second element.
     * 2. For each element at index i, generate a random index j (0 to i).
     * 3. Swap the element at index i with the element at index j.
     * 4. Continue until the entire array is shuffled.
     * 
     * @param arr  The array to be shuffled.
     * @param seed The seed for the random number generator.
     * 
     * @return The shuffled array.
     */
    public static int[] shuffle(int[] arr, Long seed) {
        // Initialize a Random object with the given seed if provided
        Random random = (seed != null) ? new Random(seed) : new Random();
        // Note: This generates a random number between 0 and 5:
        // int randomNum = random.nextInt(6);
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            exch(arr, i, j);
        }


        return arr;
    }

    /**
     * Exchange the elements at indices i and j in the array arr.
     */
    public static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Generate a random array of size n where each element is between 0 and n-1.
     */
    public static int[] generateRandomArray(int n, Long seed) {
        // Create a new integer array of size n
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // Shuffle the array using the Shuffle method with the given seed

        // Return the shuffled array
        return shuffle(arr, seed);
    }

    /**
     * Check if the array arr is sorted in ascending order.
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
