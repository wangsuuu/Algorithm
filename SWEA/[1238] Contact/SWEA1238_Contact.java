import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1238_Contact {
	
	static int[][] map;
	static int N, S, answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			N = sc.nextInt(); //데이터의 갯수
			S = sc.nextInt(); //시작점 정점 번호
			map = new int[101][101]; //1부터 시작
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			answer=0;
			bfs();
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int visited[] = new int[101]; //방문 여부 및 방문 "순서"를 기록하기 위해 int배열 선언!
		
		q.offer(S);
		visited[S]=1;
		int cur=0;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i=0; i<101; i++) {
				if(visited[i]==0 && map[cur][i]==1) { //방문 전이고 서로 인접해 있다면
					q.offer(i);
					visited[i] = visited[cur]+1; //cur 바로 다음에 방문하는 것이므로
				}
			}
		}
		//cur은 마지막으로 방문했던 정점의 숫자를 가지고 있음.
		int last = visited[cur]; //마지막 순서의 값
		
		for(int i=0; i<101; i++) {
			if(visited[i]==last) {
				answer = Math.max(answer, i);
			}
		}
	}
}
