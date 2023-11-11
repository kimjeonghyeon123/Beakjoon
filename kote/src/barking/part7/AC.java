package barking.part7;

import java.io.*;
import java.util.*;

public class AC {

    static Deque<Integer> dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int len = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (st.hasMoreTokens()) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }

            AC(commands);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void AC(String commands) {

        boolean reverse = false;
        for(int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'R') {
                reverse = !reverse;
                continue;
            }

            if(reverse) {
                if(dq.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else {
                if(dq.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(reverse);
    }

    static void makePrintString(boolean reverse) {
        sb.append("[");

        if(!dq.isEmpty()) {
            if(reverse) {
                sb.append(dq.pollLast());

                while(!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }
            }
            else {
                sb.append(dq.pollFirst());

                while(!dq.isEmpty()) {
                    sb.append(",").append(dq.pollFirst());
                }
            }
        }

        sb.append("]\n");
    }
}
