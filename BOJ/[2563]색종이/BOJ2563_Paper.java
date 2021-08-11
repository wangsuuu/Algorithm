import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563_Paper {

	public static void main(String[] args) throws Exception {
		int[][] white = new int[100][100];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<num; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1; //인덱스는 0부터 시작하므로
			int y = Integer.parseInt(st.nextToken())-1;
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					white[j][k]=1;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(white[i][j]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
