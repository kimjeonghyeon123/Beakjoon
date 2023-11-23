package 코테공부.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x + " ");

            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
