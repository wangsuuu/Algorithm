import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1228_CyperText {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int length = sc.nextInt(); //원본 암호문의 길이
			ArrayList<String> list = new ArrayList<>();
			
			for(int i=0; i<length; i++) //원본 암호문을 순서대로 저장
				list.add(sc.next());
			
			int cmd = sc.nextInt(); //명령어의 갯수
			
			for(int i=0; i<cmd; i++) { 
				if(sc.next().equals("I")) {
					int x = sc.nextInt(); // 숫자를 덧붙일 위치
					int y = sc.nextInt(); //덧붙일 숫자의 갯수
					
					ArrayList<String> list2 = new ArrayList<>();
					for(int j=0; j<y; j++) {
						list2.add(sc.next());
					} // 덧붙일 숫자 s를 순서대로 리스트에 저장
					
					list.addAll(x, list2); // 덧붙이는 작업을 한 번에 수행
					
				}
			}
			
			sb.append("#"+tc+" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
		}
	  System.out.print(sb);
	}
}
