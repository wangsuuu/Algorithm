import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//아이디어를 순열로 뒤늦게 올바로 잡음..
public class SWEA1247_OptimalPath {

	static class Position{
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Position[] client; //고객 위치 배열
	static int N, minDistBtwClient;
	static Position[] result;
	static boolean[] isSelected;
	static Position company, home;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine()); //고객의 수
			//초기화
			client = new Position[N];
			result = new Position[N]; 
			isSelected = new boolean[N]; 
		    minDistBtwClient=9999; 
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //회사의 위치
			home = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); //집의 위치
			
			for(int i=0; i<N; i++) {
				client[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} //입력 완료
			
			FindMinDistBtwClient(0); 
			System.out.println("#" + tc + " " + minDistBtwClient);
		}
	}
	
	public static void FindMinDistBtwClient(int cnt) {	//고객들 간의 최단 거리 리턴 -> 순열 사용
		
		if(cnt==N) { //순열 다 뽑았다면
			int distSum=0;
			
			for(int i=0; i<N-1; i++) { //각 고객 간의 거리
				Position c1 = result[i]; 
				Position c2 = result[i+1];
				int dist = Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
				distSum += dist;
			}
			//"회사 - 고객 , 고객- 집" 거리 계산
			distSum += Math.abs(company.x - result[0].x) + Math.abs(company.y - result[0].y) + 
					Math.abs(home.x - result[N-1].x) + Math.abs(home.y - result[N-1].y);
			
			//min값 업데이트
			minDistBtwClient = Math.min(minDistBtwClient, distSum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(isSelected[i])
				continue;
			isSelected[i]=true;
			result[cnt] = client[i];
			FindMinDistBtwClient(cnt+1);
			isSelected[i]=false;
		}
	}
}
