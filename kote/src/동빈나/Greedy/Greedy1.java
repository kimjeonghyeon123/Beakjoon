package 동빈나.Greedy;

import java.io.*;

public class Greedy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = {500, 100, 50, 10};

        int count = 0;
        for(int i : arr) {
            count += N / i;
            N %= i;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
