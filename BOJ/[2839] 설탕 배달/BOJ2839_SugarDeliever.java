import java.util.Scanner;

//그리디 -> 5kg를 우선적으로 최대한 많이 담기!
public class BOJ2839_SugarDeliver4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int bag3 = 0;
		
		while(true) {
			if(n%5==0) {
				System.out.println(n/5+bag3);
				break;
			} else {
				bag3++;
				n-=3;
			}
			
			if(n<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
