import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//입력값이 공백없이 주어졌을 때:
//String[] arr = br.readLine().split("") 해서 차례차례 Integer.parseInt(arr[i]) 또는 arr[i] - '0' 으로 넣어주기!

//각 테케 끝날 때마다 프린트 하는 방법 말고, 
//StringBuilder에 계속 append 시켰다가 최종 for문 빠져나와서 sb 한꺼번에 출력할 수도 있음

public class SWEA2805_Farm {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine()); //테스트 케이스 갯수
		
		for (int tc = 1; tc <=num ; tc++) {
			
			int size=Integer.parseInt(br.readLine()); //농장의 사이즈
			int[][] farm = new int[size][size];
			
			for(int i=0; i<size; i++) {
				String[] nums=br.readLine().split("");
				for(int j=0; j<size; j++) {
					farm[i][j] = Integer.parseInt(nums[j]);
				}
			}
			//입력 완료
			
			int sum=0;
			//인덱스들
			int x_center = size/2; 
			
			for(int i=0; i<size; i++) //가운데 열의 값들은 다 더함
				sum+=farm[x_center][i];
			
			//center를 기준으로 위쪽
			int start=0, end=size-1, x=x_center-1;
			while(start!=end) {
				start+=1; end-=1;
				for(int i=start; i<=end; i++) {
					sum+=farm[x][i];
				}
				x--;
			}
			//center를 기준으로 아래쪽
			start=0; end=size-1; x=x_center+1;
			while(start!=end) {
				start+=1; end-=1;
				for(int i=start; i<=end; i++) {
					sum+=farm[x][i];
				}
				x++;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
