package _sorting;

import verifications.SortedVerification;

public class InsertionSort {

    private static Integer[] insertionSort(Integer[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        //The array [0 to i-1] is already sorted
        //This loops stops when i = input.length
        //Therefore, by invariant [0 to input.length-1] is sorted
        for (int i = 1; i < input.length; i++) {
            Integer value = input[i];
            int j = i;
            while (j > 0 && input[j - 1] > value) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = value;

        }
        return input;
    }

    public static void main(String[] args) {
        SortedVerification.Companion.sortSmallArray(InsertionSort::insertionSort);
    }
}
