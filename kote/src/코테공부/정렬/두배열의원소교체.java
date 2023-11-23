package 코테공부.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두배열의원소교체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int j = 0; j < K; j++) {
            if(A[j] < B[j]) {
                int temp = A[j];
                A[j] = B[j];
                B[j] = temp;
            }
            else break;
        }

        long result = 0;
        for (Integer i : A) {
            result += i;
        }
        System.out.println(result);
    }
}
