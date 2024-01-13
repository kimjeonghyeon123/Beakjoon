package test2;

/**
 * A와 B로만 이루어진 영어 단어
 *
 * 문자열 S를 T로 바꾸는 게임
 * 1) 문자열의 뒤에 A를 추가하거나
 * 2) 문자열의 뒤에 B를 추가하고 문자열 뒤집기
 *
 * s를 t로 바꿀 수 있는지
 *
 * S : A
 * T : BABA
 *
 * [1]
 * 1) A 추가하기
 * AA
 * 2) B 추가하기
 * AB -> BA
 *
 * [2]
 * 1) A 추가하기
 * AAA, BAA
 * 2) B 추가하기
 * AAB -> BAA,  BAB -> BAB
 *
 * [3]
 * 1) A 추가하기
 * AAAA BAAA BAAA BABA
 * 2) B 추가하기
 * BAAA BAAB BAAB BBAB
 *
 * [큐에 넣고 뺄까?]
 *
 * dfs(char c, boolean reverse)
 * AAAA
 * AAAAA
 * BAAAA
 *
 * A
 * BABAA
 * BABA -> A 붙임
 * AABA -> B 붙임
 */

import java.io.*;
import java.util.*;

public class A와B2 {

    public static String S, T;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        sb.append(T);
        dfs();

        System.out.println(0);
    }

/**
 * 두가지 경우의 수가 있음
 * 끝이 A인 경우
 * 앞이 A면 A 붙인 거
 * 앞이 B면 A 붙인 거 or B 붙인 거
 * 끝이 B인 경우
 * 앞이 A면 불가능
 * 앞이 B면 가능
*/
    public static void dfs() {
        if(sb.length() == S.length()) {
            if(sb.toString().equals(S)) {
                System.out.println("1");
                System.exit(0);
            }
            return;
        }

        String str = sb.toString();
        boolean start = str.startsWith("A");
        boolean end = str.endsWith("A");
        // A로 시작 A로 끝
        if(start && end) {
            sb.deleteCharAt(sb.length() - 1);
            dfs();
            sb.append('A');
        }
        // B로 시작 A로 끝
        else if(!start && end){
            sb.deleteCharAt(sb.length() - 1);
            dfs();
            sb.append('A');

            sb.deleteCharAt(0);
            sb.reverse();
            dfs();
            sb.append('B');
            sb.reverse();
        }
        //B로 시작 B로 끝
        else if(!start && !end) {
            sb.deleteCharAt(0);
            sb.reverse();
            dfs();
            sb.append('B');
            sb.reverse();
        }
        else {
            return;
        }
    }
}
