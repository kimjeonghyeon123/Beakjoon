/**
 * 다리 위 n개 트럭 건넘
 * w 대의 트럭만 동시에 가능
 *
 * w = 다리의 길이
 * L = 다리의 최대하중
 * 트럭의 무게
 * 트럭은 1초에 1씩 움직일 수 있음
 * 트럭은 L 이하만큼만 올라갈 수 있음
 *
 * w=2, l=10
 * 7,4,5,6
 * - -
 * 7    1초
 *   7  2초
 * 4    3초
 * 5 4  4초
 *   5  5초
 * 6    6초
 *   6  7초
 *      8초
 * 다리 길이만큼 0을 넣어둬
 * 0 0 0 0 0 0 0
 * 빼면서 집어넣어
 * 0 0 0 0 0 0 0
 * while문 arr에서 순서대로 하나씩 뽑아
 * 다리 위에 있는 큐에 넣어
 * 큐에 넣으면서 0을 넣어
 *
 */

import java.io.*;
import java.util.*;

public class test10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            q.offer(0);
        }

        int sum = 0;
        int time = 0;
        while(!truck.isEmpty()) {
            // 다리에서 차 빼기
            sum -= q.poll();

            // 다리에 차 집어넣기
            // 다음 차 올라갈 때 무게 넘치면 0 집어넣음
            if(sum + truck.peek() > L) {
                q.offer(0);
            }
            // 다음 차 올라가도 무게 적당하면 truck 집어넣음
            else {
                int next = truck.poll();
                sum += next;
                q.offer(next);
            }
            time++;
        }

        System.out.println(time+w);
    }
}
