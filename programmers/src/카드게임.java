import java.util.*;

public class 카드게임 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));
        System.out.println(solution(3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}));
        System.out.println(solution(2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7}));
        System.out.println(solution(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}));
    }

    public static Set<Integer> original, additional;

    public static int solution(int coin, int[] cards) {
        int answer = 0;
        int len = cards.length;
        original = new HashSet<>();
        additional = new HashSet<>();

        // 초기 작업
        int idx = len / 3;
        for(int i = 0; i < idx; i++) {
            original.add(cards[i]);
        }

        // 목표 숫자
        int target = len + 1;
        while(true) {
            // 라운드 증가
            answer++;
            // 현재 인덱스가 길이를 넘어갈 경우 종료
            if(idx >= len) {break;}

            additional.add(cards[idx]);
            additional.add(cards[idx+1]);

            idx += 2;
            boolean flag = false;

            // 내가 가진 카드에서 해결 가능한지 확인하기
            // 숫자 2개만으로 해결 가능한가?
            for(int i : original) {
                if(original.contains(target-i)) {
                    original.remove(i);
                    original.remove(target-i);
                    flag = true;
                    break;
                }
            }

            if(!flag && coin >= 1) {
                for(int i : original) {
                    if(additional.contains(target-i)) {
                        original.remove(i);
                        additional.remove(target-i);
                        coin--;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag && coin >= 2) {
                for(int i : additional) {
                    if(additional.contains(target-i)) {
                        additional.remove(i);
                        additional.remove(target-i);
                        coin -= 2;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {break;}
        }
        return answer;
    }
}
/**
 * 1~n 카드
 * 동전
 *
 * 1) 처음 n/3 개의 카ㄷ를 뽑아 가짐
 * 2) 각 라운드 시작마다 카드 두장뽑음 카드가 없으면 게임 종료
 * 3) 카드 한 장당 동전 하나를 소모해 가지거나, 카드를 안 가질 수 있음
 * 4) 카드에 적힌 수의 합이 n+1이 되도록 카드 두 장 내기
 * 5) 카드 두 장 낼 수 없다면 게임 종료
 *
 * 최대 라운드
 *
 * 카드를 뽑음
 *
 * 내가 가진 카드 중에서 n+1이 되는 카드 조합을 구함
 *   방금 뽑은 카드가 하나 있으면 coin을 하나 지불
 *   두개 다 있으면 coin 두개 지불
 *   다음으로 넘어감
 */