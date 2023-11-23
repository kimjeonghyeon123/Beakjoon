package 코테공부.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특정수개수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N;

        while(start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] >= x) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        int total = end;
        start = 0;
        end = N;
        while(start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] > x) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        total = end - total;

        System.out.println(total);
    }
}
