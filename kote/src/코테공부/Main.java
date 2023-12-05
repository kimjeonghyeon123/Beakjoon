package 코테공부;

public class Main {
    public static void main(String[] args) {
        int[][] fees = {{4, 1000}, {6, 1000}, {21, 3000}, {16, 2000}, {26, 3000}};
        int t = 27;
        long[] result = solution(fees, t);

        System.out.println("최소 요금: " + result[0] + "원");
        System.out.println("최대 요금: " + result[1] + "원");
    }

    public static long[] solution(int[][] fees, int t) {
        int basicTime = fees[0][0];
        int basicFee = fees[0][1];
        int unitTime = fees[1][0];
        int unitFee = fees[1][1];

        long[] answer = new long[2];

        for (int i = 0; i < fees.length; i++) {
            int time = fees[i][0];
            int fee = fees[i][1];

            int totalTime = 0;

            // 기본시간이 0이 아닌 경우에만 기본시간을 더해줍니다.
            if (basicTime != 0) {
                totalTime += basicTime;
                if (time > basicTime) {
                    time -= basicTime;
                } else {
                    time = 0;
                }
            }

            // 추가 단위 시간을 반복하여 더해줍니다.
            while (time > 0) {
                totalTime += unitTime;
                time -= unitTime;
            }

            // 최소 요금을 계산합니다.
            answer[0] += Math.min(totalTime, basicTime) * basicFee;

            // 최대 요금을 계산합니다.
            answer[1] += totalTime * fee;
        }

        return answer;
    }
}
