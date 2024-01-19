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
        int hp;
        int weight;
        public Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }
    }
    public static int N;
    public static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(hp, weight);
        }


    }

    public static void dfs(int x) {
        if(x == N-1) {
            return;
        }
        if(eggs[x].hp <= 0) {
            dfs(x+1);
        }
        boolean isbroke = false;
        for(int i = x+1; i < N; i++) {
            if(eggs[i].hp > 0) {
                isbroke = true;
                int temp1 = eggs[x].hp;
                int temp2 = eggs[i].hp;
                eggs[x].hp -= eggs[i].weight;
                eggs[i].hp -= eggs[x].weight;
                dfs(i);
                eggs[x].hp = temp1;
                eggs[i].hp = temp2;
            }
        }
        if(!isbroke) {

        }
    }
}
