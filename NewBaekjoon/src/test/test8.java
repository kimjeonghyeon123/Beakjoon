package test; /**
 * 모든 트리는 2개 이하의 자식 노드를 가질 수 있음
 * 1~n까지 유일한 번호가 매겨져 있음
 *
 * 전위순회
 * 가운데 -> 왼쪽 -> 오른쪽
 * 3 6 5 4 8 7 1 2
 *
 * 중위순회
 * 왼쪽 -> 가운데 -> 오른쪽
 * 5 6 8 4 3 1 2 7
 *
 * 후위순회
 * 왼쪽 -> 오른쪽 -> 가운데
 * 5 8 4 6 2 1 7 3
 *
 * 3 기준으로 뒤에 있는 것은 자기 자식 노드
 * 3 6548712
 *
 *       3
 * 5684     127
 *
 * 다음 6을 가운데로 하고 5 6 84
 *      3
 *   6        127
 * 5   84
 *
 * 1) 3을 가운데라고 생각
 *      3보다 앞에 있는 것은 3의 left list로 넘겨
 *      3보다 뒤에 있는 것은 3의 right list로 넘겨
 * 2) 6을 가운데라고 생각
 *      6이 left에 있는지 right에 있는지 검사
 *      left에 있을 경우
 *      left 중에 6보다 앞에 있는 것은 6의 left에 삽입
 *      left 중에 6보다 뒤에 있는 것은 6의 right에 삽입
 *
 * 전위순회에서 하나씩 빼
 *  3 6 5 4 8 7 1 2
 *  5 6 8 4 3 1 2 7
 *
 *  1) 3 -> 5684, 127
 *  2) 6 5684 -> 5, 84
 *       127  -> 127
 *  3) 5 5   -> 5
 *       84  -> 84
 *       127 -> 127
 *  4) 4 5    -> 5
 *       84   -> 8, 4
 *       127  -> 127
 *  5) 8
 *
 *
 */

import java.io.*;
import java.util.*;

public class test8 {
    public static class Node {
        int index;
        ArrayList<Node> left_node = new ArrayList<>();
        ArrayList<Node> right_node = new ArrayList<>();
        public Node(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> prerder = new ArrayList<>();
            while(st.hasMoreTokens()) {
                prerder.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> inorder = new ArrayList<>();
            while(st.hasMoreTokens()) {
                inorder.add(Integer.parseInt(st.nextToken()));
            }

            Node node = new Node(prerder.get(0));
            boolean left = true;
            for(int k = 0; k < inorder.size(); k++) {
                if(inorder.get(k) == node.index) {
                    left = false;
                    continue;
                }
                if(left) {
                    node.left_node.add(new Node(inorder.get(k)));
                }
                else {
                    node.right_node.add(new Node(inorder.get(k)));
                }
            }

            for(int k = 0; k < prerder.size(); k++) {

            }
        }
    }
}
