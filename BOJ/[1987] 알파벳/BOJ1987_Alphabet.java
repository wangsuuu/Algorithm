import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//1. A, B, C, D...를 숫자로 순서대로 변환 : char형에 각각 'A'를 빼주기. char 숫자를 int형으로 바꾸는 것과 유사 원리.
//2. cnt를 케이스 별로 따로 관리해야 하므로, static변수로 두지 말고 매개변수로 태워 보내기.

public class BOJ1987_Alphabet {
	static int[][] board;
	static boolean[] visited;
	static int R, C, max;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1}; //상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행 정보
		C = Integer.parseInt(st.nextToken()); //열 정보
		
		board = new int[R][C];
		visited = new boolean[26]; //알파벳이 26개이므로
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j]= str.charAt(j) - 'A';
			}
		} //입력 완료(알파벳을 숫자로 차례대로 변환해서 저장. visited를 관리하기 위해서)
		
		visited[board[0][0]]=true;
		solution(0, 0, 1); //처음부터 한 칸도 못 가도, 답은 1이므로 cnt는 1부터 시작
		System.out.println(max);
	}

	private static void solution(int x, int y, int cnt) {
		
		boolean flag = false;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[board[nx][ny]]) { //범위 안에 있다면
				visited[board[nx][ny]] = true;
				solution(nx, ny, cnt+1);
				visited[board[nx][ny]] = false; //다른 방향으로 탐색도 해야하므로
				flag=true;
			}
		}
		if(!flag) { //기저조건 : 사방으로 더 이상 못 가는 경우 (한 방향이라도 갔다면, flag가 true일 것)
			max = Math.max(max, cnt); 
			return;
		}
	}
}
