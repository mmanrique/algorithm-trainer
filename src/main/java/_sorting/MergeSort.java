package _sorting;

import verifications.SortedVerification;

import java.util.Arrays;

public class MergeSort {

    private static Integer[] mergeSort(Integer[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        Integer[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        Integer[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
        int leftIndex = 0;
        int rightIndex = 0;
        int writeIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                array[writeIndex++] = left[leftIndex++];
            } else {
                array[writeIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            array[writeIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            array[writeIndex++] = right[rightIndex++];
        }
        return array;
    }

    public static void main(String[] args) {
        SortedVerification.Companion.sortArray(MergeSort::mergeSort);
    }
}
