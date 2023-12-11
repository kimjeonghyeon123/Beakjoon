import java.util.ArrayList;
import java.util.Arrays;

public class 패턴 {
    public static void main(String[] args) {
//        int[] histogram = {2, 2, 2, 3};
//
//        int[] d = new int[histogram.length];
//        for(int i = 0; i < histogram.length-1; i++) {
//            System.out.println(i + " : ");
//            for(int j = i+1; j < histogram.length; j++) {
//                d[i] = Math.max(d[i], (j-i-1) * Math.min(histogram[i], histogram[j]));
//                System.out.println(j + " : " + d[i]);
//            }
//        }
//
//        System.out.println(Arrays.stream(d).max().getAsInt());

        int[][] phone = {
                {0,1,0},
                {1,1,1},
                {1,0,0},
                {0,0,1}
        };

        int[] dx = {-1,-1,-1,0,1,1,1,0};
        int[] dy = {-1,0,1,1,1,0,-1,-1};
        int[][] d = new int[4][3];
        for(int k = 0; k < 12; k++) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {

                }
            }
        }
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
