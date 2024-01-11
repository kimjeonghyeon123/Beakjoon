/**
 * A피자, B피자
 * A 피자의 다음 조각을 선택하거나
 * B 피자의 아무 조각을 선택하기!!
 *
 * A를 시작을 돌려
 * 마지막은 B 조각만 검사하는 것!
 */

import java.io.*;
import java.util.*;

public class test7 {

    public static int totalA = 0, totalB = 0;
    public static int K, m, n;
    public static int[] pizzaA;
    public static int[] pizzaB;
    public static ArrayList<Integer> listA = new ArrayList<>();
    public static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizzaA = new int[m];
        for(int i = 0; i < m; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
            totalA += pizzaA[i];
        }
        listA.add(0);

        pizzaB = new int[n];
        for(int i = 0; i < n; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
            totalB += pizzaB[i];
        }
        listB.add(0);

        for(int i = 0; i < m; i++) {
            makesum(i, pizzaA, m, pizzaA[i], totalA, listA);
        }
        for(int i = 0; i < n; i++) {
            makesum(i, pizzaB, n, pizzaB[i], totalB, listB);
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int leftIdx = 0;
        int rightIdx = listB.size() - 1;

        int ans = 0;
        while(leftIdx < listA.size() && rightIdx >= 0) {
            int lv = listA.get(leftIdx);
            int rv = listB.get(rightIdx);

            if(lv + rv == K) {
                int lc = 0;
                int rc = 0;
                while(leftIdx < listA.size() && listA.get(leftIdx) == lv) {
                    lc++;
                    leftIdx++;
                }
                while(rightIdx >= 0 && listB.get(rightIdx) == rv) {
                    rc++;
                    rightIdx--;
                }
                ans += lc*rc;
            }
            if(lv + rv > K) rightIdx--;
            if(lv + rv < K) leftIdx++;
        }
        System.out.println(ans);
    }

    public static void makesum(int index, int[] arr, int len, int sum, int total, ArrayList<Integer> list) {
        list.add(sum);
        index++;
        if(index == len) {
            index = 0;
        }
        sum += arr[index];
        if(sum <= K && sum != total) {
            makesum(index, arr, len, sum, total, list);
        }
    }
}