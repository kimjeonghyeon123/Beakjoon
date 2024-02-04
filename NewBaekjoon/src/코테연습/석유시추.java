package 코테연습;

import java.util.*;

public class 석유시추 {
    public static void main(String[] args) {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        int n = land.length;
        int m = land[0].length;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        ArrayList<Integer> area_size = new ArrayList<>();
        area_size.add(0);

        int[][] graph = new int[n][m];
        int area_num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] != 0 || land[i][j] == 0) {continue;}

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                graph[i][j] = area_num;

                int amount = 0;
                while(!q.isEmpty()) {
                    int[] now = q.poll();
                    amount++;

                    for(int k = 0; k < 4; k++) {
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                        if(graph[nx][ny] == 0 && land[nx][ny] == 1) {
                            graph[nx][ny] = area_num;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }

                area_size.add(amount);
                area_num++;
            }
        }

        int size = area_size.size();
        int max = 0;
        for(int col = 0; col < m; col++) {
            boolean[] visited = new boolean[size+1];
            int amount = 0;
            for(int row = 0; row < n; row++) {
                if(graph[row][col] == 0) {continue;}

                if(!visited[graph[row][col]]) {
                    visited[graph[row][col]] = true;
                    amount += area_size.get(graph[row][col]);
                }
            }
            max = Math.max(max, amount);
        }

        System.out.println(max);
    }
}