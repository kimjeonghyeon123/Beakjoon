import java.util.Arrays;

public class 요격시스템 {
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1];});

        int last = -1;
        for (int[] target : targets) {
            if(last == -1) {
                answer++;
                last = target[1] - 1;
                continue;
            }

            if(target[0] <= last && last <= target[1]) {continue;}

            answer++;
            last = target[1] - 1;
        }

        return answer;
    }

}
/**
 * boolean을 두 개 만들자
 *
 */