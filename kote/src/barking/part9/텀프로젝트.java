package barking.part9;

/**
 * 팀원 수 제한 없음, 한 팀만 있을 수도 있음
 * s1 -> s2 -> s3 -> s1 이래야 한 팀
 * s1 -> s2 -> s2
 *
 * 3 1 3 7 3 4 6
 */

import java.io.*;
import java.util.*;

public class 텀프로젝트 {

    public static int n;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int bfs() {
        return 1;
    }

}
