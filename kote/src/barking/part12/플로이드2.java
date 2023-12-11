package barking.part12;

import java.io.*;
import java.util.*;

public class 플로이드2 {
    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph;
    public static int[][] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        route = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for(int i = 0; i <= n; i++) {
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = Math.min(graph[x][y], z);
            route[x][y] = x;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        route[i][j] = route[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) {
                    graph[i][j] = 0;
                }
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }


        for(int start = 1; start <= n; start++) {
            for(int end = 1; end <= n; end++) {
                if(start == end) {
                    sb.append("0\n");
                }
                else {
                    Stack<Integer> stack = new Stack<>();
                    int idx= route[start][end];
                    while(idx != 0) {
                        stack.push(idx);
                        idx = route[start][idx];
                    }
                    if(stack.isEmpty()) {
                        sb.append("0\n");
                    }
                    else{
                        sb.append(stack.size() + 1).append(" ");
                        while(!stack.isEmpty()) {
                            sb.append(stack.pop()).append(" ");
                        }
                        sb.append(end).append("\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
