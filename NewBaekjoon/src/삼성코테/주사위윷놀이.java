package 삼성코테;

import java.io.*;
import java.util.*;

public class 주사위윷놀이 {
    public static int [] map = {
            0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0,//0~21
            10,13,16,19,25,30,35,40,0,//22~30
            20,22,24,25,30,35,40,0,//31~38
            30,28,27,26,25,30,35,40,0//39~47
    };
    public static int max = Integer.MIN_VALUE;
    public static int[] dice = new int[10];
    public static int[] gamePiece = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(max);
    }

    public static void permutation(int cnt) {
        if(cnt == 10) {
            play_game();
            return;
        }

        for(int i = 0; i < 4; i++) {
            gamePiece[cnt] = i;
            permutation(cnt+1);
        }
    }

    public static void play_game() {
        boolean[] visited = new boolean[map.length];
        int score = 0;
        int[] p = new int[4];

        for(int i = 0; i < 10; i++) {
            int nowDice = dice[0];
            int nowPiece = gamePiece[i];

            if(isFinish(p[nowPiece])) return;

            int next = nextPoint(p[nowPiece], nowDice);


        }
    }

    public static void setVisited(boolean[] visited, int idx, boolean check) {
        if(idx == 20 || idx == 29 || idx == 37 || idx ==46){

        }
    }

    public static int nextPoint(int nowIdx, int dice) {
        int nextIdx = nowIdx + dice;

        if(nowIdx < 21) {
            if(nextIdx >= 21) nextIdx = 21;
        }
        else if(nowIdx < 30) {
            if(nextIdx >= 30) nextIdx = 30;
        }
        else if(nowIdx < 38) {
            if(nextIdx >= 38) nextIdx = 38;
        }
        else if(nowIdx < 47) {
            if(nextIdx >= 47) nextIdx = 47;
        }

        if (nowIdx == 5) return 22;
        if (nowIdx == 10) return 31;
        if (nowIdx == 15) return 39;
        return nextIdx;
    }
    public static boolean isFinish(int idx) {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47;
    }
}
/**
 * 시작 칸에 말 4개 있음
 * 말
 * 파란색 칸에서 이동하면 파란색 화살표대로 가야됨
 * 빨간색 칸에서 이동하면 빨간색 화살표대로 이동
 *
 * 총 10 개의 턴
 * 1~5까지 한 면에 하나씩 적혀있는 주사위 굴리기
 * 도착 칸에 있지 않은 말 하나 골라 주사위만큼 이동
 *
 * 말이 이동을 마치는 칸에 다른 말이 있으면 다른 말이 있으면 그 말 선택 불가능
 * 주사위에서 나온 ㅁ
 *
 *
 */