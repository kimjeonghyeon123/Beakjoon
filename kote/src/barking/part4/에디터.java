package barking.part4;

import java.io.*;
import java.util.*;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        //문자열 리스트에 넣기
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // iterator 호출
        ListIterator<Character> iter = list.listIterator();
        // 맨 뒤로 커서 이동
        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);
                    break;
            }
        }

        for(Character c : list) {
            bw.write(c);
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
