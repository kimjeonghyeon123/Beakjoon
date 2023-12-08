package barking.part11;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;
    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {return index;}
    public int getDistance() {return distance;}
    @Override
    public int compareTo(Node other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}
public class 최단경로 {

    public static final int INF = (int) 1e9;
    public static int v, e, k;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[v+1];
        Arrays.fill(d, INF);

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, z));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++) {
            if(d[i] == INF) {
                sb.append("INF").append("\n");
            }
            else {
                sb.append(d[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) {continue;}

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
