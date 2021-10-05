import java.util.ArrayList;
import java.util.Scanner;

//한 사람만 있어도 하나의 무리에 해당함.
//완성된 무리의 갯수 세기 == 대표자의 수 세기

public class SWEA7465_Village {
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케 수
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //마을에 사는 사람들 수
			M = sc.nextInt(); //서로를 알고 있는 사람의 관계 수
			
			parents = new int[N+1]; //1번부터 시작
			make();
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				if(list.contains(find(i))) {
					continue;
				} 
				list.add(find(i));
			}
			System.out.println("#" + tc + " " + list.size());
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)
			return;
		parents[bRoot]=aRoot;
	}

	private static int find(int a) {
		if(parents[a]==a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		for(int i=1; i<=N; i++)
			parents[i]=i;
	}
}
