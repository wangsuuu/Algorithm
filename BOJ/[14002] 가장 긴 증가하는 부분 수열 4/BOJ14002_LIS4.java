package day3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ14002_LIS4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //수열의 크기
		int[] input = new int[N];
		int[] lis = new int[N]; //i를 끝값으로 하는 LIS의 값이 들어있음.
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		} 
		
		int max=-1;
		for(int i=0; i<N; i++) {
			lis[i] = 1;
			for(int j=0; j<i; j++) {
				if(input[j]<input[i] && lis[i] < lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
			max = Math.max(max, lis[i]);
		}
		System.out.println(max);
		
		Stack<Integer> st = new Stack<>();
		
		int size=max;
		for(int i=N-1; i>=0; i--) { //거꾸로 접근
			if(lis[i]==size) {
				st.add(input[i]);
				size--;
			}
			if(size==0)
				break;
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
}
