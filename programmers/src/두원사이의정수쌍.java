public class 두원사이의정수쌍 {

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        for(int i = 1; i <= r2; i++) {
            long minJ = (int) Math.ceil(Math.sqrt(r1*r1 - i*i));
            long maxJ = (int) Math.floor(Math.sqrt(r2*r2 - i*i));
            answer += (maxJ - minJ + 1);
        }

        return answer * 4;
    }
}

/**
 * x^2 + y^2 = r^2
 * x = Math.sqrt(r^2 - y)
 */