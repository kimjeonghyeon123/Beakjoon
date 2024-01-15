package test2;

import java.io.*;
import java.util.*;

public class 틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            /*
            1) x의 개수가 o의 개수보다 1 많거나 같아야함
            2) x가 3개 연결되어 있는데 O도 3개 연결되어 있으면 안됨
            X 이면 이어있는지 검사 몇개인지 세
             */

            int xcnt = 0;
            int ocnt = 0;
            int i = 0;
            while (i <= 9) {
                if (str.charAt(i) == 'X') {
                    while (i == str.charAt(i)) {
                        xcnt++;
                        i++;
                    }
                } else {
                    ocnt++;
                }
            }
        }
            if(xcnt < ocnt) {
                sb.append("invalid").append("\n");
                continue;
            }

        }

        System.out.println(sb.toString());
    }
}
