package barking.part3;

import java.io.*;
import java.util.*;

public class 방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int[] arr = new int[10];

        for(int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            if(num == 6)
                arr[9]++;
            else
                arr[num]++;
        }
        if(arr[9] % 2 == 0){
            arr[9] = arr[9] / 2;
        }
        else {
            arr[9] = arr[9] / 2 + 1;
        }

        Arrays.sort(arr);
        bw.write(String.valueOf(arr[9]));


        bw.flush();
        bw.close();
    }
}
