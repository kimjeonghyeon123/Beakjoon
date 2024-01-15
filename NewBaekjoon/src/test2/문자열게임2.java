package test2;

/**
 * W : 알파벳 소문자 문자열
 * K : 양의 정수
 * 어떤 문자를 K개 포함하는 가장 짧은 연속 문자열의 길이
 * 어떤 문자를 K개 포함하고 문자열의 첫번째와 마지막 글자가 해당 문자로 같은
 * 가장 긴 연속 문자열의 길이
 *
 * d[i] = i번째 문자를 K개 포함하는 가장 짧은 길이
 * superaquatornado 2
 * d[0] = s를 2개 이상 포함하고 있는 가장 짧은 문장의 길이 1~len-1 s가 나오면 인덱스 저장 후 break
 *
 *
 */

import java.io.*;
import java.util.*;

public class 문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int f = 0; f < T; f++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] alpha = new int[26];

            for(int i = 0; i < W.length(); i++) {
                alpha[W.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < W.length(); i++) {
                if(alpha[W.charAt(i) - 'a'] < K) {continue;}

                int cnt = 0;
                for(int j = i; j < W.length(); j++) {
                    if(W.charAt(i) == W.charAt(j)) {
                        cnt++;
                        if(cnt == K) {
                            min = Math.min(min, j-i+1);
                            max = Math.max(max, j-i+1);
                            break;
                        }
                    }
                }
            }
            if(min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            }
            else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}

