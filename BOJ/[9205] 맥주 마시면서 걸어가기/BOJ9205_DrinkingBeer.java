import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기존 플로이드 워샬 알고리즘을 살짝 변형하여, boolean배열로 플로이드 워샬 구현.
//집에서 페스티벌까지 한 번에 못 가더라도, 경유지를 거쳐서 갈 수 있다면 결국 갈 수 있다는 게 포인트.

public class BOJ9205_DrinkingBeer {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine()); //편의점 수
			
			int[][] map = new int[N+2][N+2]; // 집 - 편의점들 - 페스티벌
			Pos[] inputs = new Pos[N+2]; //좌표 입력값 담을 배열 (집 - 편의점들 - 페스티벌 순서)
			
			boolean[][] dist = new boolean[N+2][N+2];
			
			for(int i=0; i<N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				inputs[i] = new Pos(x, y);
			}//입력 완료
			
			//모든 쌍에 대한 direct 거리(D(ij)0에 해당) 
			//두 점 간 맥주가 떨어지지 않고 갈 수 있는 거리라면 true, 아니면 false
			//모든 쌍을 살펴보기 때문에 양방향 처리 안 해도 됨.
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					int distance = Math.abs(inputs[i].x - inputs[j].x) + Math.abs(inputs[i].y - inputs[j].y);
					if(distance<=1000) {
						dist[i][j]=true; 
					}else {
						dist[i][j]=false;
					}
				}
			}
			
			//플로이드 워샬
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						if(dist[i][k] && dist[k][j]) //경유지를 거쳐서 i부터 j까지 갈 수 있다면
							dist[i][j]=true; //모든 쌍을 살펴보기 때문에 양방향 처리 안해도 됨.
					}
				}
			}
			
			System.out.println(dist[0][N+1] ? "happy" : "sad");
		}
		
	}
	
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
