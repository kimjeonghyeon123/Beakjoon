package barking.part3;

import java.io.*;

public class 숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String str = Integer.toString(A * B * C);

        for (char i = '0'; i <= '9'; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (i == str.charAt(j)) {
                    count++;
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
