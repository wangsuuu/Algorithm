import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961_TastyFood {
	
	static int[] sour;
	static int[] bitter;
	static int N;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //재료의 갯수
		StringTokenizer st;
		sour = new int[N];
		bitter= new int[N];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sour[i]=Integer.parseInt(st.nextToken());
			bitter[i]=Integer.parseInt(st.nextToken());
		}//입력 완료
		
		int answer = subset(0, 1, 0);
		System.out.println(answer);
	
	}
	
	//cnt번째까지의 재료를 고려해서 그때까지의 쓴맛과 신맛의 차이 리턴
	public static int subset(int cnt, int total_sour, int total_bitter) {
		
		if(cnt==N) {
			
			if(total_sour==1 && total_bitter==0) //재료를 하나도 포함하지 않았을 경우 -> 조건 만족 X
				return Integer.MAX_VALUE;
			
			return Math.abs(total_sour - total_bitter);
		}
		
		
		int a = subset(cnt+1, total_sour*sour[cnt], total_bitter+bitter[cnt]);
		int b = subset(cnt+1, total_sour, total_bitter);
		return Math.min(a, b);
	}

}
