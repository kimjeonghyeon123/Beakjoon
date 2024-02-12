import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 광물캐기 {
    public static void main(String[] args) {
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        int[] picks2 = {0,1,1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        solution(picks2, minerals2);
        System.out.println(min);
    }

    // 다이아 0, 철 1, 돌 2
    public static int[][] score = {
            {1, 1,1},
            {5, 1,1},
            {25,5,1}
    };

    public static int n;
    public static int[] cpy_picks;
    public static String[] cpy_minerals;
    public static int[] order_picks;
    public static int min = Integer.MAX_VALUE;

    public static int solution(int[] picks, String[] minerals) {
        cpy_picks = picks.clone();
        cpy_minerals = minerals.clone();

        n = Arrays.stream(picks).sum();
        order_picks = new int[n];
        select_all_picks(0);
        return min;
    }

    public static void select_all_picks(int depth) {
        if(depth == n) {
            find_score();
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(cpy_picks[i] != 0) {
                cpy_picks[i] -= 1;
                order_picks[depth] = i;
                select_all_picks(depth+1);
                cpy_picks[i] += 1;
            }
        }
    }

    public static void find_score() {
        int now_score = 0;
        int index = 0;
        for(int i = 0; i < n; i++) {
            int now_pick = order_picks[i];

            boolean isfinish = false;
            for(int j = index; j < index + 5; j++) {
                if(j == cpy_minerals.length) {
                    isfinish = true;
                    break;
                }
                if(cpy_minerals[j].equals("diamond")) {
                    now_score += score[now_pick][0];
                }
                else if(cpy_minerals[j].equals("iron")) {
                    now_score += score[now_pick][1];
                }
                else {
                    now_score += score[now_pick][2];
                }
            }

            if(isfinish) {
                break;
            }
            index += 5;
        }

        min = Math.min(min, now_score);
    }
}
/**
 * 다이아몬드, 철, 돌, 각가 0~5개 가지고 있음
 * picks[0] = 다이아 곡괭이 수
 * picks[0] = 철 곡괭이 수
 * picks[0] = 돌 곡괭이 수
 * 최소 1개 이상
 *
 * 1, 2  2  2  2 1
 * adsf asf as fa sdaf das
 *
 */