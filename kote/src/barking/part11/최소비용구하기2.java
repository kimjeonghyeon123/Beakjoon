package barking.part11;

/**
 * n개의 도시 (1 <= n <= 1000)
 * m개의 버스 (1 <= m <= 100000)
 * A -> B 까지 가는 버스 비용 최소
 */

import java.io.*;
import java.util.*;

public class 최소비용구하기2 {

    public static final int INF = (int) 1e9;
    public static int n, m, s, e;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
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
            graph.get(x).add(new Node(y, z));
        }

        r = new int[n+1];
        d = new int[n+1];
        Arrays.fill(d, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dijkstra(s);

        StringBuilder sb = new StringBuilder();
        sb.append(d[e]).append("\n");
        Stack<Integer> stack = new Stack<>();
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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        r[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                    r[graph.get(now).get(i).getIndex()] = now;
                }
            }
        }
    }
}
