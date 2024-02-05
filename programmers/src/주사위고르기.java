import java.util.*;

public class 주사위고르기 {
    public static int n;
    public static boolean[] visited;
    public static ArrayList<int[]> diceList;
    public static ArrayList<Integer> scoreA;
    public static ArrayList<Integer> scoreB;

    public static void main(String[] args) {
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };
        n = dice.length;
        visited = new boolean[n];
        diceList = new ArrayList<>();
        find_every_dice_combination(-1, 0, new int[n]);

        int max = 0;
        for(int t = 0; t < diceList.size(); t++) {
            int[] dice_combination = diceList.get(t);

            scoreA = new ArrayList<>();
            scoreB = new ArrayList<>();
            find_every_socre(0,0,0,dice_combination, dice);

            Collections.sort(scoreA);
            Collections.sort(scoreB);

            int total_win_count = 0;
            for(int i = 0; i < scoreA.size(); i++) {
                int left = 0;
                int right = scoreB.size();

                while(left + 1 < right) {
                    int mid = (left + right) / 2;
                    if(scoreA.get(i) > scoreB.get(mid)) {
                        left = mid;
                    }
                    else {
                        right = mid;
                    }

                    total_win_count += left;
                }

                if(total_win_count > max) {
                    max = total_win_count;
                }
            }
        }
        System.out.println(max);
    }

    public static void find_every_socre(int sumA, int sumB, int depth, int[] dice_combination, int[][] dice) {
        if(depth == n/2) {
            scoreA.add(sumA);
        }
        if(depth == n) {
            scoreB.add(sumB);
            return;
        }

        for(int i = 0; i < 6; i++ ) {
            if(depth < n/2) {
                find_every_socre(sumA+dice[depth][i], sumB, depth+1,dice_combination, dice);
            }
            else {
                find_every_socre(sumA, sumB+dice[depth][i], depth+1,dice_combination, dice);
            }
        }
    }


    public static void find_every_dice_combination(int start, int depth, int[] dice_combination) {
        if(depth == n/2) {
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    dice_combination[depth++] = i;
                }
            }
            diceList.add(dice_combination.clone());
            return;
        }

        for(int i = start+1; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dice_combination[depth] = i;
                find_every_dice_combination(i, depth+1, dice_combination);
                visited[i] = false;
            }
        }
    }

}