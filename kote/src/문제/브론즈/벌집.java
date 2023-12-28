package 문제.브론즈;

import java.io.*;
import java.util.*;

/**
 * 1 7 19 37
 *  6 12 18
 *  bn = bn-1 + 6(n-1)
 *  b2 = b1 + 6 = 7
 *  b3 = b2 + 12 = 19;
 *  1
 *  12 2
 *  11 13 3
 *  18 14
 *  10 19 4
 *  17 15
 *  9 16 5
 *  8 6
 *  7
 */
public class 벌집 {

    public static void main(String[] args) {
        int n = 3; // 예시로 n=5인 경우

        int[][] result = traverseBeehive(n);

        // 결과 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] traverseBeehive(int n) {
        int size = n * 2 - 1;
        int[][] result = new int[size][size];

        int count = 1;
        int offset = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= i; j++) {
                    result[i + offset - j][j] = count++;
                }
                offset++;
            } else {
                for (int j = 0; j <= i; j++) {
                    result[j][i + offset - j] = count++;
                }
            }
        }

        return result;
    }
}
