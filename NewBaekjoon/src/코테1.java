import java.util.Stack;

/**
 * 1~n 번호 유저 n명
 * 재화 주고받을 수 있음
 * 모든 유저는 다른 유저에게 자신의 재화를 보낼 수 있음
 * 가장 최근에 획득한 재화부터 순서대로 보냄
 *
 *
 * 30 30  30 30
 *
 * stack 2, 20
 */

class Node {
    int index, money;
    public Node(int index, int money) {
        this.index = index;
        this.money = money;
    }
}
public class 코테1 {
    public static void main(String[] args) {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction = {
                {1,2,10},
                {2,3,20},
                {3,4,5},
                {3,4,30}
        };
        int[] abnormal = {2, 3};

        int n = balance.length;
        Stack<Node>[] s = new Stack[n+1];
        for(int i = 1; i <= n; i++) {
            s[i] = new Stack<>();
            s[i].push(new Node(i, balance[i-1]));
        }

        int[] answer1 = new int[n];
        for(int i = 1; i <= n; i++) {
            while (!s[i].isEmpty()) {
                answer1[i - 1] += s[i].pop().money;
            }
        }
        for(int i : answer1) {
            System.out.println(i);
        }

        for(int i = 0; i < transaction.length; i++) {
            int sendmoney = transaction[i][2];
            while(sendmoney != 0) {
                Node node = s[transaction[i][0]].peek();
                //보내야 될 금액이 더 크면
                if(node.money <= sendmoney) {
                    s[transaction[i][1]].push(s[transaction[i][0]].pop());
                    sendmoney -= node.money;
                }
                else if(node.money > sendmoney) {
                    node.money -= sendmoney;
                    s[transaction[i][1]].push(new Node(node.index, sendmoney));
                    sendmoney = 0;
                }
            }
        }

        int[] answer = new int[n];
        for(int i = 1; i < n; i++) {
            while(!s[i].isEmpty()) {
                answer[i-1] += s[i].pop().money;
            }
//            while(!s[i].isEmpty()) {
//                Node node = s[i].pop();
//                boolean isAdd = true;
//                for(int j = 0; j < abnormal.length; j++) {
//                    if(node.index == abnormal[j]) {
//                        isAdd = false;
//                        break;
//                    }
//                }
//                if(isAdd) {
//                    answer[i-1] += node.money;
//                }
//            }
        }

        for(int i : answer) {
            System.out.println(i);
        }
    }
}
