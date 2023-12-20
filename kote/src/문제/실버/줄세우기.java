package 문제.실버;

/**
 * 키 순서로 20명 매김
 * 같은 키 없음
 * 한 명 뽑아 맨 앞에 세워
 * 나보다 크면 뒤에 작으면 앞에 세움
 *
 */

import java.io.*;
import java.util.*;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken()).append(" ");

            LinkedList<Integer> list = new LinkedList<>();

            int cnt = 0;
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
            for(int j = 1; j < 20; j++) {
                x = Integer.parseInt(st.nextToken());
                boolean isAdd = false;
                for(int k = 0; k < j; k++) {
                    if(x < list.get(k)) {
                        list.add(k, x);
                        cnt += (j - k);
                        isAdd = true;
                        break;
                    }
                }
                if(!isAdd) {
                    list.add(x);
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
