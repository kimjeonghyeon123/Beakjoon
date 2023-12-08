package barking.part11;

/**
 * N개 마을 : 각각 학생 한명
 * X마을에 모여 파티
 * M개 단방향 도로
 */

import java.io.*;
import java.util.*;

class Node2 implements Comparable<Node2> {
    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return index;}
    public int getDistance() {return distance;}

    @Override
    public int compareTo(Node2 other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}

public class 파티 {

    public static final int INF = (int) 1e9;
    public static int n, m, x;
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node2(b, c));
        }

        d = new int[n+1];
        Arrays.fill(d, INF);
        d[0] = 0;
        dijkstra(x);

        System.out.println(Arrays.stream(d).max().getAsInt());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node2(start, 0));

        while(!pq.isEmpty()) {
            Node2 node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
