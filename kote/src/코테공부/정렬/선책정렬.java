package 코테공부.정렬;

import java.io.*;

// 제일 작은 걸 선택해서 앞으로 보내는 것을 반복
public class 선책정렬 {
    public static void main(String[] args) throws IOException {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < arr.length - 1; i++) {

            int index = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[index] > arr[j]) {
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
