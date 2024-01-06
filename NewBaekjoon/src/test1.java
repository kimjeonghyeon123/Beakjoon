/**
 * MooTube에 1~N 번호가 붙여진 동영상을 올려놓음
 * 연관 동영상 리스트 만들기
 * N-1 개의 동영상 쌍을 골라서 직접 유사도 계산
 * 유사도를 최솟값
 * 유사도가 K 이상인 모든 영상 추천
 * (1,2) = 3
 * (2,3) = 2
 * (2,4) = 4
 * (a, b) = ?
 * 1) (a,b) = Math.min((k, b), (a, b))  k는 1~N까지
 *      - (a,k) or (k,a) 조사해서 값이 있는지 조사
 */

import java.io.*;
import java.util.*;

class Node {
    int index, distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            visited[v] = true;
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(v, 0));

            int ans = 0;
            while(!q.isEmpty()) {
                Node now = q.poll();
                for(Node next : graph[now.index]) {
                    if(!visited[next.index] && next.distance >= k) {
                        q.offer(next);
                        visited[next.index] = true;
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}




















