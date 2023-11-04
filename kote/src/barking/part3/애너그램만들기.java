package barking.part3;

import java.io.*;
import java.util.*;

public class 애너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[] aArr = new int[26];
        int[] bArr = new int[26];
        for(int i = 0; i < a.length(); i++) {
            aArr[a.charAt(i) - 'a']++;
        }
        for(int i = 0; i < b.length(); i++) {
            bArr[b.charAt(i) - 'a']++;
        }

        int sum = 0;
        for(int i = 0; i < 26; i++) {
            int c = aArr[i] - bArr[i];
            if (c < 0)
                c = -c;
            sum += c;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
