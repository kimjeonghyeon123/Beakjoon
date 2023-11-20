import java.io.*;
import java.util.*;

class Count {
    public int max;
    public int num;

    public Count(int max, int num) {
        this.max = max;
        this.num = num;
    }
}
public class Main6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine().trim());


        String[] str1 = br.readLine().split(" ");
        String str = br.readLine().replaceAll(" ", "");
        int inital = Integer.parseInt(str);
        String[] str2 = str.split("");

        Count[] arr = new Count[m];
        for(int i = 0; i < m; i++) {
            arr[i] = new Count(Integer.parseInt(str1[i]), Integer.parseInt(str2[i]));
        }

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++) {
            arr[m-1].num++;
            for(int j = m-1; j >= 0; j--) {
                if(arr[j].num > arr[j].max) {
                    if(j == 0) {
                        arr[j].num = 0;
                    }
                    else {
                        arr[j].num = 0;
                        arr[j - 1].num++;
                    }
                }
                else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            sb.append(arr[i].num);
        }
        if(Integer.parseInt(sb.toString()) < inital) {
            System.out.println(-1);
        }
        else {
            System.out.println(sb.toString());
        }
    }
}
