import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 중위 표기법 -> 후위 표기법
 * 1. 피연산자를 만나면 그대로 출력한다.
 * 2. 연산자를 만났을 때, 스택이 비어있다면 push 한다.
 * 3. 스택이 비어있지 않다면, 계속해서 연산자를 pop한 다음에 자기 자신을 push한다.
 *    하지만, top이 자신보다 연산자 우선순위가 낮다면 pop하지 않고 자기 자신을 push만 한다.
 * 4. 피연산자가 끝이 났는데 연산자가 스택에 남아있다면, 다 pop 해준다.
 * 
 * 
 * 후위 표기법 계산법
 * 1. 피연산자라면 스택에 넣는다.
 * 2. 연산자가 나오면 피연산자 두 개를 꺼내서 연산한 뒤, 그 결과를 다시 스택에 넣는다.
 * 3. 끝나면 최종 연산 결과가 스택에 하나 남아있게 되는데, 그걸 꺼내서 출력한다.
 */


public class SWEA1223_Calculator {

	static int N;
	static char[] middle, back; //중위 표기법, 후위 표기법을 담을 배열
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			
			N = Integer.parseInt(br.readLine());
			middle = new char[N];
			back = new char[N];
			middle = br.readLine().toCharArray(); //입력 완료
			
			middleToBack();
			int answer = calculate();
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.print(sb);
		
	}

	private static void middleToBack() {
		
		Stack<Character> stack1 = new Stack<>(); //중위 표기법을 후위 표기법으로 바꿀 때 사용하는 스택
		
		int idx=0;
		for(int i=0; i<N; i++) {
			
			if(Character.isDigit(middle[i])) { //피연산자이면 바로 back배열에 넣음
				back[idx++] = middle[i];
			} else { //연산자이면
				if(stack1.isEmpty()) { //스택이 비었다면 일단 push
					stack1.push(middle[i]);
				} else { //스택이 비지 않았다면
					if(middle[i]=='+') { // + 연산자라면, 스택에 있는 것 다 pop한 다음 자기 push
						while(!stack1.isEmpty()) {
							back[idx++] = stack1.pop();
						}
						stack1.push(middle[i]);
					} else { // *  연산자라면, +보다 우선순위 높으므로 push만 함
						stack1.push(middle[i]);
					}
				}
			}
		}
		if(!stack1.isEmpty()) {
			while(!stack1.isEmpty()) {
				back[idx++] = stack1.pop();
			}
		}
	}

	
	private static int calculate() {
		Stack<Integer> stack2 = new Stack<>(); //중위 표기법을 계산할 때 사용하는 스택. 어차피 숫자만 들어가므로 정수형으로
		
		for(int i=0; i<N; i++) {
			if(Character.isDigit(back[i])) { //만약 숫자이면 ->일단 스택에 넣는다
				stack2.push(back[i]-'0');
			} else { //연산자이면 -> 피연산자 두개 꺼내서 연산 후 그 결과를 다시 스택에 넣는다.
				int n1 = stack2.pop();
				int n2 = stack2.pop();
				int result=0;
				if(back[i]=='+') {
					result = n1+n2;
				} else {
					result = n1*n2;
				}
				stack2.push(result);
			}
		}
		int finalResult = stack2.pop();
		return finalResult;
	}
}
