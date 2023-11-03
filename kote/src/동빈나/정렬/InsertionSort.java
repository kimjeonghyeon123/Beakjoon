package 동빈나.정렬;

import java.util.*;

public class InsertionSort {

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

        //삽입 정렬
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else break;
                window();
            }
            System.out.println("================");
        }

        window();
    }
}
