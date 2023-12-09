import java.io.*;
import java.util.*;

class Node {
    private int x, y, cnt;
    private boolean destroyed;
    public Node(int x, int y, int cnt, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroyed = destroyed;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getCnt() {return cnt;}
    public boolean isDestroyed() {return destroyed;}
}
class Main {
    public static int N, M;
    public static int[][] graph;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int cnt = node.getCnt();
            boolean destroyed = node.isDestroyed();

            if(x == N-1 && y == M-1) {return cnt;}
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                //0일 때
                if(graph[nx][ny] == 0) {
                    //부수지 않았을 때
                    if(!destroyed && !visited[nx][ny][0]) {
                        q.offer(new Node(nx, ny, cnt+1, false));
                        visited[nx][ny][0] = true;
                    }
                    else if(!destroyed && !visited[nx][ny][1]){
                        q.offer(new Node(nx, ny, cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else {
                    if(!destroyed) {
                        q.offer(new Node(nx, ny, cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}