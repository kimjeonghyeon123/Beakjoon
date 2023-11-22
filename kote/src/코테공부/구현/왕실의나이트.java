package 코테공부.구현;

import java.io.*;
import java.util.*;

public class 왕실의나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int x = str.charAt(1) - '1';
        int y = str.charAt(0) - 'a';

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int nx = 0, ny = 0;
        int count = 0;
        for(int i = 0; i < 8; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                continue;
            }

            count++;
        }

        System.out.println(count);
    }
}
