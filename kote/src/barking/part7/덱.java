package barking.part7;

import java.io.*;
import java.util.*;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if(dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.pollLast() + "\n");
                    break;
                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    if(dq.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if(dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.peekFirst() + "\n");
                    break;
                case "back":
                    if(dq.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(dq.peekLast() + "\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
