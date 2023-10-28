import java.io.*;
import java.util.StringTokenizer;

public class MyProfile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();

        bw.write((a+1) + "\n");
        bw.flush();
        bw.close();
    }
}
