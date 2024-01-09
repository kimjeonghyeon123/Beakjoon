/**
 * 소가 길을 건너간 이유는 그냥 길이 많아서
 * N*N 목초지
 * 인접한 목초지는 건널 수 있지만 일부는 길을 건너야 함
 * K마리 소
 * 어떤 두 소는 길을 건너지 않으면 만나지 못함
 *
 */

import java.io.*;
import java.util.*;

class Road {
    int index, distance;
    public Road(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
public class test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Road road = new Road(0, 0);
        System.out.println(road.index);
        road.index = 3;
        System.out.println(road.index);
    }
}