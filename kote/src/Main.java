/**
 * 인접한 수가 1 차이
 * d[i][k] : i 자리에 k 수가 오는 경우의 수
 * d[i][k] = d[i-1][k+1] + 1 이거나 d[i-1][k-1]+1;
 */

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;

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
class Main {
    public static final int INF = (int) 1e9;
    public static int N, M, X;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, z));
        }

        int[] go = new int[N+1];
        for(int i = 1; i <= N; i++) {
            d = new int[N+1];
            Arrays.fill(d, INF);
            dijkstra(i);
            go[i] = d[X];
        }
        d = new int[N+1];
        Arrays.fill(d, INF);
        dijkstra(X);
        for(int i = 1; i <= N; i++) {
            go[i] += d[i];
        }
        System.out.println(Arrays.stream(go).max().getAsInt());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if(d[now] < dist) {continue;}

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;

                if(cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}