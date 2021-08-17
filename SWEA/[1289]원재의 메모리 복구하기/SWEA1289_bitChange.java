import java.util.Scanner;

public class SWEA1289_bitChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //test case 수
		
		for(int tc=1; tc<=T; tc++) {
			String s = sc.next(); // 한 줄 입력받음. 원래 상태
			int cnt =0; //바꾼 횟수 저장할 변수
			
			//시작이 1인 경우 -> 처음부터 바뀜
			if(s.startsWith("1")) {
				cnt++;
			}
			//문자열을 char배열로 만들지 않고, 바로 chatAt으로 접근!
			for(int j=0; j<s.length()-1; j++) {
				if(s.charAt(j)!= s.charAt(j+1))
					cnt++;
			}
			//출력문을 여기 이렇게 놔둬도 됨! 콘솔 창에서는 뒤섞인 것처럼 나오지만, 입력과 출력이 동시에 일어나서 그런 것. 
			//결론적으로는 각 케이스에 맞는 출력값이 알맞게 나옴
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
