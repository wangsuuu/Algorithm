import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229_SpotMart {
	
	static int[] snacks;
	static int[] results;
	static int N, M;
	static int max;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //과자 봉지의 갯수
			M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			max=-1; //매 테스트 케이스 끝날 때마다 초기화 필요!
			
			snacks = new int[N];
			results = new int[2];
			st = new StringTokenizer(br.readLine()); //각 과자 봉지의 무게를 공백을 기준으로 나눔
			for(int i=0; i<N; i++) { //각 과자의 무게를 배열에 저장.
				snacks[i]=Integer.parseInt(st.nextToken());
			} //입력 완료
			
			comb(0, 0);//조합 알고리즘
			
			System.out.println("#"+tc+" "+max);
			
		}
	}

	private static void comb(int cnt, int start) { 
		
		if(cnt==2) { //2개 다 골랐으면
			
			int sum=results[0]+results[1];
			if(sum<=M && sum>max) { //제한 무게를 넘지 않으면서 최댓값이면
				max=sum; //최댓값 업데이트
			}
			//그렇지 않은 경우에는 최댓값이 아니거나, 최댓값이라도 M을 넘어버리는 경우이므로 그냥 종료
			
			//하나의 테스트 케이스에 대한 모든 조합에서, 한 번도 if에 걸리지 않으면 선택을 아예 할 수 없는 경우이기 때문에
			//max는 원래 값인 -1이 유지된다.
			return;

		}
		
		for(int i=start; i<N; i++) {
			results[cnt]=snacks[i];
			comb(cnt+1, i+1);
		}
	}

}
