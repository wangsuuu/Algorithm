import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] boxes = new int[100];
		
		for(int tc=1; tc<=10; tc++) {
			int num=Integer.parseInt(br.readLine()); //dump 횟수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int diff=0;
			
			for(int i=0; i<100; i++) {
				boxes[i]=Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			int cnt=0;
			
			while(true) {
				Arrays.sort(boxes);
				diff = boxes[99]-boxes[0];
				if(diff<=1 || cnt==num) //평탄화가 이미 완료됐거나 횟수만큼 다 돌았다면
					break;
				
				boxes[99]--; boxes[0]++; //dump  수행
				cnt++;
			}
			System.out.println("#"+tc+ " " + diff);
		}
	}

}
