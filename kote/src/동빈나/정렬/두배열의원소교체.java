package 동빈나.정렬;

import java.io.*;
import java.util.*;

public class 두배열의원소교체 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st2.nextToken());
            B[i] = Integer.parseInt(st3.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i < K; i++) {
            if(A[i] < B[i]) {
                int temp = B[i];
                B[i] = A[i];
                A[i] = temp;
            }
            else
                break;
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i];
        }
        System.out.println(result);
    }
}
