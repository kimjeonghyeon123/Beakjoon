import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MyProfile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] babbling = new String[5];

        for(int i = 0; i < 5; i++) {
            babbling[i] = br.readLine();
        }

        System.out.println(solution(babbling));
        bw.flush();
        bw.close();
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        String[] arr = {"aya", "ye", "woo", "ma"};

        for(String input : babbling) {
            for(String s : arr) {
                if(input.contains(s)) {
                    input = input.replace(s, "0");
                }
            }
            input = input.replaceAll("0", "");
            if(input.equals("")) {answer++;}
        }
        String a = "asdf";
        return answer;
    }
}
/*
ayaye
uuuma
ye
yemawoo
ayaa
 */