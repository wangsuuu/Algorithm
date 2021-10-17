import java.util.Scanner;
//하나씩 비교해 나가면서, 스위치가 서로 다르면 뒤에 것의 스위치를 누른다.
//그렇게 해 나가면서 스위치의 끝까지 간 후, 스위치가 모두 Y이거나 N로 구성되어 있다면 전구를 모두 끌 수 있고,
//그렇지 않다면 모두 끌 수 없는 상태이다.

public class BOJ12927_Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] lights = new char[s.length()+1];
		for(int i=1; i<lights.length; i++) {
			lights[i] = s.charAt(i-1);
		} //번호가 1번부터 시작하므로. 
		//입력 완료
		
		int cnt=0;
		for(int i=1; i<lights.length-1; i++) {
			if(lights[i]==lights[i+1]) { //붙어있는 두 개의 스위치가 같다면, 넘어감
				continue;
			} else { //다르다면, i+1번째 스위치를 누름
				for(int j=1; j<lights.length; j++) { //배수 스위치는 다 반전시켜 줌
					if(j%(i+1)==0) {
						if(lights[j]=='Y') {
							lights[j]='N';
						}else {
							lights[j]='Y';
						}
					}
				}
				cnt++; //스위치를 눌렀으므로, 수 증가
			}
		}
		
		int numY=0, numN=0;
		for(int i=1; i<lights.length; i++) {
			if(lights[i]=='Y') {
				numY++;
			} else {
				numN++;
			}
		}
		
		if(numY==lights.length-1) { //모두 Y로 구성되어 있다면
			System.out.println(cnt+1); //마지막은 N으로 바꿔줘야 하므로 +1
		} else if(numN==lights.length-1) { //모두 N으로 구성되어 있다면
			System.out.println(cnt); //cnt그대로 프린트
		} else { //그렇지 않고 Y, N이 섞여 있다면
			System.out.println(-1); //스위치를 모두 끌 수 없는 상태이므로 -1 출력
		}
	}
}
