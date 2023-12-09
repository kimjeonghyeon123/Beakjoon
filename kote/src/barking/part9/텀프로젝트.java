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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            sb.append(team(n, str)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int team(int n, String str) {
        StringTokenizer st = new StringTokenizer(str);
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            //자기 자신일 때 방문 처리 후, 결과 하나 올림
            if(i == arr[i]) {
                visited[i] = true;
                result++;
                continue;
            }
            if(visited[i]) {continue;}
            //자기 자신이 아닌 경우
            int cnt = 1;
            int start = i;
            while(true) {
                visited[start] = true;
                int other = arr[start];
                if(visited[other]) {
                    if(other == i) {
                        break;
                    }
                    else {
                        cnt = 0;
                        break;
                    }
                }
                else {
                    start = other;
                    cnt++;
                }
            }
            result += cnt;
        }

        return n - result;
    }
}
