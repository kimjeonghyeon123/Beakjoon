package 코테공부.구현;

import java.io.*;
import java.util.*;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if(t >= '0' && t <= '9') {
                sum += (t - '0');
                continue;
            }
            list.add(t);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        if(sum != 0) {
            sb.append(sum);
        }
        System.out.println(sb.toString());
    }
}
