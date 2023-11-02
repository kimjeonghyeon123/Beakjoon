package barking.part3;

import java.io.*;

public class 숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String str = String.valueOf(A * B * C);

        for (int i = 0; i <= 9; i++) {
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) - '0' == i) {
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
