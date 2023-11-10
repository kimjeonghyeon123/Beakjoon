package barking.part7;

import java.io.*;
import java.util.*;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] commands = br.readLine().split("");
            int len = Integer.parseInt(br.readLine());
            String[] str = br.readLine().replace("[", "").replace("]", "").split(",");
            LinkedList<Integer> dq = new LinkedList<>();
            for(int j = 0; j < len; j++) {
                dq.offerLast(Integer.parseInt(str[j]));
            }

            boolean reverse = false;
            boolean err = false;
            for(int j = 0; j < commands.length; j++) {
                switch(commands[j]) {
                    case "R":
                        if(reverse) {
                            reverse = false;
                        } else {
                            reverse = true;
                        }
                        break;
                    case "D":
                        if(dq.isEmpty()) {
                            err = true;
                        }
                        else {
                            if(reverse) {
                                dq.pollLast();
                            } else {
                                dq.pollFirst();
                            }
                        }
                        break;
                }
                if(err) {
                    break;
                }
            }


            if(err) {
                sb.append("error\n");
            }
            else {
                sb.append("[");
                if(reverse) {
                    while(true) {
                        sb.append(dq.pollLast() + ",");
                        if (dq.size() == 1) {
                            sb.append(dq.pollLast() + "]\n");
                            break;
                        }
                    }
                } else {
                    while(true) {
                        sb.append(dq.pollFirst() + ",");
                        if (dq.size() == 1) {
                            sb.append(dq.pollFirst() + "]\n");
                            break;
                        }
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
