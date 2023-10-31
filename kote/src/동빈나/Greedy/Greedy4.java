package 동빈나.Greedy;

import java.io.*;
import java.util.*;

public class Greedy4 {

    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 공포도가 X 인 모험가 : X명 이상 같이 다녀야 됨
        // 그룹 수의 최대
        /*
            작은거 먼저 하고 큰 거 하기
         */

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;  // 현재 그룹 인원 수
        int result = 0; // 만들어진 그룹 수
        for(int i = 0; i < N; i++) {
            count++;            // 자기 자신 그룹에 추가
            if(arr[i] == count) {
                result++;
                count = 0;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}