package 코테연습;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;

        int left = 0;
        int right = 1;

        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length;
        int sum = sequence[0];

        while(left < right) {
            if(sum == k) {
                if(right - left < answer[1] - answer[0] + 1) {
                    answer[0] = left;
                    answer[1] = right-1;
                }
                sum -= sequence[left];
                left++;
            }
            else if(sum > k) {
                sum -= sequence[left];
                left++;
            }
            else {
                if(right == sequence.length) {break;}
                sum += sequence[right];
                right++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}