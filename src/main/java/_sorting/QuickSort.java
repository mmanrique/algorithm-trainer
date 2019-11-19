package _sorting;

import verifications.SortedVerification;

import java.util.Random;

public class QuickSort {
    private static Integer[] quickSort(Integer[] input) {
        quickSort(input, 0, input.length);
        return input;
    }

    private static void quickSort(Integer[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        //Grab a random number as pivot.
        //Number is between start and end exclusive
        int random = new Random().nextInt(end - start);
        int pivot = input[start + random];
        //Move pivot to the end
        int temp1 = input[end - 1];
        input[end - 1] = input[start + random];
        input[start + random] = temp1;
        //Reorder
        int greater = reorder(input, start, end - 1, pivot);
        //Pivot goes into greater
        int temp = input[greater];
        input[greater] = input[end - 1];
        input[end - 1] = temp;
        //Location greater now has the pivot
        //QuickSort left and Right
        quickSort(input, start, greater);
        quickSort(input, greater + 1, end);
    }

    private static int reorder(Integer[] input, int start, int end, int pivot) {
        //Separate them in sections
        //0-less-i-greater-(end-1)
        //0-less is lesser
        //less-i is equal
        //i-greater is unknown
        //greater-(end-1) is greater
        int less = start;
        int greater = end;
        int i = start;
        while (i < greater) {
            if (input[i] < pivot) {
                //Swap input[i] with input[less]
                int temp = input[i];
                input[i] = input[less];
                input[less] = temp;
                //We have grabbed a known one, increase i
                i++;
                //Increase less
                less++;

            } else if (input[i] == pivot) {
                //increase i since it's in the range
                i++;
            } else {
                //input[i]>pivot
                //Swap input[i] with input[greater]
                int temp = input[i];
                input[i] = input[greater - 1];
                input[greater - 1] = temp;
                //We just grabbed an unknown, do not increase i
                //decrease greater
                greater--;
            }
        }
        return greater;

    }

    public static void main(String[] args) {
        SortedVerification.Companion.sortArray(QuickSort::quickSort);
    }
}
