import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_DfsBfs {
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static boolean[][] matrix;
	static int N, M, V;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 갯수
		M = Integer.parseInt(st.nextToken()); //간선의 갯수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점 번호
		matrix= new boolean[N+1][N+1]; //노드 번호는 1번부터 시작
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = true;
		} //양방향 그래프 입력 완료
		
		boolean visited[] = new boolean[N+1];
		dfs(V, visited);
		System.out.println();
		bfs();
		
	}

	private static void dfs(int cur, boolean[] visited) {
		
		visited[cur]=true;
		System.out.print(cur + " ");
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && matrix[cur][i])
				dfs(i, visited);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		q.add(V);
		visited[V]=true;
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && matrix[cur][i]) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
}
