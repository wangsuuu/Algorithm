import java.util.Scanner;

public class BOJ1074_Z {

	static int N, R, C;
	static int cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		R = sc.nextInt(); //행 번호
		C = sc.nextInt(); //열 번호
		
		solution((int)Math.pow(2, N), 0, 0);
	}
	
	private static void solution(int n, int x, int y) { // n:한 변의 길이 x, y : 탐색을 시작하는 좌표
		
		if(R==x && C==y) { //탐색한 위치가 찾으려는 그 위치라면
			System.out.println(cnt);
			return;
		}
		
		//앞 두 조건을 넣어주지 않으면 메모리 초과가 뜸.
		if(x<=R && y<=C && R<(x+n) && C<(y+n)) { //R과 C가 범위 안에 있다면 -> 4분면으로 쪼개들어 가서 탐색
			int half = n/2;
			
			solution(half, x, y); //1사분면 탐색
			solution(half, x, y+half); //2사분면 탐색
			solution(half, x+half, y); //3사분면 탐색
			solution(half, x+half, y+half); //4사분면 탐색
		} else { //R과 C가 범위 안에 없다면 
			cnt += n*n; //그냥 값을 계산해서 더해줌.
		}
	}
}
