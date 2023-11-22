package 코테공부.그리디;

import java.io.*;
import java.util.*;

public class 모험가길드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0, total = 0;
        for(int i = 0; i < N; i++) {
            count++;
            if(count >= arr[i]) {
                total++;
                count = 0;
            }
        }

        System.out.println(total);
    }
}
