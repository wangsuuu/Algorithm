//부분집합이 아니라, 조합으로 풀기!
//M개보다 적게 골라도, 어쨌든 치킨 거리는 최솟값으로 계산되므로 결과값은 동일하다.
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15686_Chicken {
	
	static int M, N;
	static int[][] city;
	static ArrayList<Pos> house, chicken;
	static Pos[] selected;
	static int answer=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //도시 크기 : N * N
		M = sc.nextInt(); //뽑을 치킨집의 갯수
		
		city = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new Pos[M]; //뽑힌 치킨집을 담을 배열
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				city[i][j]=sc.nextInt();
				
				if(city[i][j]==1) { //집의 위치 정보 저장
					house.add(new Pos(i, j));
				}else if(city[i][j]==2) { //치킨집의 위치 정보 저장
					chicken.add(new Pos(i, j));
				}
			}
		}
		//입력 완료
		
		comb(0,0);
		System.out.println(answer);
		
	}

	public static void comb(int cnt, int start) {
		
		if(cnt==M) {
			int sum=0;
			for(int i=0; i<house.size(); i++) { //각 집에서의 치킨거리 계산
				int min=Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int dist = Math.abs(house.get(i).x - selected[j].x) + Math.abs(house.get(i).y - selected[j].y);
					min = Math.min(min, dist);
				}
				sum+=min; //도시의 치킨 거리 계산
				if(sum>answer) { //이미 원래 min값을 넘어버렸다면, 이미 답이 아니므로 바로 끝냄
					return;
				}
			}
			answer = Math.min(answer, sum); //도시의 치킨 거리를 min값으로 update
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			selected[cnt] = chicken.get(i);
			comb(cnt+1, i+1);
		}
	}
}

class Pos{ //위치 정보 클래스
	int x, y;
	
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
