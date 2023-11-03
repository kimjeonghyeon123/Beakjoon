package 동빈나.정렬;

import java.util.Scanner;

public class SeletionSort {

    public static int n = 10;
    public static int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void window() {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        window();

        //선택 정렬
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
            window();
        }

        window();
    }
}
