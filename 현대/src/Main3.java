import java.io.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());

        Deque<String> q = new LinkedList<>();

        int t = (N % 2 == 0) ? (N / 2) : (N /2 + 1);
        Deque<String>[] arr = new Deque[t];
        arr[0] = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {

            }
        }
    }
}
