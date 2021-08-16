import java.util.Scanner;

public class BOJ_17478_Recursive {

	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		answer(cnt, "");
		System.out.print(sb);
	}

	private static void answer(int cnt, String string) {
		String temp = string;
		if(cnt==0) {
			sb.append(string+"\"재귀함수가 뭔가요?\"\n");
			sb.append(string+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(string+"라고 답변하였지.\n");
			
		}
		else {
			sb.append(string+"\"재귀함수가 뭔가요?\"\n");
			sb.append(string+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(string+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(string+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			string+="____";
			answer(--cnt, string);
			sb.append(temp+"라고 답변하였지.\n"); //string을 더하게 되면, 변경 후 string이 더해지므로, temp를 더함.
		}
	}

}
