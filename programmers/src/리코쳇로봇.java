import java.util.*;

public class 리코쳇로봇 {
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            if(board[x].charAt(y) == 'G') {return cnt;}

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {continue;}
                if(!visited[nx][ny] && board[nx].charAt(ny) != 'D') {
                    q.offer(new Node(nx, ny,cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    public static class Node {
        int x, y, cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
