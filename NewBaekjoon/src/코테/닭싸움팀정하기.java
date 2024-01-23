package 코테;

/**
 * 내 친구의 친구는 내 친구
 * 내 원수의 원수는 내 친구
 *
 * 친구끼리만 팀 되어야 함
 * 최대한 많은 팀 만들기
 *
 * A B == F
 * A C == F
 *   <=>
 * B C == F
 */

import java.io.*;
import java.util.*;

public class 닭싸움팀정하기 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] friendList = new ArrayList[n+1];
        ArrayList<Integer>[] enemyList = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            friendList[i] = new ArrayList<>();
            enemyList[i] = new ArrayList<>();
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if(c == 'F') {
                friendList[p].add(q);
                friendList[q].add(p);
            }
            else {
                enemyList[p].add(q);
                enemyList[q].add(p);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < enemyList[i].size(); j++) {
                int enemy = enemyList[i].get(j);
                for(int k = 0; k < enemyList[enemy].size(); k++) {
                    if(i == enemyList[enemy].get(k)) {continue;}
                    friendList[i].add(enemyList[enemy].get(k));
                    friendList[enemyList[enemy].get(k)].add(i);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < friendList[i].size(); j++) {
                union(i, friendList[i].get(j));
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            hs.add(parent[i]);
        }
        System.out.println(hs.size());
    }

    public static int find(int a) {
        if(parent[a] == a) {return a;}
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
}
