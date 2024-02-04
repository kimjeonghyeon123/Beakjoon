package 코테연습;

import java.util.Objects;

public class 수레움직이기 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
    }
    public static int n, m;
    public static int[][] maze;
    public static Node red_node, blue_node;
    public static Node red_dest_node, blue_dest_node;
    public static int min = Integer.MAX_VALUE;
    public static boolean[][] red_visited, blue_visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) {

        maze = new int[][]{
                {1,0,2},
                {0,0,0},
                {5,0,5},
                {4,0,3}
        };
        n = maze.length;
        m = maze[0].length;

        red_visited = new boolean[n][m];
        blue_visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                switch (maze[i][j]) {
                    case 1 :
                        red_node = new Node(i, j);
                        red_visited[i][j] = true;
                        break;
                    case 2 :
                        blue_node = new Node(i, j);
                        blue_visited[i][j] = true;
                        break;
                    case 3 :
                        red_dest_node = new Node(i, j);
                        break;
                    case 4 :
                        blue_dest_node = new Node(i, j);
                        break;
                    case 5 :
                        red_visited[i][j] = true;
                        blue_visited[i][j] = true;
                        break;
                }
            }
        }

        dfs(false, false, 0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void dfs(boolean red_moved, boolean blue_moved, int depth) {
        if(red_node.equals(red_dest_node)) {
            red_moved = true;
        }
        if(blue_node.equals(blue_dest_node)) {
            blue_moved = true;
        }

        if(red_moved && blue_moved) {
            min = Math.min(min, depth);
            return;
        }

        if(!red_moved) {
            for(int i = 0; i < 4; i++) {
                int nx = red_node.x + dx[i];
                int ny = red_node.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                if(blue_node.equals(new Node(nx, ny))) {continue;}
                if(!red_visited[nx][ny]) {
                    red_visited[nx][ny] = true;
                    red_node.x = nx;
                    red_node.y = ny;
                    if(blue_moved) {
                        dfs(false, false, depth+1);
                    }
                    else {
                        dfs(true, false, depth);
                    }
                    red_visited[nx][ny] = false;
                    red_node.x -= dx[i];
                    red_node.y -= dy[i];
                }
            }
        }

        if(!blue_moved) {
            for(int i = 0; i < 4; i++) {
                int nx = blue_node.x + dx[i];
                int ny = blue_node.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                if(red_node.equals(new Node(nx, ny))) {continue;}

                if(!blue_visited[nx][ny]) {
                    blue_visited[nx][ny] = true;
                    blue_node.x = nx;
                    blue_node.y = ny;
                    if(red_moved) {
                        dfs(false, false, depth+1);
                    }
                    else {
                        dfs(false, true, depth);
                    }
                    blue_visited[nx][ny] = false;
                    blue_node.x -= dx[i];
                    blue_node.y -= dy[i];
                }
            }
        }
    }
}