import java.io.*;
import java.util.*;

public class MooTube {

    private static Queue<Integer> q;
    private static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N+1];

        q = new LinkedList<>();

        q.offer(N);
        while(!q.isEmpty()) {
            int t = q.poll();

            if(t==1) {
                break;
            }

            if(t % 3 == 0 && t / 3 >= 1 && graph[t/3] == 0) {
                q.offer(t/3);
                graph[t/3] = graph[t] + 1;
            }

            if(t % 2 == 0 && t / 2 >= 1 && graph[t/2] == 0) {
                q.offer(t/2);
                graph[t/2] = graph[t] + 1;
            }

            if(t - 1 >= 1 && graph[t-1] == 0) {
                q.offer(t-1);
                graph[t-1] = graph[t] + 1;
            }

        }

        System.out.println(graph[1]);
    }
}
