package barking.part9;

/**
 * N, M 행렬
 * 각 플레이어는 성을 하나 이상 가짐
 * 각 턴마다 비어있는 칸으로 성을 확장
 * 자신이 있는 곳에서 si 만큼 이동할 수 있는 모든 칸에 성을 동시에 만듦
 */

import java.io.*;
import java.util.*;

class NodeD implements Comparable<NodeD> {
    int x, y, index, len;
    public NodeD(int x, int y, int index, int len) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.len = len;
    }

    @Override
    public int compareTo(NodeD node) {
        if(index < node.index) {
            return -1;
        }
        return 1;
    }
}
public class 확장게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        int[] s = new int[P];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < P; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<NodeD> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '.':
                        graph[i][j] = 0;
                        break;
                    case '#':
                        graph[i][j] = -1;
                        break;
                    default:
                        graph[i][j] = c - '0';
                        list.add(new NodeD(i, j, c-'0', 0));
                        break;
                }
            }
        }
        Collections.sort(list);
        Queue<NodeD> q = new LinkedList<>();
        for (NodeD i : list) {
            q.offer(i);
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                NodeD node = q.poll();
                int x = node.x;
                int y = node.y;
                int index = node.index;
                int len = node.len;

                for(int i = 0; i < 4; i++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) {continue;}
                    if(graph[nx][ny] == 0 && len+1 <= s[index]) {
                        q.offer(new NodeD(nx, ny, index, len+1));
                    }
                }
            }
        }
    }
}
