package 동빈나.Implementation;

import java.io.*;
import java.util.*;

public class Implementation4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        ArrayList<Character> arrList = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < str.length; i++) {
            char c = str[i].charAt(0);
            if (c >= 'A' && c <= 'Z') {
                arrList.add(c);
            }
            else {
                sum += Integer.parseInt(str[i]);
            }
        }
        Collections.sort(arrList);

        for(char c : arrList) {
            bw.write(c);
        }
        if(sum != 0) {
            bw.write(String.valueOf(sum));
        }
        bw.flush();
        bw.close();
    }
}
