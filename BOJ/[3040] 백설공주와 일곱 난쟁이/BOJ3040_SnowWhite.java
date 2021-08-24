import java.util.Scanner;

//조합

public class BOJ3040_SnowWhite {

	static int[] dwarfs;
	static int[] result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		dwarfs = new int[9];
		result = new int[7];
		
		for(int i=0; i<9; i++)
			dwarfs[i] = sc.nextInt();
		
		comb(0, 0);
	}

	private static void comb(int cnt, int start) {
		
		if(cnt==7) { //다 뽑았다면
			int sum=0;
			for(int i=0; i<7; i++) {
				sum+=result[i];
			}
			
			if(sum==100) {
				for(int i=0; i<7; i++)
					System.out.println(result[i]);
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			
			result[cnt] = dwarfs[i];
			comb(cnt+1, i+1);
			
		}
	}
}
