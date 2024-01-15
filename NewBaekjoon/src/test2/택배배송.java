package test2;

/**
 * N개의 헛간
 * 소들의 길 M개의 양방향 길
 * 각각의 길은 C 마리의 소가 있음
 * 최소한의 소만 만나고 싶음
 * 최소 여물
 */

import java.io.*;
import java.util.*;

public class 택배배송 {
    public static class Node implements Comparable<Node> {
        int index, distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            if(distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra(1);
        System.out.println(d[N]);
    }

    public static void dijkstra(int start) {
        d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int now = node.index;
            int dist = node.distance;

            // 연결된 것보다 작은 게 있으면 갈 필요없지
            if(d[now] < dist) {continue;}

            for(Node next : graph.get(now)) {
                int cost = d[now] + next.distance;
                if(cost < d[next.index]) {
                    d[next.index] = cost;
                    q.offer(new Node(next.index, cost));
                }
            }
        }
    }
}
