package 문제.브론즈;

/**
 * 거리두기
 * W개 H행
 * 세로 N칸 가로 M칸 비워야 됨
 * 최대 수용 가능 인원?
 */

import java.io.*;
import java.util.*;

public class ZOAC4 {

    public static int H, W, N, M;
    public static boolean[][] sitted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int r = (W % (M+1) == 0) ? W / (M+1) : W / (M+1) + 1;
        int c = (H % (N+1) == 0) ? H / (N+1) : H / (N+1) + 1;

        System.out.println(r*c);
    }
}
