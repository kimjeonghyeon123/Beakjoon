/**
 * 체스판 : (N,N)
 * 말 개수 : K개
 * 하나의 말 위에 다른 말 오릴 수 있음
 * 체스판 색 : 흰, 빨, 파
 * 시작 : 체스판 위에 말 K개, 이동 방향 정해짐
 * 1번 말부터 K번 말까지 순서대로 이동
 * 한 말이 이동할 때 가장 아래에 있는 말만 이동가능 올려진 말을 자동 이동
 * 말이 있는 곳으로 가면 위로 쌓임 4개 이상이 되면 종료
 *
 * 흰색 :
 *  - 이동
 *  - 말이 있을 경우 맨 위에 가장 위에 쌓음
 *  - ex) a,b,c -> d,e  ---> d,e,a,b,c
 *
 * 빨강색 :
 *  - ex) a,b,c -> 0  ----> c,b,a
 *  - ex) a,d,f,g -> e,c,b ----> e,c,b,g,f,d,a
 *
 * 파란색 :
 *  - 말의 이동 방향을 반대로하고 한 칸 이동
 *  - 그 칸이 파란색인 경우 이동하지 않고 방향만 반대로 바꿈
 *  - 다시 자기 칸으로 돌아오는 것
 *  - 체스판을 벗어난 경우도 마찬가지임
 *  - 방향을 반대로 바꾼 상태로 들어옴
 *
 *  흰색일 경우 이동하고 그 위에 뭐가 있는지 검사하고 검사했으면 위에 올려
 *  그 위에 뭐가 있는지 검사하려면 list.add() 하면 됨
 *
 *  체스판 위에 올려놓고 그 위에 뭐가 있는지 검사하자 그래프가 두개 있는 게 편할 듯?
 *
 */

import java.io.*;
import java.util.*;

class Node3 {
    int index,x,y,dx,dy;
    public Node3(int index, int x, int y, int dx, int dy) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
}
public class test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Node3>[][] list = new LinkedList[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                list[i][j] = new LinkedList<>();
            }
        }

        Queue<Node3> q = new LinkedList<>();
        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d == 1) {
                q.offer(new Node3(i, x, y, 0, 1));
                list[x][y].offerLast(new Node3(i, x, y, 0, 1));
            }
            else if(d == 2) {
                q.offer(new Node3(i, x, y, 0, -1));
                list[x][y].offerLast(new Node3(i, x, y, 0, -1));
            }
            else if(d == 3) {
                q.offer(new Node3(i, x, y, -1, 0));
                list[x][y].offerLast(new Node3(i, x, y, -1, 0));
            }
            else if(d == 4) {
                q.offer(new Node3(i, x, y, 1, 0));
                list[x][y].offerLast(new Node3(i, x, y, 1, 0));
            }

        }

        while(!q.isEmpty()) {
            Node3 node = q.poll();
            int x = node.x;
            int y = node.y;
            int dx = node.dx;
            int dy = node.dy;

            int nx = x + dx;
            int ny = y + dy;

            // 밖에 나갔을 경우
            boolean out = false;
            if(nx <= 0 || nx > N || ny <= 0 || ny > N) {
                dx = -dx;
                dy = -dy;
                nx = x;
                nx = y;
                out = true;
            }

            // 흰색
            if(graph[nx][ny] == 0 && !out) {
                while(!list[x][y].isEmpty()) {
                    list[nx][ny].offerLast(list[x][y].pollFirst());
                }
            }
            // 빨간색
            else if(graph[nx][ny] == 1) {

            }
            // 파란색
            else {
                if(out) {

                }
                else {

                }
            }
        }
    }
}
