package baekjoon.array;

import java.util.Scanner;

class Student {
	int fm;
	int grade;
	
	Student(int fm, int grade){
		this.fm    = fm;
		this.grade = grade;
	}
}

public class Test13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Student[] student = new Student[N]; 
		
		for(int i=0;i<N;i++) {
			student[i] = new Student(sc.nextInt(), sc.nextInt());
		}
		
		int mcount;
		int fcount;
		int total = 0;
		for(int i=1;i<=6;i++) {
			mcount = 0;
			fcount = 0;
			for(int j=0;j<N;j++) {
				if(i == student[j].grade) {
					if(student[j].fm == 0) {
						fcount++;
					}
					else {
						mcount++;
					}
				}
			}
			if(fcount%K == 0) {total += fcount/K;}
			else			  {total += fcount/K + 1;}
			if(mcount%K == 0) {total += mcount/K;}
			else			  {total += mcount/K + 1;}
		}
		
		System.out.println(total);
		
		sc.close();
	}
}
