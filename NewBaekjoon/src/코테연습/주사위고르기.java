package 코테연습;

import java.util.Arrays;

public class 주사위고르기 {
//    public static int[][] dice = {
//            {1,2,3,4,5,6},
//            {2, 2, 4, 4, 6, 6},
//    };
    public static int[][] dice = {
            {40, 41, 42, 43, 44, 45},
            {43, 43, 42, 42, 41, 41},
            {1, 1, 80, 80, 80, 80},
            {70, 70, 1, 1, 70, 70},
    };
//    public static int[][] dice = {
//            {1,2,3,4,5,6},
//            {3,3,3,3,4,4},
//            {1,3,3,4,4,4},
//            {1,1,4,4,5,5},
//    };
    public static int N, total_cnt, winning_cnt;
    public static int[] dice_order;
    public static boolean[] selected;
    public static int[] winning_dice;
    public static double max = 0;

    public static void main(String[] args) {
        N = dice.length;
        dice_order = new int[N];
        selected = new boolean[N];
        winning_dice = new int[N/2];

        select_dice(-1, 0);

        Arrays.sort(winning_dice);
        for(int i = 0; i < N/2; i++) {
            winning_dice[i]++;
        }

        for (int i : winning_dice) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void select_dice(int start, int depth) {
        if(depth == N/2) {
            int index = N/2;
            for(int i = 0; i < N; i++) {
                if(!selected[i]) {
                    dice_order[index] = i;
                    index++;
                }
            }
            total_cnt = 0;
            winning_cnt = 0;
            dice_score(0, 0);
            double winning_rate = (double) winning_cnt / total_cnt;
            if(max < winning_rate) {
                max = winning_rate;
                for(int i = 0; i < N/2; i++) {
                    winning_dice[i] = dice_order[i];
                }
            }
            return;
        }

        for(int i = start+1; i < N; i++) {
            selected[i] = true;
            dice_order[depth] = i;
            select_dice(i, depth+1);
            selected[i] = false;
        }
    }

    public static void dice_score(int cha, int depth) {
        if(depth == N) {
            total_cnt++;
            if(cha > 0) {
                winning_cnt++;
            }
            return;
        }

        int dice_num = dice_order[depth];
        for(int i = 0; i < 6; i++) {
            if(depth < N/2) {
                dice_score(cha + dice[dice_num][i], depth+1);
            }
            else {
                dice_score(cha - dice[dice_num][i], depth+1);
            }
        }
    }
}
