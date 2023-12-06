package barking.part10;

import java.io.*;

// X % 3, X % 2 X-1
// 5 4 2 1
// d[i] : i일때 가장 최솟값
// d[i] = min(d[i-1], d[i/3], d[i/2]) + 1
public class 일로만들기 {

    public static final int INF = (int) 1e9;

    public static int X;
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        d = new int[X+1];

        for(int i = 2; i <= X; i++) {
            d[i] = d[i-1] + 1;
            if(i % 3 == 0) {
                d[i] = Math.min(d[i/3] + 1, d[i]);
            }
            if(i % 2 == 0) {
                d[i] = Math.min(d[i/2] + 1, d[i]);
            }
        }

        System.out.println(d[X]);
    }
}
