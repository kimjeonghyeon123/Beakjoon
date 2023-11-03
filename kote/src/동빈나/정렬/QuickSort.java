package 동빈나.정렬;

public class QuickSort {

    public static void show(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; //원소가 1개인 경우 종료
        int pivot = start;
        int left = start + 1;
        int right = end;

        //퀵 소트
        while(left <= right) {
            // 왼쪽에서부터 pivot 보다 큰 값 찾으면 종료
            while(left <= end && arr[left] <= arr[pivot]) left++;
            // 오른쪽에서부터 pivot 보다 작은 값 찾으면 종료
            while(right > start && arr[right] >= arr[pivot]) right--;
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

        //분할
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        show(arr);

        quickSort(arr, 0, arr.length - 1);

        show(arr);
    }
}
