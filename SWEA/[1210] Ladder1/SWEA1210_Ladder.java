import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210_Ladder {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			int tc = Integer.parseInt(br.readLine());
			int x=0, y=0;
			int[][] ladder = new int[100][100];
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					ladder[j][k] = Integer.parseInt(st.nextToken());
					
					if(ladder[j][k]==2) { //도착점이면, 그때의 위치 좌표 저장
						x=j; y=k;
					}
				}
			}
			
			//x=99. 99행(도착점)부터 0행(시작점)까지 거슬러 올라감
			
			while(x>0) { //반복문 하나에 한 칸 움직임(좌/우/위)
				ladder[x][y]=0; //방문한 칸은 0으로 변경
				
				if(y-1>=0 && ladder[x][y-1]==1) { //좌로 갈 수 있다면
					y--;
				} else if(y+1<100 && ladder[x][y+1]==1) { //우로 갈 수 있다면
					y++;
				} else if(x-1>=0 && ladder[x-1][y]==1) { //위로 갈 수 있다면
					x--;
				} //우선순위가 "좌우 > 위" 이므로, 조건문 배치에서 "위"를 가장 마지막에 함. 
			}
			System.out.println("#" + tc + " " + y); //정답 출력
		}
	}
}
