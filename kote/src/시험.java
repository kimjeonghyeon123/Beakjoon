import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 스팸
 * 연락처에 등록되지 않음 && 걸려온 적 k번 미만, k번 까지 -> 경고문구
 * 스팸번호로 등록된 번호는 문조건 경고문구
 *
 */

class Number {
    String str;
    int cnt;

    public Number(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}
public class 시험 {
    public static void main(String[] args) {
        String[] approved = {}; // 연락처 목록
        String[] spams = {}; // 스팸 목록
        String[] calls = {}; // 전화기록
        int k = 1;
        int[] answer = new int[calls.length];

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < calls.length; i++) {
            //스팸인지 확인
            boolean err = false;
            for(int j = 0; j < spams.length; j++) {
                if(calls[i].equals(spams[j])) {
                    err = true;
                    break;
                }
            }
            if(err) {
                answer[i] = 1;
                continue;
            }

            err = false;
            for(int j = 0; j < approved.length; j++) {
                if(calls[i].equals(approved[j])) {
                    err = true;
                    break;
                }
            }
            if(err) {
                answer[i] = 0;
                continue;
            }

            int cnt = map.getOrDefault(calls[i], 0);
            if(cnt <= k) {
                cnt++;
                map.put(calls[i], cnt);
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
        }
    }
}
