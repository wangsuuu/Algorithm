import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1992_QuadTree {

	static int[][] picture;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //영상의 한 변의 길이
		sb = new StringBuilder();
		
		picture = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = str.charAt(j)-'0';
			}
		} //입력 완료
		
		solve(N, 0, 0);
		System.out.println(sb);
	}
	
	public static void solve(int n, int x, int y) { //n : 영상의 한 변의 길이 x,y : 탐색 시작점
		
		if(possible(n, x, y)) { //바로 결과를 낼 수 있다면
			sb.append(picture[x][y]);
			return;
		} else { //결과 바로 낼 수 없다면 -> 4분면으로 쪼개야 함
			sb.append("(");
			
			int half = n/2;
			solve(half, x, y);
			solve(half, x, y+half);
			solve(half, x+half, y);
			solve(half, x+half, y+half);
			
			sb.append(")");
		}
	}
	
	public static boolean possible(int n, int a, int b) { //다 0 or 1로 구성되어 있어서 결과를 낼 수 있는지에 대한 함수
		int flag = picture[a][b];
		
		for(int i=a; i<a+n; i++) {
			for(int j=b; j<b+n; j++) {
				if(flag!=picture[i][j]) { //만약 구간 내 값이 하나라도 다르면
					return false; //바로 결과 낼 수 없음
				}
			}
		}
		//한번도 if문에 걸리지 않고 내려왔다는 건 구간 안의 값이 다 같다는 의미이므로
		return true;
	}
}
