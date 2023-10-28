package barking.part3;

import java.io.*;
import java.util.*;

public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int count=0;
        for(int i =0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i] + arr[j];

                if(sum == x) {
                    count++;
                }
                else if(sum < x) {
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
