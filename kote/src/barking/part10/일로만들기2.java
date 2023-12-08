package barking.part10;

import java.io.*;
import java.util.*;

/**
 *  X/3, X/2, X-1
 *  X -> 1 최솟횟수
 *  d[i] : i가 1이 되기 위한 최소횟수
 *  d[i] = min(d[i/3], d[i/2], d[i-1]) + 1
 */
public class 일로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N+1];
        int[] visited = new int[N+1];
        for(int i = 2; i <= N; i++) {
            d[i] = d[i-1] + 1;
            visited[i] = i-1;

            if(i % 3 == 0 && d[i/3] + 1 < d[i]) {
                d[i] = d[i/3] + 1;
                visited[i] = i / 3;
            }
            if(i % 2 == 0 && d[i/2]+1 < d[i]) {
                d[i] = d[i/2] + 1;
                visited[i] = i / 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[N]).append("\n");
        sb.append(N).append(" ");
        while(N!=1) {
            N = visited[N];
            sb.append(N).append(" ");
        }
        System.out.println(sb.toString());
    }
}
