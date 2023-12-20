package 문제.브론즈;

/**
 * 대소문자로 된 단어, 가장 많이 사용된 알파벳 구하기
 * 소문자로 만듦
 * 알파벳 배열 만들어서 카운트
 */

import java.io.*;
import java.util.*;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = 'Z' - 'A' + 1;
        int[] arr = new int[len];

        str = str.toUpperCase();

        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        int max = 0;
        int count = 1;
        int j = 0;
        for(int i = 0; i < len; i++) {
            if(max < arr[i]) {
                max = arr[i];
                j = i;
                count = 1;
            }
            else if(max == arr[i]) {
                count++;
            }
        }

        if(count == 1) {
            System.out.println((char)('A' + j));
        }
        else {
            System.out.println("?");
        }
    }
}
