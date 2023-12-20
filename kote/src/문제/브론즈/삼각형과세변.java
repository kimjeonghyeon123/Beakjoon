package 문제.브론즈;

/**
 * 세 변의 길이
 * E : 세 변 모두 같음
 * I : 두 변만 같음
 * S : 모두 다름
 *
 * r1 + r2 <= r3 : 삼각형 안됨
 */

import java.io.*;
import java.util.*;

public class 삼각형과세변 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0, y = 0, z = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if(x==0 && y==0 && z==0) {break;}

            if(tri(x, y, z)) {sb.append("Invalid").append("\n");}
            else if(isEqual(x, y, z)) {sb.append("Equilateral").append("\n");}
            else if(isEqual2(x, y, z)) {sb.append("Isosceles").append("\n");}
            else {sb.append("Scalene").append("\n");}
        }

        System.out.println(sb.toString());
    }

    public static boolean tri(int x, int y, int z) {
        if(x + y <= z) { return true; }
        if(x + z <= y) { return true; }
        if(y + z <= x) { return true; }
        return false;
    }

    public static boolean isEqual(int x, int y, int z) {
        if(x == y && y == z) {return true;}
        return false;
    }

    public static boolean isEqual2(int x, int y, int z) {
        if(x==y) {return true;}
        if(x==z) {return true;}
        if(y==z) {return true;}
        return false;
    }
}
