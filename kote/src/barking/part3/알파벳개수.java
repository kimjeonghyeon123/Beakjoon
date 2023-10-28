package barking.part3;

import java.io.*;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = 'z' - 'a' + 1;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == s.charAt(j) - 'a') {
                    arr[i]++;
                }
            }
        }

        for (int i : arr) {
            bw.write(Integer.toString(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
