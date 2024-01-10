/**
 * MooTube
 * 1~N 번호
 * 유사도 :
 * (1,2) = 3
 * (2,3) = 2
 * (2,4) = 4
 * ->
 * 큐 : (1,I)
 * 팝 : (1,0) -> 연결된 노드 : (1,2)
 */

import java.io.*;
import java.util.*;


public class test1 {
    static class Node {
        int index, distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
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




















