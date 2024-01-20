package test4;

/**
 * 틀린 제출마다 턱걸이 5회
 *
 * 계란 : 내구도, 무게
 * 둘이 부딪히면 상대 계란의 무게만큼 내구도가 깎임
 * 내구도가 0이 되면 계란이 깨짐
 *
 * 1. 가장 왼쪽 계란을 듦
 * 2. 손에 든 계란으로 다른 계란 중 하나를 침
 * 3. 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 손에 든계란을 원래 자리에 내려놓음
 * 4. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 들고 2번 과정을 반복
 *
 *
 */

import java.io.*;
import java.util.*;

public class 계란으로계란치기 {
    public static class Egg {
        int s, w;
        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    public static int N;
    public static Egg[] eggs;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }

        dfs(0);
        System.out.println(max);
    }

    // x 계란 차례
    public static void dfs(int x) {
        if(x == N) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                if(eggs[i].s <= 0) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        Egg egg_in_hand = eggs[x];
        // 손에 든 계란이 부셔져 있는 경우
        if(egg_in_hand.s <= 0) {
            dfs(x+1);
            return;
        }

        // 다음 계란을 치자
        // i번째 계란을 친 경우
        boolean everyeggisbroke = true;
        for(int i = 0; i < N; i++) {
            if(i == x) {continue;}
            Egg egg_next = eggs[i];
            if(egg_next.s > 0) {
                everyeggisbroke = false;
                int egg_in_hand_s = egg_in_hand.s;
                int egg_next_s = egg_next.s;
                egg_in_hand.s -= egg_next.w;
                egg_next.s -= egg_in_hand.w;
                dfs(x+1);
                egg_in_hand.s = egg_in_hand_s;
                egg_next.s = egg_next_s;
            }
        }
        if(everyeggisbroke) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                if(eggs[i].s <= 0) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }
    }
}
