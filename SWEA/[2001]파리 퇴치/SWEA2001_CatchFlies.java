import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001_CatchFlies {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료
			
			int x=0, y=0;
			
			int max=0;
			
			//위쪽부터, -> 방향으로 진행하며 밑으로 한 칸씩 내려오는 방향으로 계산
			for(int l=0; l<N-M+1; l++) {
				y=0; //다시 초기화
				for(int k=0; k<N-M+1; k++) {
					int sum=0;
					
					for(int i=x; i<M+x; i++) {// 한 차례 계산
						
						for(int j=y; j<M+y; j++) {
							sum+=map[i][j];
						 }
					   }
					if (max<sum)
						max=sum;
					
					y++;
				}
				x++;
			}
		
		sb.append("#"+tc+" "+max).append("\n");
			
		}
		System.out.println(sb);
	}
}
