import java.util.Arrays;

public class sadf {

    public static void main(String[] args) {
        int n = 2; // 우주선의 개수
        int fuel = 8; // 총 연료 양
        int[] powers = {20, 30}; // 각 우주선의 힘
        int[] distances = {750, 675}; // 각 우주선의 목표 거리

        int answer = solution(n, fuel, powers, distances);

        System.out.println(answer);
    }

    public static int solution(int n, int fuel, int[] powers, int[] distances) {
        int left = 1;
        int right = Arrays.stream(distances).max().getAsInt() / fuel;

        while (left < right) {
            int mid = (left + right) / 2;

            if (canArriveOnTime(n, powers, distances, fuel, mid)) {
                // 현재 mid 값으로 도착할 수 있다면, 더 작은 값에서 시도
                right = mid;
            } else {
                // 현재 mid 값으로 도착할 수 없다면, 더 큰 값에서 시도
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canArriveOnTime(int n, int[] powers, int[] distances, int fuel, int time) {
        for (int i = 0; i < n; i++) {
            int requiredFuel = calculateRequiredFuel(powers[i], distances[i], time);

            // 현재 우주선에 필요한 연료가 주어진 연료보다 많으면 false 반환
            if (requiredFuel > fuel) {
                return false;
            }
        }

        return true;
    }

    private static int calculateRequiredFuel(int power, int distance, int time) {
        // 등속운동 시간 이후의 거리
        int constantSpeedDistance = Math.max(0, distance - time);
        // 등속운동에 필요한 연료
        return constantSpeedDistance / power;
    }
}
