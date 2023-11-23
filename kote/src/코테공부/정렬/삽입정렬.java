package 코테공부.정렬;

import java.io.*;

// 바로 전과 비교 후 작으면 삽입 크면 break
// 정렬되어 있는 경우 좋음 바로 전과 비교해서 크면 가만히 있으니까 N번 비교하면 됨
public class 삽입정렬 {
    public static void main(String[] args) throws IOException {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j >= 1; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else {
                    break;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
