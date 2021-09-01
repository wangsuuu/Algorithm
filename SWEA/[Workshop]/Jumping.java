import java.util.Scanner;

//4방탐색 연습을 위한 소금쟁이 문제

public class Solution22 {
	// 위치가 겹치면 나중에 뛴 소금쟁이만 죽는다.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt(); // 테스트 케이스 수
		int[] answer = new int[T];
		int idx=0;
		for (int i = 0; i < T; i++) //한 번 반복 = 테스트 한 번 실행
		{
		int N = scan.nextInt();
		int num = scan.nextInt();
		
		
		int[][] lake = new int[N][N]; // 모든 좌표는 0으로 디폴트 초기화
		
		
		int[][] moves = new int[num][3]; // 3이 아닌 4인 이유는 최종 위치의 마킹을 위함임.
		int survived = 0;
		
		for (int j = 0; j < num; j++) {
			for (int k = 0; k < 3; k++) {
				moves[j][k] = scan.nextInt();
			}
		  }//모든 입력값 입력 완료 
			
		for(int j=0; j<num; j++) {
			int x=moves[j][0];
			int y=moves[j][1];
			here: for (int l = 3; l > 0 ; l--) { //하나의 소금쟁이가 3번  뜀
					switch(moves[j][2]) {
					
					case 1: //상
						 x -= l;
						if(x>=0 && lake[x][y]!=1 ) { //소금쟁이가 죽지 않을 조건
							if(l==1) {
								lake[x][y]=1;
								survived++;}
							}
						else {
							break here;}
						break;
					case 2: //하
						x += l;
						if(x<N && lake[x][y]!=1){ 
							if(l==1) {
								lake[x][y]=1;
								survived++;}
						}
						else {
							break here; }
						break;
					case 3: //좌
						y -= l;
						if(y>=0 && lake[x][y]!=1) {
							if(l==1) {
								lake[x][y]=1;//final position에 도달했음을 표시하기 위해 1로 마킹
								survived++;}
						}
						else{
							break here; } //죽음. 아예 다음 소금쟁이 차례로 넘어감
						break;
					case 4: //우
						y += l;
						if(y<N && lake[x][y]!=1) {
							if(l==1) {
								lake[x][y]=1;
								survived++;}
						}
						else{
							break here; }
						break;
					} 
				}
	         }
		//System.out.printf("# %d %d%n", i+1, survived); //입력 복붙 시 출력이 뭔가 좀 이상하게 나옴
		answer[idx++]=survived;
	   }
	 for(int i=1; i<=T; i++) {
		 System.out.printf("# %d %d%n", i, answer[i-1]);
	 }
   }
}
