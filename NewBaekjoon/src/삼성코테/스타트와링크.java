package 삼성코테;

import java.io.*;
import java.util.*;

public class 스타트와링크 {
    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[][] graph;
    public static int[] team1, team2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        team1 = new int[N/2];
        team2 = new int[N/2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team1[0] = 0;
        dfs(0, 1);
        System.out.println(min);
    }

    public static void dfs(int start, int depth) {
        if(depth == N/2) {
            cha();
            return;
        }

        for(int i = start+1; i < N; i++) {
            team1[depth] = i;
            dfs(i,depth + 1);
        }
    }

    /**
     * 8
     * team1 = [0,1,2,3]
     * team2 = [
     */
    public static void cha() {
        int depth = 0;
        for(int i = 0; i < N; i++) {
            boolean hasnum = false;
            for(int j = 0; j < N/2; j++) {
                if(team1[j] == i) {
                    hasnum = true;
                    break;
                }
            }
            if(!hasnum) {
                team2[depth] = i;
                depth++;
            }
        }
        int score1 = 0;
        int score2 = 0;
        for(int i = 0; i < N/2; i++) {
            for(int j = 0; j < N/2; j++) {
                score1 += graph[team1[i]][team1[j]];
                score2 += graph[team2[i]][team2[j]];
            }
        }

        min = Math.min(min, Math.abs(score1 - score2));
    }
}
/**
 * 총 N명
 * 스타트 팀 : N/2
 * 링크 팀   : N/2
 *
 * i번 사람과 j번 사람이 같은 팀에 속했을 때 팀에 더해지는 능력치
 *
 * 1과 2가 같은 팀
 * = S12 + S21
 *
 * 두 팀의 능력치 차이 최소
 */