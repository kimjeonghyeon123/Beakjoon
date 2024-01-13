package test; /**
 * N*N 복도
 *
 * 선생님, 학생 ,장애물, 빈칸
 *
 * 선생님은 자신의 위치에서 상하좌우 방향으로 감시 중
 * 장애물 뒤편은 불가능
 *
 * 3개의 장애물을 놔서 모든 학생이 선생님의 눈에 띄지 않게 해라
 *
 * 모든 칸의 가로와 세로 선생과 학생 쌍을 확인하고 1
 * 선생을 큐에 담아
 * 빼면서 가로와 세로에 S나 O가 있는지 검사
 * S가 있으면 그 가운데에 O를 담아
 */

import java.io.*;
import java.util.*;

public class test6 {
    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static char[][] graph;
    public static ArrayList<Node> student = new ArrayList<>();
    public static final int[] dx = {0,0,-1,1};
    public static final int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);
                graph[i][j] = c;
                if(c == 'S') {
                    student.add(new Node(i, j));
                }
            }
        }
        dfs(0);

        System.out.println("NO");
    }

    public static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 'X') {
                    graph[i][j] = 'O';
                    dfs(wall+1);
                    graph[i][j] = 'X';
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        char[][] copyGraph = new char[N][N];
        boolean[][] check = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyGraph[i][j] = graph[i][j];
                if(graph[i][j] == 'T') {
                    q.offer(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(graph[nx][ny] != 'O') {
                       check[nx][ny] = true;
                       nx += dx[i];
                       ny += dy[i];
                    }
                    else {
                        break;
                    }
                }
            }
        }
        if(!catchStudent(check)) {
            System.out.println("YES");
            System.exit(0);
        }

    }

    public static boolean catchStudent(boolean[][] check) {
        for(Node node : student) {
            if(check[node.x][node.y]) {
                return true;
            }
        }
        return false;
    }
}
