package barking.part3;

import java.io.*;
import java.util.*;

public class 개수세기 {

    public static int N, v;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        v = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i] == v)
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
