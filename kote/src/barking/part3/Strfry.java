package barking.part3;

import java.io.*;
import java.util.*;

public class Strfry {

    public static void count(int[] count, String input) {
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'a']++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int[] countA = new int[26];
            int[] countB = new int[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            String before = st.nextToken();
            String after = st.nextToken();

            count(countA, before);
            count(countB, after);

            if(Arrays.equals(countA, countB)) {
                bw.write("Possible\n");
            }
            else {
                bw.write("Impossible\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
