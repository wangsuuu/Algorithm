import java.util.Scanner;

public class BOJ1149_RGBDist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //집의 수
		int[][] cost = new int[N+1][3]; //각 집을 칠하는 비용
		
		int red=0, green=1, blue=2;
		
		for(int i=1; i<=N; i++) {
			cost[i][red] = sc.nextInt();
			cost[i][green] = sc.nextInt();
			cost[i][blue] = sc.nextInt();
		} //입력 완료
		
		int[][] d = new int[N+1][3]; //1번 집부터 N번 집까지 집을 칠하는 비용의 최솟값이 들어있음
		//d[N][0] : N번집에 빨간색을 칠했을 경우에  1번집부터 N번집까지 집을 칠하는 비용의 최솟값
		
		//초깃값
		d[1][red] = cost[1][red]; 
		d[1][green] = cost[1][green]; 
		d[1][blue] = cost[1][blue]; 
		
		for(int i=2; i<=N; i++ ) {
			d[i][red] = Math.min(d[i-1][blue], d[i-1][green]) + cost[i][red];
			d[i][green] = Math.min(d[i-1][red], d[i-1][blue]) + cost[i][green];
			d[i][blue] = Math.min(d[i-1][red], d[i-1][green]) + cost[i][blue];
		}
		System.out.println(Math.min(Math.min(d[N][red], d[N][green]), d[N][blue]));
	}
}
