import java.util.Scanner;

public class BOJ1699{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1]; // i를 제곱수의 합으로 나타낼 경우 최소 항의 갯수 저장
		
		for(int i=1; i<=N; i++) {
			dp[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}

}
