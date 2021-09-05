import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이미 방문한 곳이라면 그 경로 외의 다른 방에서 그 방을 방문할 경우의 수는 없다는 게 포인트.
//즉, 하나의 방에 대해서 가능한 경로는 네 방향 중 한 방향 뿐이거나 경로 존재 X.
public class SWEA1861_SquareRoom1 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int[][] room;
	static int[][] visited; //각 방이 최대로 갈 수 있는 칸 수가 위치에 맞게 저장되어 있음
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			n = Integer.parseInt(br.readLine());
			room = new int[n][n]; //방 생성
			visited = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 완료
			
			int maxMove = Integer.MIN_VALUE;
			int roomNum=-1;
			
			//각 방에 대하여 visited 배열 채우기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					dfs(i, j);
				}
			}
			
			//최댓값 구하기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(maxMove<visited[i][j]) {
						maxMove=visited[i][j]; roomNum = room[i][j];
					} else if(maxMove==visited[i][j]) { //max값이 여러개인데
						if(roomNum > room[i][j]) {  //새로운 값이 더 작다면
							roomNum=room[i][j]; //더 작은 값으로 업데이트
						}
					}
				}
			}
			
 			System.out.println("#" + tc + " " + roomNum + " " + maxMove);
		}
		
	}

	private static void dfs(int x, int y) {
		visited[x][y]=1; //처음은 1로 시작
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && room[nx][ny]==room[x][y]+1) { //범위 안에 있고 갈 수 있는 조건이라면
				dfs(nx, ny);
				visited[x][y] = visited[nx][ny]+1; //다 조사하고 돌아와서, 시작점에는 새로운 점 탐색한 것 +1 의 값이 들어있음.
			}
		}
	}
}
