package barking.part4;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class 에디터스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        //문자열 왼쪽스택에 넣기, 오른쪽 스택에 넣기
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            lStack.push(str.charAt(i));
        }

        // 0 1 2 3 4
        // a b c d e

        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (!lStack.isEmpty())
                        rStack.push(lStack.pop());
                    break;
                case 'D':
                    if (!rStack.isEmpty())
                        lStack.push(rStack.pop());
                    break;
                case 'B':
                    if(!lStack.isEmpty()) {
                        lStack.pop();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    lStack.push(t);
                    break;
            }
        }
        while(!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }

        while(!rStack.isEmpty()) {
            bw.write(rStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
