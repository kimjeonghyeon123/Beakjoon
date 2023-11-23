package 코테공부.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int) 1e9;
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if(total < M) {
                end = mid - 1;
            }
            else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
