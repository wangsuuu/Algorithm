//문제 제대로 안 읽어서 시간 오래 걸림.
// --> 총 테스트 갯수 다음에 "각 테스트 케이스의 번호가 한번 더 주어진 뒤" 숫자들 시작.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1204_최빈값 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] scores = new int[101];
		
		for(int tc=1; tc<=num; tc++) {
			
			//새로운 테케 시작 시 초기화!!! 빼먹지 말 것!
			Arrays.fill(scores, 0);
			int max=-1;
			int max_value=-1;
			
			int T = sc.nextInt();
			
			for(int i=0; i<1000; i++) {
				int score = sc.nextInt();
				scores[score]++;
			}
			//점수 모두 카운트 완료
			
			for(int i=0; i<scores.length; i++) { //어차피 점수 순서대로 비교
				if(scores[i]>=max && i>max_value) {
					max=scores[i];
					max_value=i;
				}
			}
			
			System.out.printf("#%d %d\n", T, max_value);
			
		}
		
	}

}
