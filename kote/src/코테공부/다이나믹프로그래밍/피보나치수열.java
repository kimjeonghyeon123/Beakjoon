package 코테공부.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치수열 {

    public static int[] d = new int[100];

    public static int fibo(int x) {
        System.out.println("fibo(" + x + ")");
        if(x == 1 || x == 2) {
            return 1;
        }
        if(d[x] != 0) {
            return d[x];
        }

        d[x] = fibo(x-1) + fibo(x-2);
        return d[x];
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(fibo(5));
    }
}
