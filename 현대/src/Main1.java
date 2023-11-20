import java.io.*;
import java.util.*;

public class Main1 {

    private static int n, k;
    private static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //농부가 없으면 거위가 콩을 먹음
        //콩자루는 노를 저을 수 없음
        // 식인종의 수가 선교자 수보다 많으면 선교자 잡아먹음
        // 부부가 아닌 남여가 배를 타고 건너면 안됨

        // 배의 크기
        int n = Integer.parseInt(br.readLine());

        // 강을 건너야 하는 모든 사물
        String[] havetocross = br.readLine().split(" ");

        // 배를 몰 수 있는 사물
        String[] canship = br.readLine().split(" ");

        // 강둑에 남겨지면 안 되는 조합 개수
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            Queue<>
        }
    }

}
