import java.util.ArrayList;
import java.util.Arrays;

public class 광물캐기 {
    public static void main(String[] args) {
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        solution(picks, minerals);
        System.out.println(min);
    }

    public static int n;
    public static ArrayList<int[]> order_list = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static int solution(int[] picks, String[] minerals) {

        n = (minerals.length % 5 == 0) ? minerals.length / 5 : minerals.length / 5 + 1;
        find_all_order(0, picks, new int[n]);

        for(int[] arr : order_list) {
            find_pirodo(arr, minerals);
        }

        return min;
    }

    public static void find_all_order(int depth, int[] picks, int[] order) {
        if(depth == n) {
            order_list.add(order);
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(picks[i] != 0) {
                picks[i] -= 1;
                order[depth] = i;
                find_all_order(depth+1, picks, order);
                picks[i] += 1;
            }
        }
    }

    public static void find_pirodo(int[] order, String[] minerals) {
        int pirodo = 0;
        int index = 0;
        boolean finish = false;
        for(int i = 0; i < order.length; i++) {
            for(int j = index; j < index + 5; j++) {
                if(j == minerals.length) {
                    finish = true;
                    break;
                }

                if(order[i] == 0) {
                    pirodo += 1;
                }
                else if(order[i] == 1) {
                    if(minerals[j].equals("diamond")) {pirodo += 5;}
                    else {pirodo += 1;}
                }
                else {
                    if(minerals[j].equals("diamond")) {pirodo += 25;}
                    else if(minerals[j].equals("iron")) {pirodo += 5;}
                    else {pirodo += 1;}
                }
            }
            if(finish) {
                break;
            }
            index += 5;
        }

        min = Math.min(min, pirodo);
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