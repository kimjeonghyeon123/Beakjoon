package 삼성코테;

import java.io.*;
import java.util.*;

public class 퇴사 {
    public static class Node{
        int days, pay;
        public Node(int days, int pay) {
            this.days = days;
            this.pay = pay;
        }
    }
    public static int N;
    public static Node[] schedule;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        schedule = new Node[N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            schedule[i] = new Node(days, pay);
        }

        for(int i = 1; i <= N; i++) {
            dfs(i, 0);
        }

        System.out.println(max);
    }

    // day날 일을 하는 경우
    // total은 그 전까지의 페이합
    public static void dfs(int day, int total) {
        // 다음 일을 할 수 있는 날
        int nextday = day + schedule[day].days;

        // 날짜를 벗어나면 못함
        if(nextday > N+1) {
            max = Math.max(max, total);
            return;
        }

        total += schedule[day].pay;
        if(nextday == N+1) {
            max = Math.max(max, total);
            return;
        }

        // 다음 날짜 이후의 날짜에 대해서 계산
        for(int i = nextday; i <= N; i++) {
            dfs(i, total);
        }
    }
}
/**
 * 1일 차 : 3일 걸림 4일부터 일 가능     i일 -> T(i) 걸림  canwork[i],...canwork[1+T(i)-1] = false
 * 2일 차 : 5일 걸림 7일부터 일 가능
 * 6일 차 : 2일 걸림 8일부터 일 가능 -> 불가능임
 *
 * 최대 금액을 구해라
 */