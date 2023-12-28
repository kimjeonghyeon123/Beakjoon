import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MyProfile {
    public static void main(String[] args){
//        int[] x = {3,4};
//        int[] y = {3,5};
//        int[] r = {2,3};
//        int[] v = {12,83,54,35,686,337,258,95,170,831,8,15};

        int[] x = {5};
        int[] y = {5};
        int[] r = {5};
        int[] v = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};

        int x1 = (int) 1e9, x2 = - (int) 1e9, y1 = (int) 1e9, y2 = -(int) 1e9;
        for(int i = 0; i < x.length; i++) {
            x1 = Math.min(x1, x[i] - r[i]);
            x2 = Math.max(x2, x[i] + r[i]);
            y1 = Math.min(y1, y[i] - r[i]);
            y2 = Math.max(y2, y[i] + r[i]);
        }

        int result = 0;
        int count = 0;
        for(int i = 0; i < v.length; i += 2) {
            int x3 = x1 + v[i] % (x2-x1);
            int y3 = y1 + v[i+1] % (y2-y1);

            for(int j = 0; j < r.length; j++) {
                if((x[j] - x3)*(x[j] - x3) + (y[j]-y3)*(y[j]-y3) <= r[j]*r[j]) {
                    count++;
                    break;
                }
            }
            result++;
        }

        int k = (int)(((double) count / result) * (x2-x1) * (y2-y1));
        System.out.println(k);
    }
}

/**
 * 기지국이 커버하는 영역의 넓이의 합
 * 원의 면적만큼 커버 가능
 * - 몬테카를로
 * 기지국 영역을 포함하는 가장 작은 직사각형 찾음
 * x, y 축과 평행해야 됨
 * x = l, r, y = b, t
 *
 * 난수 2개 생성 직사각형의 안의 점을 나타내는 정수 좌표
 * [l + x % (r-1), b + y % (t-b)]
 *
 * 점이 기지국 내에 있는지 검사
 * 원 위도 가능
 *
 * 생성한 점들 중 기지국 영역 내부에 존재하는 점의 비율 계산 직사각형의 면적과 곱하여 기지국 영역 면적 구하기
 * 원의 중심 : (x[i], y[i])  반지름 : r[i]
 *
 * 가장 작은 거 구하려면
 * x[i]+r[i] 중 최대값, 최소값
 * y[i]+r[i] 중 최대값, 최소값
 *
 */