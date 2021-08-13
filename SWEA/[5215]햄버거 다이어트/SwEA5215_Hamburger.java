import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215_Hamburger {

	static boolean[] isSelected;
	static int[] score;
	static int[] kcal;
	static int num, max, limit;
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()); //재료의 갯수
			limit = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			//재료 각각의 맛 점수와 칼로리 저장할 배열
			score = new int[num];
			kcal = new int[num];
			isSelected = new boolean[num];
			max=0; // 매 테케마다 값 리셋.
			
			for(int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(0);
			
			sb.append("#" + tc + " "+ max + "\n");
		}
		
		System.out.println(sb);
	}

	public static void subset(int cnt) {
		
		if(cnt==num) {
			
			int kcal_sum=0, score_sum=0;
			
			for(int i=0; i<num; i++) { //뽑힌 원소의 칼로리들과 점수 저장
				if(isSelected[i]) {
					kcal_sum+=kcal[i];
					score_sum+=score[i];
				}
			}
			
			if(kcal_sum<=limit && score_sum>max) {
					max=score_sum;
			}
			return;
		}
		
		isSelected[cnt]=true;
		subset(cnt+1);
		isSelected[cnt]=false;
		subset(cnt+1);
		
	}
}
