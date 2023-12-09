package barking.part9;

/**
 * 수빈 -> 동생
 * x -> x-1 x+1 2x
 */

import java.io.*;
import java.util.*;

class Hide{
    int index;
    int len;

    public Hide(int index, int len) {
        this.index = index;
        this.len = len;
    }

    public int getIndex() {
        return index;
    }

    public int getLen() {
        return len;
    }
}
public class 숨바꼭질4 {
    public static final int MAX = 100001;
    public static int N, K;
    public static int[] graph = new int[MAX];
    public static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Hide> q = new LinkedList<>();

        int l = 0;
        q.offer(new Hide(N, 0));
        visited[N] = true;
        while(!q.isEmpty()) {
            Hide hide = q.poll();

            if(hide.getIndex() == K) {
                l = hide.getLen();
                break;
            }
            int next = hide.getIndex() + 1;
            if(next < MAX && !visited[next]) {
                q.offer(new Hide(next, hide.getLen() + 1));
                graph[next] = hide.getIndex();
                visited[next] = true;
            }
            next = hide.getIndex() - 1;
            if(next >= 0 && !visited[next]) {
                q.offer(new Hide(next, hide.getLen() + 1));
                graph[next] = hide.getIndex();
                visited[next] = true;
            }
            next = hide.getIndex() * 2;
            if(next < MAX && !visited[next]) {
                q.offer(new Hide(next, hide.getLen() + 1));
                graph[next] = hide.getIndex();
                visited[next] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l).append("\n");

        Stack<Integer> s = new Stack<>();
        while(K != N) {
            s.push(K);
            K = graph[K];
        }
        s.push(K);
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
