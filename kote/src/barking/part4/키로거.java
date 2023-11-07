package barking.part4;

import java.io.*;
import java.util.*;

public class 키로거 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());


        for (int i = 0; i < L; i++) {
            String str = br.readLine();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }

            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
