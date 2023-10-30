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
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = n - 1, count = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == x) {
                left++;
                right--;
                count++;
            }
            else if(sum < x) {left++;}
            else {right--;}
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
