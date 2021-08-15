//기억할 것 : bit flip 으로 " ? : " 연산자 활용 가능!
import java.util.Scanner;

public class BOJ1244_light {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[] lights = new int[n+1];
		for (int i = 1; i < lights.length; i++) { //헷갈리니까 0번 인덱스는 비워둔다.
			lights[i]=sc.nextInt();
		}
		
		int student_num = sc.nextInt();
		
		for(int i=0; i<student_num; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt(); //학생이 받은 수
			
			if(gender==1) { //학생이 남자이면
				for (int j = 1; j < lights.length; j++) {
					if(j%num==0) { //배수이면
						lights[j] = lights[j]==0 ? 1 : 0; // bit flip : 삼항 연산자 활용!!!
					}
				}
			}
			else { // 학생이 여자이면
				lights[num] = lights[num] == 1 ? 0 : 1;
				int a=1;
				while(num-a>=1 && num+a<lights.length) { //num을 기준으로 한 대칭을 살핌
					if(lights[num-a]-lights[num+a]==0) {
						lights[num-a] = lights[num-a] == 1 ? 0 : 1;
						lights[num+a] = lights[num+a] == 1 ? 0 : 1;
						a++;
					}
					else
						break;
				}
				
			}
		}
		
		for (int i = 1; i < lights.length; i++) {
			if(i==21 || i==41 || i==61 || i==81)
				System.out.println();
			System.out.printf("%d ", lights[i]);
			
		}
		
	}

}
