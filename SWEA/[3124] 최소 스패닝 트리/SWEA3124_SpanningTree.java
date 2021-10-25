import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//kruskal 알고리즘 사용
//1. 간선을 가중치를 기준으로 오름차순 정렬 
//2. 크기가 작은 순서대로, 서로소 집합의 union을 통해 사이클 생기지 않게 간선 선택해 나감
//3. 선택한 간선이 V-1개가 되면 종료


public class SWEA3124_SpanningTree {
	
	static class Node{
		int start, end, weight;
		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //전체 테케 수
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점의 갯수
			int E = Integer.parseInt(st.nextToken()); //간선의 갯수
			
			Node[] edgeList = new Node[E];
			parent = new int[V+1]; //정점 번호가 1부터 시작
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Node(start, end, weight);
			}
			
			Arrays.sort(edgeList, new Comparator<Node>() { //가중치를 기준으로 정렬

				@Override
				public int compare(Node o1, Node o2) {
					return o1.weight - o2.weight;
				}
			});
			
			make(); //각 vertex를 단위 집합으로 만듦
			
			int cnt=0; //선택한 간선의 갯수
			long result=0; //최소신장트리 비용
			
			for(int i=0; i<E; i++) {
				Node edge = edgeList[i];
				if(union(edge.start, edge.end)) { //간선 선택 가능하면
					cnt++;
					result+=edge.weight;
					if(cnt==V-1) { //spanning tree 다 완성됐다면
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void make() { //서로소 단위집합 만들기
		for(int i=1; i<parent.length; i++) {
			parent[i]=i;
		}
	}
	
	private static int find(int a) {
		
		if(parent[a]==a)
			return a;
		
		return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)
			return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
}
