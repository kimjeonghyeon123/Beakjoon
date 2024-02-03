package 코테;

import java.io.*;
import java.util.*;

public class MooTube {
    public static class Node {
        int index, distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            visited[v] = true;
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(v, 0));

            int ans = 0;
            while(!q.isEmpty()) {
                Node now = q.poll();

                for(Node next : graph[now.index]) {
                    if(!visited[next.index] && next.distance >= k) {
                        q.offer(next);
                        visited[next.index] = true;
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}
/**
 * 1,2   2,3  ===?  1 -> 3
 *
 * 1검사
 * 1과 직접 연결된 비디오들이 나옴
 * 1과 직접 연결했을 때 d[] = 기록함
 * 2와 연결된 것들 구함 3까지 거리 중 가장 짧은 거 구함
 */