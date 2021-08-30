import java.util.Scanner;

public class SWEA1954_snail {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케 수

 		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[][] snail = new int[n][n];
			
			//우 하 좌 상 순으로 감
			int x=0, y=-1; //들어가기 전 배열 바깥에 있음
			int dir=1; //우, 하 : 1(y증가 or x증가)  /  좌, 상 : -1 (y감소 or x감소)
			int cnt=1;
			
			while(true) {
				
				for(int i=0; i<n; i++) { //오른쪽, 왼쪽
					y = y+dir;
					snail[x][y] = cnt++;
				}
				
				//아래, 위로 갈때 가는 칸 숫자가 하나씩 줄어듦
				n--;
				if(n==0) break;
				
				for(int i=0; i<n; i++) { //아래, 위쪽
					x= x+dir;
					snail[x][y]=cnt++;
				}
				
				//방향 전환 (오 -> 왼, 아래 -> 위)
				dir = dir*-1;
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<snail.length; i++) {
				for(int j=0; j<snail.length; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
