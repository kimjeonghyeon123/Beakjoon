package barking.part10;

/**
 * 수열 A = 가장 긴 증가하는 부분 수열 구하시오
 *
 * d[i]는 i를 포함했을 때 가장 긴 수열의 길이
 * d[i] = Math.max(d[i-1], d[i-2], .. ,d[0]) + 1;
 */

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N];
        int[] r = new int[N];

        for(int i = 0; i < N; i++) {
            r[i] = i;
        }
        Arrays.fill(d, 1);
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(d[j] + 1 > d[i]) {
                        d[i] = d[j] + 1;
                        r[i] = j;
                    }
                }
            }
        }

        int max = 0, t = 0;
        for(int i = 0; i < N; i++) {
            if(max < d[i]) {
                max = d[i];
                t = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        Stack<Integer> s = new Stack<>();
        while(t != r[t]) {
            s.push(arr[t]);
            t = r[t];
        }
        s.push(arr[t]);
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
