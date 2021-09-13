import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//FLAT하게!
// 1. 사각형 안의 수가 다 동일하다면(0:하얀색, 1:파란색) -> 끝
// 2. 동일하지 않다면, 4등분 하여 살펴본다.


public class BOJ2630_ColoredPaper {

	static int N;
	static int[][] square;
	static int white, blue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		square = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력 완료
		
		solve(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
		
	}

	private static void solve(int n, int x, int y) {
		
		int sum=0;
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				sum+=square[i][j];
			}
		}
		if(sum==0) { //구역이 전부 흰색인 경우
			white++;
		} else if(sum==n*n) { //구역이 전부 파란색인 경우
			blue++;
		} else { //섞여있는 경우 -> 4분할 필요
			int half = n/2;
			
			solve(half, x, y);
			solve(half, x, y+half);
			solve(half, x+half, y);
			solve(half, x+half, y+half);
			
		}
	}
}
