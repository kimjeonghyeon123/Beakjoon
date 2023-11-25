/*
    누가 선물 많이 받을지 예측

    두 사람 선물 기록 있으면 -> 이번달까지 누가 더 많이 준 사람이 다음달에 선물 하나 더 받음

    기록이 하나도 없거나 같다면 -> 선물 지수가 더 큰 사람이 작은 사람에게 하나 더 받음

    선물 지수도 같다면 -> 주고받지 않음
 */

import java.util.ArrayList;
import java.util.StringTokenizer;

public class kote1 {
    public static void main(String[] args) {
        String[] friends = {};
        String[] gifts = {};

        int n = friends.length;
        int[][] graph = new int[n][n];

        for(int i = 0; i < gifts.length; i++) {
            String[] givetake = gifts[i].split(" ");
            int x = 0;
            for(int j = 0; j < friends.length; j++) {
                if(friends[j].equals(givetake[0])) {
                    x = j;
                    break;
                }
            }
            int y = 0;
            for(int j = 0; j < friends.length; j++) {
                if(friends[j].equals(givetake[1])) {
                    y = j;
                    break;
                }
            }
            graph[x][y]++;
        }

        int[][] ngraph = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ngraph[i][0] += graph[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ngraph[i][1] += graph[j][i];
            }
        }
        for(int i = 0; i < n; i++) {
            ngraph[i][2] = ngraph[i][0] - ngraph[i][1];
        }
    }
}
