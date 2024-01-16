package test2;

/**
 * 세로 2줄
 * 가로 N개
 * 첫째줄 1~N 순서대로
 * 둘째줄 각 칸마다 1~N 랜덤 숫자
 *
 * 위에 숫자를 적절히 뽑으면
 * 그 밑에 숫자들도 같은 숫자로 이루어진 경우가 있다.
 * 최대 개수를 뽑아라?
 *
 */

import java.io.*;
import java.util.*;

public class 숫자고르기 {

    public static ArrayList<Integer> list;
    public static boolean[] visited;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start, int target) {
        if(!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if(arr[start] == target) list.add(target);
    }
}

/**
 * 1 2 3 4 5 6 7
 * 3 1 1 5 5 4 6
 *
 * i을 뽑았을 때 arr[j] = i 인 것을 뽑아
 * j를 뽑았을 때 arr[k] = ㅓ 인 것을 뽑아
 *
 * 1->3->1
 * 2->1->3->1
 * 3->1->3
 * 4->5->5
 * 5->5
 * 6->4->5
 */