package 문제.실버;

import java.io.*;
import java.util.*;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if(cmd.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("check")) {
                if(set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if(cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) {
                    set.remove(x);
                }
                else {
                    set.add(x);
                }
            }
            else if(cmd.equals("all")) {
                for(int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }
            else if(cmd.equals("empty")) {
                set.clear();
            }
        }

        System.out.println(sb.toString());
    }
}
