package barking.part11;

/**
 * n개의 도시
 * m개의 버스
 */

import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int index;
    int distance;

    public Bus(int index, int distance) {
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
    public int compareTo(Bus other) {
        if(this.distance < other.getDistance()) {
            return -1;
        }
        return 1;
    }
}

public class 최소비용구하기22 {
    public static final int INF = (int) 1e9;
    public static int n, m, s, e;
    public static ArrayList<ArrayList<Bus>> graph = new ArrayList<>();
    public static int[] d;
    public static int[] r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Bus(y, z));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        r = new int[n+1];
        Arrays.fill(d, INF);

        dijkstra(s);
        StringBuilder sb = new StringBuilder();
        sb.append(d[e]).append("\n");

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while(e != s) {
            stack.push(e);
            e = r[e];
        }
        stack.push(e);

        sb.append(stack.size()).append("\n");

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Bus(start, 0));

        while(!pq.isEmpty()) {
            Bus bus = pq.poll();
            int now = bus.getIndex();
            int dist = bus.getDistance();

            if(d[now] < dist) {continue;}

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Bus(graph.get(now).get(i).getIndex(), cost));
                    r[graph.get(now).get(i).getIndex()] = now;
                }
            }
        }
    }
}
