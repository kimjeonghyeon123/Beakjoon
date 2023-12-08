package barking.part9;


import java.io.*;
import java.util.*;

class Node3 {
    private int x;
    private int y;
    private int z;
    public Node3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getZ() {return z;}
}

public class 상범빌딩 {

    public static int L, R, C;
    public static int[][][] graph;
    public static int[] dx = {0, 0, 0, 0, -1, 1};
    public static int[] dy = {0, 0, -1, 1, 0, 0};
    public static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) { break;}
            graph = new int[L][R][C];
            Node3 startNode = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = str.charAt(k);
                        if (c == '#') {
                            graph[i][j][k] = -1;
                        } else if (c == '.') {
                            graph[i][j][k] = 0;
                        } else if (c == 'S') {
                            graph[i][j][k] = 1;
                            startNode = new Node3(i, j, k);
                        } else if (c == 'E') {
                            graph[i][j][k] = -2;
                        }
                    }
                }
                br.readLine();
            }

            int t = bfs(startNode);
            if (t == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(t).append(" minute(s).\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static int bfs(Node3 start) {
        Queue<Node3> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Node3 node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int z = node.getZ();

            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C) {
                    continue;
                }
                if(graph[nx][ny][nz] == -1) {
                    continue;
                }
                if(graph[nx][ny][nz] == -2) {
                    return graph[x][y][z];
                }
                if(graph[nx][ny][nz] == 0) {
                    graph[nx][ny][nz] = graph[x][y][z] + 1;
                    q.offer(new Node3(nx, ny, nz));
                }
            }
        }
        return -1;
    }
}