package test4;

/**
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성
 * 최소 한 개의 모음 : (a,e,i,o,u)
 * 최소 두 개의 자음 : 나머지
 * 알파벳순
 * 문자의 종류는 C가지
 * 알파벳 줄 테니 가능성 있는 암호 모두 구해
 *
 * a t c i s w
 *
 */

import java.io.*;
import java.util.*;

public class 암호만들기 {

    public static int L, C;
    public static char[] arr;
    public static char[] mo = {'a', 'e', 'i', 'o', 'u'};
    public static boolean[] visited;
    public static char[] result;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        result = new char[L];
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        for(int i = 0; i < C - L + 1; i++) {
            result[0] = arr[i];
            dfs(i, 0);
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int index, int depth) {
        if(depth == L-1) {
            if(password()) {
                for(char c : result) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = index+1; i < C; i++) {
            result[depth+1] = arr[i];
            dfs(i, depth+1);
        }
    }

    public static boolean password() {
        int mcnt = 0;
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < 5; j++) {
                if(result[i] == mo[j]) {
                    mcnt++;
                    break;
                }
            }
        }
        if(mcnt >= 1 && L-mcnt >= 2) {
            return true;
        }
        return false;
    }
}
