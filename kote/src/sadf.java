import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sadf {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hist = new int[N];

        int left = 0, right = N-1;
        int max = 0;
        while(left < right) {
            max = Math.max(max, (right - left) * Math.min(hist[right], hist[left]));
            if(hist[left+1] > hist[left]) {
                left++;
            }
            if(hist[left-1] > hist[right]) {
                right--;
            }
        }
    }
}
