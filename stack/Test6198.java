package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Building {
	int num;
	int height;
	
	Building(int num, int height){
		this.num    = num;
		this.height = height;
	}
}

public class Test6198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Building> stack = new Stack<>();
		int count = 0;
		
		for(int i=1;i<=N;i++) {
			Building building = new Building(i, Integer.parseInt(br.readLine()));
			
			if(stack.isEmpty()) {
				stack.push(building);
			}
			else {
				while(stack.peek().height <= building.height) {
					stack.pop();
					if(stack.isEmpty()) break;
				}
				if(stack.isEmpty() || stack.peek().height > building.height) {
					stack.push(building);
					count += stack.size() - 1;
				}
			}
		}
		System.out.println(count);
	}
}

/*
 * 10
 * 10 3  -->  count = 1
 * 10 7  -->  count = 1 + 1 = 2
 * 10 7 4  --> count = 2 + 2 = 4
 * 12	   --> count = 4
 * 12 2    --> count = 4 + 1 = 5;
 */ 
