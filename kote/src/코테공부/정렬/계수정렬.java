package 코테공부.정렬;

// 카운트 배열에 각 데이터에 해당하는 인덱스 값 증가
// 중복이 많을 때 유리 범위가 작고
// 범위가 크면 메모리 낭비가 심함 ex) 1, 99999
public class 계수정렬 {

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        int n = 15;
        int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};

        int[] cnt = new int[MAX_VALUE + 1];

        for(int i = 0; i < n; i++) {
            cnt[arr[i]]++;
        }
        for(int i = 0; i <= MAX_VALUE; i++) {
            for(int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
