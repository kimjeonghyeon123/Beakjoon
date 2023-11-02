package barking.part3;

import java.io.*;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(int i = 'a'; i <= 'z'; i++) {
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == i) {
                    cnt++;
                }
            }
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
    }
}
