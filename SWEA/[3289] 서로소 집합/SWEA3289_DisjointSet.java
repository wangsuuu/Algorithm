import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_DisjointSet {
	
	static int n;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //집합의 갯수
			int m = Integer.parseInt(st.nextToken()); //연산의 갯수
			sb.append("#"+tc+" ");
			
			parents = new int[n+1]; //1번부터 시작
			make();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int kind = Integer.parseInt(st.nextToken()); //0(union) 또는 1(find)
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()); 
				
				if(kind==0) {
					union(a,b);
				} else {
					if(find(a)==find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int find(int a) {
		if(a==parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot==bRoot) return;
		
		parents[bRoot] = aRoot;
	}

	private static void make() {
		for(int i=1; i<=n; i++) {
			parents[i]=i;
		}
	}
}
