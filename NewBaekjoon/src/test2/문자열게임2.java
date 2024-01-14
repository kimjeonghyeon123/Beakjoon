package test2;

/**
 * W : 알파벳 소문자 문자열
 * K : 양의 정수
 * 어떤 문자를 K개 포함하는 가장 짧은 연속 문자열의 길이
 * 어떤 문자를 K개 포함하고 문자열의 첫번째와 마지막 글자가 해당 문자로 같은
 * 가장 긴 연속 문자열의 길이
 *
 * d[i] = i번째 문자를 K개 포함하는 가장 짧은 길이
 */

import java.io.*;
import java.util.*;

public class 문자열게임2 {

    public static int T, K;
    public static String W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int f = 0; f < T; f++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            for(int i = 0; i < W.length(); i++) {
            }
        }
    }
}
