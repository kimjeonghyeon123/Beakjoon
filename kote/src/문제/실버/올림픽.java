package 문제.실버;

/**
 * 순위
 * 1. 금메달 많은 나라
 * 2. 금메달 같으면 은메달 많은 나라
 * 3. 금,은 같으면 동메달 많은 나라
 * 4. 전부 같으면 같은 등수 ex) 2등이 2명일 경우 다음 등수는 4등
 * K 국가의 등수를 구하시오
 *
 * 먼저 정렬해야 됨
 * 넣을 때 안에 있는 거랑 비교해서 제 위치 찾아가게 해야됨
 */

import java.io.*;
import java.util.*;

class Medal {
    int num, gCnt, sCnt, bCnt;

    public Medal(int num, int gCnt, int sCnt, int bCnt) {
        this.num = num;
        this.gCnt = gCnt;
        this.sCnt = sCnt;
        this.bCnt = bCnt;
    }
}

public class 올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

    }
}
