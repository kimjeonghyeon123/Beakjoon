package 코테연습;

import java.io.*;
import java.util.*;

public class 도넛과막대그래프 {
    public static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = 0;
        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < 2; j++) {
                N = Math.max(N, edges[i][j]);
            }
        }

        // line_exist[i][0] : 노드 i에서 나가는 간선 수
        // line_exist[i][1] : 노드 i로 들어오는 간선 수
        int[][] line_exist = new int[N+1][2];
        for(int i = 0; i < edges.length; i++) {
            line_exist[edges[i][0]][0]++;
            line_exist[edges[i][1]][1]++;
        }

        int[] answer = new int[4];
        for(int i = 1; i <= N; i++) {
            // 생성한 점 구하기
            // 나가는 수 >= 2 들어오는 수 == 0
            if(line_exist[i][0] >= 2 && line_exist[i][1] == 0) {
                answer[0] = i;
                break;
            }
        }

        for(int i = 0; i < edges.length; i++) {
            if(edges[i][0] == answer[0]) {
                line_exist[edges[i][1]][1]--;
            }
        }

        for(int i = 1; i <= N; i++) {
            if(i == answer[0]) {continue;}

            // 막대 모양인 경우
            // 나가는 수 == 0 들어오는 수 == 1
            if (line_exist[i][0] == 0 && line_exist[i][1] >= 0) {
                answer[2]++;
            }
            // 8자 모양인 경우
            // 나가는 수 >= 2 들어오는 수 >= 2
            else if (line_exist[i][0] >= 2 && line_exist[i][1] >= 2) {
                answer[3]++;
            }
        }
        answer[1] = line_exist[answer[0]][0] - answer[2] - answer[3];

    }
}
/**
 * 크기가 N인 도넛 모양 그래프
 * n개의 정점, n 개의 간선 존재
 * 첫번째에서 출발하면 모든 노드 거친 뒤 원래로 돌아오게 됨
 *
 * 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수
 */
