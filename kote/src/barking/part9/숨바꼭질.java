package barking.part9;

import java.io.*;
import java.util.*;

public class 숨바꼭질 {

    private static int N;
    private static int K;
    private static int visited[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        if(N > K) {
            return N - K;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 1;
        int a = 0;
        while(!q.isEmpty()) {
            a = q.poll();

            if(a == K) {
                return visited[a] - 1;
            }
            if(a - 1 >= 0 && visited[a-1] == 0) {
                visited[a-1] = visited[a] + 1;
                q.offer(a-1);
            }
            if(a + 1 <= 100000 && visited[a+1] == 0) {
                visited[a+1] = visited[a] + 1;
                q.offer(a+1);
            }
            if(a * 2 <= 100000 && visited[a*2] == 0) {
                visited[a*2] = visited[a] + 1;
                q.offer(a*2);
            }
        }
        return -1;
    }
}
