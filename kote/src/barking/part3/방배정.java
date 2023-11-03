package barking.part3;

import java.io.*;

public class 방배정 {

    public static int N, K;
    public static int[][] arr = new int[2][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        for(int i = 0; i < N; i++) {
            String[] str1 = br.readLine().split(" ");
            int a = Integer.parseInt(str1[0]);
            int b = Integer.parseInt(str1[1]) - 1;
            arr[a][b]++;
        }

        int count = 0;
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] % K == 0) {
                    count += arr[i][j] / K;
                }
                else {
                    count += arr[i][j] / K + 1;
                }
            }
        }

        System.out.println(count);
    }
}
