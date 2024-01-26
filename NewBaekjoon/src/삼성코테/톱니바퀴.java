package 삼성코테;

import java.io.*;
import java.util.*;

public class 톱니바퀴 {
    public static class Node {
        int wheelnum, direction;
        public Node(int wheelnum, int direction) {
            this.wheelnum = wheelnum;
            this.direction = direction;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<Character>[] wheels = new LinkedList[5];
        for(int i = 1; i < 5; i++) {
            String str = br.readLine();
            wheels[i] = new LinkedList<>();
            for(int j = 0; j < 8; j++) {
                wheels[i].add(str.charAt(j));
            }
        }

        int K = Integer.parseInt(br.readLine());
        Node[] cmd = new Node[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cmd[i] = new Node(a, b);
        }

        for(int i = 0; i < K; i++) {
            boolean[] isCircle = new boolean[5];
            Queue<Node> q = new LinkedList<>();
            q.offer(cmd[i]);

            while(!q.isEmpty()) {
                Node wheel = q.poll();
                int wheelnum = wheel.wheelnum;
                int dir = wheel.direction;

                int left = wheels[wheelnum].get(6);
                int right = wheels[wheelnum].get(2);

                if(dir == 1) {
                    wheels[wheelnum].offerFirst(wheels[wheelnum].pollLast());
                }
                else {
                    wheels[wheelnum].offerLast(wheels[wheelnum].pollFirst());
                }
                isCircle[wheelnum] = true;

                if(wheelnum - 1 >= 1 && !isCircle[wheelnum-1]) {
                    if(left != wheels[wheelnum-1].get(2)) {
                        q.offer(new Node(wheelnum-1, -dir));
                    }
                }
                if(wheelnum + 1 <= 4 && !isCircle[wheelnum+1]) {
                    if(right != wheels[wheelnum+1].get(6)) {
                        q.offer(new Node(wheelnum+1, -dir));
                    }
                }
            }
        }

        int result = 0;
        if(wheels[1].get(0) == '1') {
            result += 1;
        }
        if(wheels[2].get(0) == '1') {
            result += 2;
        }
        if(wheels[3].get(0) == '1') {
            result += 4;
        }
        if(wheels[4].get(0) == '1') {
            result += 8;
        }
        System.out.println(result);
    }
}
/**
 * 8개 톱니를 가진 톱니바퀴 4개
 * 1 2 3 4
 *
 * 12시방향
 *
 * 0,1,2,3,4,5,6,7
 *
 * 0,1,2  3,4,5,6,7
 * 2번이 오른쪽 6번이 왼쪽 맞닿는 부분
 * 오른쪽으로 돌면 pollLast해서 offerFirst해야됨
 * 오른쪽으로 회전하면
 * 서로 극이 다르면 반대방향으로 회전함
 * 서로 극이 같으면 회전안함
 *
 */
