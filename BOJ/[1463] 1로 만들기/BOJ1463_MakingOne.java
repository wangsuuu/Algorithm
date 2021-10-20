import java.util.Scanner;

public class BOJ1463_MakingOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//N을 1로 만들기 위해 필요한 최소 연산의 횟수
		int[] d = new int[N+1];
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		if(N==2 || N==3) {
			System.out.println(1);
			return;
		}
		
		//초기값
		d[1]=0; d[2]=1; d[3]=1;
		
		for(int i=4; i<=N; i++) {
			
			if(i%2==0 && i%3==0) { //i가 2와 3으로 모두 나누어 떨어진다면
				d[i] = Math.min(Math.min(d[i/2]+1, d[i/3]+1), d[i-1]+1);
			} else if(i%2==0) { //2로만 나누어 떨어진다면
				d[i] = Math.min(d[i/2]+1, d[i-1]+1);
			} else if(i%3==0) { //3으로만 나누어 떨어진다면
				d[i] = Math.min(d[i/3]+1, d[i-1]+1);
			} else { //2와 3 모두 나누어 떨어지지 않는다면
				d[i] = d[i-1]+1;
			}
		}
		System.out.println(d[N]);
	}
}
