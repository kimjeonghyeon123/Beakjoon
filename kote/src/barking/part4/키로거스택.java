package barking.part4;

import java.io.*;
import java.util.*;

public class 키로거스택 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < L; i++) {
            String str = br.readLine();

            Stack<Character> lstack = new Stack<>();
            Stack<Character> rstack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<':
                        if(!lstack.isEmpty()) {
                            rstack.push(lstack.pop());
                        }
                        break;
                    case '>':
                        if(!rstack.isEmpty()) {
                            lstack.push(rstack.pop());
                        }
                        break;
                    case '-':
                        if(!lstack.isEmpty()) {
                            lstack.pop();
                        }
                        break;
                    default:
                        lstack.push(c);
                        break;
                }
            }

            while(!lstack.isEmpty()) {
                rstack.push(lstack.pop());
            }
            while(!rstack.isEmpty()) {
                sb.append(rstack.pop());
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
