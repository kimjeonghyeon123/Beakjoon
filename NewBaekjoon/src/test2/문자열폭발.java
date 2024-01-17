package test2;

/**
 * 문자열이 폭발 문자열 포함하면 모든 폭발문자열이 폭발됨
 * 남은 문자열을 순서대로 이어 붙임
 */

import java.io.*;
import java.util.*;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombSize = bomb.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombSize) {
                boolean isSame = true;
                for(int j = 0; j < bombSize; j++) {
                    if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    for(int j = 0; j < bombSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb.reverse());
        }
    }
}
