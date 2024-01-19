package test3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 모든 작업은 중요도를 갖고 있음
 *
 * 다른 분류 중 작업의 중요도 합이 가장 높은 분류를 선택해 처리
 *
 * 1순위 : 요청시각
 * 2순위 : 같은 분류번호가 그동안 요청된게 있으면 그거 연속으로 처리하기
 * 3순위 : 분류 번호가 같은 것들의 중요도 합을 구한다음 비교
 *          - 같을 경우
 *              - 분류번호가 낮은 것
 *     하는일 쌓인 일
 * 1 : 1번
 * 2 : 1번   2번
 * 3 : 1번   2번 3번
 * 4 : 1번   2번 3번
 * 5 : 1번   2번 3번 4번
 * 6 : 1번   2번 3번 4번
 *
 * 8
 */

public class 코테3 {
    public static void main(String[] args) {
        // jobs[][0] : 요청시각
        // jobs[][1] : 작업시간
        // jobs[][2] : 분류번호
        // jobs[][3] : 중요도
        int[][] jobs = {
                {1,5,2,3},
                {2,2,3,2},
                {3,1,3,3},
                {5,2,1,5},
                {7,1,1,1},
                {9,1,1,1},
                {10,2,2,9}
        };

        Queue<Node> q = new LinkedList();
        boolean[] iswork = new boolean[jobs.length];
        int t = 1;

        q.offer(new Node(jobs[0][0], jobs[0][1], jobs[0][2], jobs[0][3]));
        iswork[0] = true;
        //작업 + 걸리는 시간 동안 2,3,5를 넣어
        while(true) {
            Node node = q.poll();
            int time = t + node.wtime;
            for(int i = 0; i < jobs.length; i++) {
                if(!iswork[i] && jobs[i][0] < time) {
                    iswork[i] = true;

                }
            }
        }
    }

    public static class Node {
        int rtime, wtime, num, important;
        public Node(int rtime, int wtime, int num, int important) {
            this.rtime = rtime;
            this.wtime = wtime;
            this.num = num;
            this.important = important;
        }
    }
}
