package barking.part11;

import java.io.*;
import java.util.*;

class Bridge implements Comparable<Bridge> {
    int index;
    int distance;

    public Bridge(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
    @Override
    public int compareTo(Bridge other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}
public class 최단경로2 {

    public static final int INF = (int) 1e9;
    public static int V, E, K;
    public static ArrayList<ArrayList<Bridge>> graph = new ArrayList<>();
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Bridge(y, z));
        }

        d = new int[V+1];
        Arrays.fill(d, INF);
        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            if(d[i] == INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(d[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Bridge(start, 0));

        while(!pq.isEmpty()) {
            Bridge bridge = pq.poll();
            int now = bridge.getIndex();
            int dist = bridge.getDistance();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Bridge(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
