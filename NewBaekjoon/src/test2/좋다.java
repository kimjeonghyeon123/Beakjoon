package test2;

/**
 * N개의 수 어떤 수가 다른 두 개의 합으로 나타낼 수 있다면 좋다라고 함
 * 좋은 수의 개수는?
 * 수의 위치가 다르면 같은 값이여도 다른 수이다.
 */

import java.io.*;
import java.util.*;

public class 좋다 {
    public static int N;
    public static Integer[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        d = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(d);

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while(true) {
                if(left == i) {left++;}
                else if(right == i) {right--;}

                if(left >= right) break;

                if(d[left] + d[right] < d[i]) {
                    left++;
                }
                else if(d[left] + d[right] > d[i]) {
                    right--;
                }
                else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
