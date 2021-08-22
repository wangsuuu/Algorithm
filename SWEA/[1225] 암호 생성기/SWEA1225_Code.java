import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225_Code {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			for(int i=0; i<8; i++) {
				q.offer(sc.nextInt());
			}
			//입력 완료
			boolean flag = false; //찾았으면 true, 못 찾았으면 false;
			
			
			while(!flag) {
				
				for(int n=1; n<=5; n++) { //한 사이클
					if(q.peek()-n>0) {
						int tmp = q.poll() - n;
						q.offer(tmp);
					}
					else { //암호 생성 가능이면
						flag=true;
						q.poll();
						q.offer(0);
						break; //while문 앞에 label 붙여서, 밑의 break문 없이 한 번에 이중 반복문 탈출도 가능함.
					}
				 }
				if(flag)
					break; 
		   }
			sb.append("#"+tc);
			
			while(!q.isEmpty()) {
				sb.append(" "+q.poll());
				}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
