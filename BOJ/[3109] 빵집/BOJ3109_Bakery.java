import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//포인트 1. 최대한 많은 파이프의 수를 구해야 하므로, "오른쪽 위 - 오른쪽 - 오른쪽 아래"의 우선순위 순으로 탐색한다.
//포인드 2. 만약 하나의 루트가 성공했다면, 그 루트 선상의 다른 방향은 더 이상 탐색 및 카운트되면 안 되므로 재귀를 종료시켜야 한다!
public class BOJ3109_Bakery2 {
	
	static int R, C, answer;
	static char[][] map;
	static int[] dx = {-1, 0, 1}; //오른쪽 위, 오른쪽, 오른쪽 아래 순
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		} //입력 완료
		
		for(int i=0; i<R; i++) {
			dfs(i, 0);
		}
		System.out.println(answer);
	}

	private static boolean dfs(int r, int c) {
		
		if(c==C-1) {
			answer++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + dx[i];
			int nc = c + 1;
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]!='x') { //다음 칸이 범위 안에 있고, 건물로 막혀있지 않다면
				map[nr][nc]='x'; //visited배열 따로 두지 않고 x 재활용!
				boolean result = dfs(nr, nc);
				if(result==true) { //루트를 찾았으므로, 같은 루트 선상의 다른 방향의 탐색을 막기 위해. 즉, 재귀를 끝내기 위함임.
					return true;
				}
			}
		}
		//더 이상 파이프라인을 설치하지 못할 경우
		return false;
	}
}
