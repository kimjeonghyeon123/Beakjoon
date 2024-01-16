package test2;

/**
 *
 */

import java.io.*;
import java.util.*;

public class 영만들기 {

    public static int N;
    public static List<String> ans;
    public static String[] op = {"+", "-", " "};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(ans);
            for(String s : ans) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int num, String s) {
        if(num == N) {
            String express = s.replaceAll(" ", "");
            if(cal(express))
                ans.add(s);
            return;
        }

        for(int i = 0; i < 3; i++) {
            dfs(num+1, s+op[i]+Integer.toString(num+1));
        }
    }

    public static boolean cal(String express) {
        StringTokenizer st = new StringTokenizer(express, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            }
            else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        if(sum == 0) {
            return true;
        }
        return false;
    }
}
