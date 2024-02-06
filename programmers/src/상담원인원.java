import java.util.ArrayList;
import java.util.Queue;

public class 상담원인원 {
    public static void main(String[] args) {
        int k = 3;
        int n = 5;
        int[][] reqs = {
                {10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}
        };

        System.out.println(solution(k, n, reqs));

    }


    // 조합 리스트 뽑기
    public static int[] mento;


    public static int solution(int k, int n, int[][] reqs) {
        int answer = 0;

        mento = new int[k+1];

        return answer;
    }

    public static void find_combination(int sum, int depth, int k, int n) {
        if(depth == k+1) {
            return;
        }

        //i명 선택
        for(int i = 1; i <= n; i++) {
            mento[depth] = i;
            =GwpasoP[]ol find_combination(sum + i, depth+1, k, n);
        }
    }

    
}

/**
 * 멘토 n명
 * 1~k 상담 유형
 * 1,1,3
 * 1,2,2
 * 1,3,1
 * 각 멘토는 k개 상담 유형 중 하나만 가능
 * 동시에 참가자 한 명만 가능, 참가자가 요청한 시간만큼 걸림
 *
 * 참가자가 요청하면 상담 중이 아닌 담당 유형 멘토와 상담
 * 모두 상담 중이면 기다림
 * 참가자가 기다린 시간은 참가자가 상담 요청했을 때부터 시작할 때까지으 시간
 * 먼저 상담 요청한 참가자가 우선
 *
 * 기다린 시간의 합이 최소가 되도록 멘토 인우너 선정
 * 최소 시간 배출
 *
 * 유형     1     2    3
 * 10      1     0    0
 * 15      1     0    2
 * 20      1     0    2
 * 30      1     0    2
 * 50      1
 * 60      1
 * 70      1
 * 80
 */