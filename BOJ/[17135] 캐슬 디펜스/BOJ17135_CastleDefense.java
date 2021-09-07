import java.util.ArrayList;
import java.util.Scanner;

//시뮬레이션 게임이라 로직 자체는 크게 어렵지 않으니, 차근차근 로직 세워보기
//한번에 구현하려 하지 말고, 함수로 뺄 줄도 알기!!
//이차원 배열로 맵을 구성해서 그 정보를 다 담으려고 하는게 아니라, 그냥 적의 위치만 파악!

public class BOJ17135_CastleDefense {
	
	static class Enemy{ //적의 위치
		int x, y;

	public Enemy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	   }
	}
	
	static int N, M, D;
	static ArrayList<Enemy> enemies;
	static int[] selected; //뽑은 궁수의 위치(y좌표) (x좌표는 N으로 일정)
	static int maxKill=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //행의 갯수
		M = sc.nextInt(); //열의 갯수
		D = sc.nextInt(); //제한 거리
		
		enemies = new ArrayList<>();
		selected = new int[3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt()==1) {
					enemies.add(new Enemy(i, j)); //적의 위치 저장
				}
			}
		} //입력 완료
		
		comb(0, 0);
		System.out.println(maxKill);
		
	}

	private static void comb(int cnt, int start) { //궁수의 위치를 M개 중 세 군데 뽑음
		
		if(cnt==3) { //다 뽑았다면
			
			//복사본 저장
			ArrayList<Enemy> copy = new ArrayList<>();
			for(Enemy e : enemies) {
				copy.add(new Enemy(e.x, e.y)); //아예 새로운 객체를 생성하는, 깊은 복사!
			}
			
			//복사본을 가지고 시뮬레이션 함 -> 하나의 조합에서 죽일 수 있는 적의 갯수를 구함
			int kill = startSimul(copy, selected);
			maxKill = Math.max(maxKill, kill);
			return;
		}
		
		for(int i=start; i<M; i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}

	private static int startSimul(ArrayList<Enemy> elist, int[] archers) { //죽일 수 있는 적의 갯수를 리턴
		int count=0;
		
		while(elist.size()!=0) { //적이 다 제거될 때까지 게임이 진행됨
			ArrayList<Enemy> temp = new ArrayList<>(); //죽일 적의 리스트
			for(int a : archers) { //각 궁수가 죽일 적을 temp에 담음
				int targetIndex = FindNearestOne(a, elist); //궁수와 가장 가까운 공격 가능한 적의 인덱스 구하기
				if(targetIndex>=0) { //죽일 수 있는 적이 있다면
					temp.add(elist.get(targetIndex));
				}
			}
			
			//적을 제거함(중복값 고려)
			for(Enemy e : temp) {
				if(elist.remove(e)) //e값이 있을 때에만 true리턴함
					count++;
			}
			goDown(elist); //적들이 한 칸씩 내려옴
		}
		return count;
	}

	private static void goDown(ArrayList<Enemy> elist) { //적들이 한 칸씩 내려옴 ( N행에 도착하면 게임에서 제외됨)
		
		for(int i=0; i<elist.size(); i++) {
			elist.get(i).x++;
			if(elist.get(i).x==N) {
				elist.remove(i);
				i--;
			}
		}
	}

	private static int FindNearestOne(int a, ArrayList<Enemy> elist) { //궁수의 위치로부터 가장 가까이 있는 적의 인덱스를 리턴
		//D 거리 안에 있어야 공격 가능하고, 가장 가까운 거리가 여럿이면 가장 왼쪽에 있는 적 공격가능함.
		int minDist = Integer.MAX_VALUE;
		int minCol=16;
		int minIdx=-1;
		
		for (int i = 0; i < elist.size(); i++) {
			
			Enemy e = elist.get(i);
			
			int dist = (N-e.x) + Math.abs(a - e.y);
			if(dist>D) { //이 적은 공격할 수 없음.
				continue;
			} else if (dist<minDist) {
				minDist=dist;
				minCol = e.y;
				minIdx = i;
			} else if(dist==minDist) {
				if(e.y < minCol) { //더 왼쪽이라면 업데이트
					minCol=e.y;
					minIdx=i;
				}
			}
		}
		return minIdx;
	}
}
