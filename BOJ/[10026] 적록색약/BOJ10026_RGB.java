import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10026_RGB {
	
	static char[][] pic;
	static boolean[][] visited;
	static int N, R, G, B;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pic = new char[N][N]; //일반 그림
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			pic[i]=s.toCharArray();
		} //입력 완료
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					dfs(i, j, pic[i][j]);
				}
			}
		}
		System.out.print(cnt + " ");
		
		//적록색약 환자 버전
		makePatientPic();
		//초기화
		visited = new boolean[N][N];
		cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					dfs(i, j, pic[i][j]);
				}
			}
		}
		System.out.print(cnt);
	}

	private static void makePatientPic() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(pic[i][j] == 'R')
					pic[i][j]='G';
			}
		}
		
	}

	private static void dfs(int x, int y, char color) {
		
		visited[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<N && ny>=0 && ny<N && pic[nx][ny]==color && !visited[nx][ny]) { 
				//범위 안에 있고 색이 같으며(같은 구역이라면) 아직 방문하지 않았다면
				dfs(nx, ny, color);
			}
		}
	}
}
