package 코테;

import java.util.Stack;

public class asdf {
    public static void main(String[] args) {
        Stack<Integer> stack = find_direction(0);
    }

    public static Stack<Integer> find_direction(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n != 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        System.out.println(stack.size());
        for(int i = 0; i < 4 - stack.size(); i++) {
            System.out.println(n%2);
            stack.push(0);
        }
        return stack;
    }
}
