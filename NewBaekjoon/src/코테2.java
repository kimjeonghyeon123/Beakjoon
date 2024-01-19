import java.util.Arrays;

/**
 * n팀
 * 각 팀에 m명
 * 각 팀의 전력은 해당 팀에 속한 능력치 총합
 * 두 팀 전력이 높은 팀 승리 같으면 무승부
 * 모든 팀과 경기함
 * 한번도 승리하지 못하는 팀이 없도록 경기 순서 정하는 경우의 수를 구하라
 *
 * 무승부가 아닌 경기면
 * 승리한 팀에서 능력치가 가장 높은 선수 A
 * 패배한 팀에서 능력치가 가장 높은 선수 B
 * A > B면 팀 교환
 *
 * 경기 순서 1,2,3,4,5,6,7,8,9
 *
 * dfs(int x, int y) {
 *     for(int j = 0; j < n; j++) {
 *          if(!visited[x][y]) {
 *              visited[x][y] = true;
 *              visited[y][x] = true;
 *          }
 *     }
 *  }
 *
 *  팀 바꾸기
 *  teams[i][] -> teams[j][]
 */

public class 코테2 {
    public static void main(String[] args) {
        int[][] teams = {
                {2, 4, 8},
                {1, 6, 7},
                {3, 5, 10}
        };

        int total = teams.length * (teams.length - 1) / 2;
        int[][] visited = new int[teams.length][teams.length];
        for(int i = 0; i < teams.length; i++) {
            for(int j = 0; j < teams.length; j++) {
                if(i == j) {continue;}
                int sumi = Arrays.stream(teams[i]).sum();
                int sumj = Arrays.stream(teams[j]).sum();
                if(sumi == sumj) {
                    visited[i][j] = 2;
                    visited[j][i] = 2;
                    dfs(teams, visited, i, j, 1, total);
                    visited[i][j] = 0;
                    visited[j][i] = 0;
                }
                else if(sumi > sumj) {
                    visited[i][j] = 3;
                    visited[j][i] = 1;
                    if(teams[i][teams[i].length-1] > teams[j][teams[j].length-1]) {
                        int temp = teams[i][teams[i].length-1];
                        teams[i][teams[i].length-1] = teams[j][teams[j].length-1];
                        teams[j][teams[j].length-1] = temp;
                    }
                    dfs(teams, visited, i, j, 1, total);
                    visited[i][j] = 0;
                    visited[j][i] = 0;

                }
                else {

                }
                dfs(teams, visited, i, j, 1, total);
            }
        }
    }

    public static void dfs(int[][] teams, int[][] visited, int x, int y, int cnt, int total) {
        int sumX = Arrays.stream(teams[x]).sum();
        int sumY = Arrays.stream(teams[y]).sum();

        if(sumX == sumY) {
            visited[x][y] = 2;
            visited[y][x] = 2;
            for(int i = 0; i < teams.length; i++) {
                for(int j = 0; j < teams.length; j++) {
                    if(i == j) {continue;}
                    if(visited[x][y] == 0) {
                        dfs(teams, visited, i, j, cnt+1, total);
                    }
                }
            }
        }
        else if {

        }
    }
}
