//문제 이해를 잘못함. 너무 어렵게 생각했음. [ ( ] ) 이런 경우는 유효 X.  [ ( ) ] 나, [] () 이런 것만 유효. (교차 X, 포함관계만 존재함)
//댓글에 보면 다른 사람들도 헷갈려 하는걸 보니 문제가 명확하지 않는 듯함.

//pop 하기 전에, empty여부 확인하기!
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218_Bracket {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		for(int tc=1; tc<=10; tc++) {
			int num = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int answer=1; //일단 valid로 초기화
			
			stack.clear(); //새로운 테케 들어가기 전 clear
			
			for(int i=0; i<num; i++) { //받은 문자열의 처음부터 끝가지 한 번 순회
				
				if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='<') { //여는 괄호라면
					stack.push(s.charAt(i));
				}else { //닫는 괄호라면
					if(!stack.isEmpty()) {
						if(stack.peek()=='{' && s.charAt(i)=='}')
							stack.pop();
						else if(stack.peek()=='[' && s.charAt(i)==']')
							stack.pop();
						else if(stack.peek()=='(' && s.charAt(i)==')')
							stack.pop();
						else if(stack.peek()=='<' && s.charAt(i)=='>')
							stack.pop();
						else { //괄호가 포함 관계만 성립하므로, invalid
							answer=0; break;
						  }
						}
					else { answer=0; break;} //스택이 비어있으면 invalid
					  }
				}
			
			answer = stack.size()==0 ? 1 : 0; //끝가지 다 순회하고 나와서, 스택이 다 비어있어야 valid
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
