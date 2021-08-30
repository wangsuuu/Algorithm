import java.util.Scanner;

//8방탐색 연습
public class BuildBuilding {

	public static void main(String[] args) {
	
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //배열의 크기
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}//입력 완료
			
			int max_h = Integer.MIN_VALUE;
		
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					
					if(map[x][y]=='B') {
						
						boolean Gexist=false;
						for(int i=0; i<8; i++) {
							int nx= x+dx[i];
							int ny= y+dy[i];
							if(nx>=0 && nx<N && ny>=0 && ny<N) {
								if(map[nx][ny]=='G')
									Gexist=true;
							}
						}
						
						if(Gexist) {
							max_h = Math.max(max_h, 2);
						} else {
							int sum=0;
							for(int i=0; i<N; i++) {
								if(map[x][i]=='B') sum++;
								if(map[i][y]=='B') sum++;
							}
							sum--; //중복값 제거
							max_h = Math.max(max_h, sum);
						}
					}//if
					
				}
			}
			System.out.println("#" + tc + " " + max_h);
		}
	
	}

}
