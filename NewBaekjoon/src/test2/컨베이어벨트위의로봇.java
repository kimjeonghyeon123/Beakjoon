package test2;

/**
 * 컨베이어 벨트 길이 N
 * 벨트 길이 2N
 *
 * 1    2     3 4 5 ... N
 * 2N  2N-1 .......... N+1
 *
 * 1번 칸 : 올리는 위치
 * 2번 칸 : 내리는 위치
 *
 * 칸에 로봇이 로라가면 칸의 내구도가 1 감소
 *
 * n번 칸 : index, 내구도
 * 로봇이 칸을 이동하려면 이동하는 칸에 로봇이 없고 내구도가 1이상이어야 함
 * 가장 먼저 벨트에 올라간 로봇부터 한 칸 이동
 *
 * 1 2 1
 * 2 1 2
 *
 * 1초 후
 *
 * 2 1 2
 * 1 2 1
 *
 * 이렇게 돌아가는데
 * 회전시킴
 * 로봇 한칸 이동
 * 1번 칸 위에 내구도가 0이 아니면 로봇 올리고 내구도 1 깎기 내구도 1인 것이 0이 되면 cnt++
 *
 *
 */

import java.io.*;
import java.util.*;

public class 컨베이어벨트위의로봇 {

    public static class Node {
        int weight;
        boolean robot;
        public Node(int weight, boolean robot) {
            this.weight = weight;
            this.robot = robot;
        }
    }
    public static int N, K;
    public static Deque<Node> uq = new LinkedList<>();
    public static Deque<Node> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            uq.offerLast(new Node(Integer.parseInt(st.nextToken()), false));
        }
        for(int i = 0; i < N; i++) {
            dq.offerFirst(new Node(Integer.parseInt(st.nextToken()), false));
        }

        int time = 1;
        int cnt = 0;
        while(true) {
            // 벨트 이동
            dq.offerLast(uq.pollLast());
            uq.offerFirst(dq.pollFirst());

            if(uq.peekLast().robot) {
                uq.peekLast().robot = false;
            }

            for(int i = 0; i < N; i++) {
                if(i==N-1) {
                    uq.offerFirst(uq.pollLast());
                    break;
                }
                Node next = uq.pollLast();
                Node now = uq.peekLast();
                // 출발할 로봇이 있고, 도착할 곳에 로봇이 없고 내구도가 0 이상일 때
                if(now.robot && !next.robot && next.weight >= 1) {
                    next.weight--;
                    if(next.weight == 0) {
                        cnt++;
                    }
                    next.robot = true;
                    now.robot = false;
                }
                uq.offerFirst(next);
            }

            if(uq.peekLast().robot) {
                uq.peekLast().robot = false;
            }

            Node start = uq.peekFirst();
            if(start.weight >= 1) {
                start.weight--;
                start.robot = true;
                if(start.weight == 0) {
                    cnt++;
                }
            }

            if(cnt >= K) { break; }
            time++;
        }

        System.out.println(time);
    }
}
