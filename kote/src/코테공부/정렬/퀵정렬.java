package 코테공부.정렬;

import java.io.*;

public class 퀵정렬 {

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            // 피벗보다 큰 데이터 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) {left++;}

            while(right > start && arr[right] >= arr[pivot]) {right--;}

            if(left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
