import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233_Arithmetic {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine()); //정점의 총 갯수
			
			char[] nodes = new char[N+1];
			int answer=1;
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); //노드 번호 정보는 필요없으니 한 번 날리고
				nodes[i] = st.nextToken().charAt(0);//노드의 값 저장
			} //입력 완료
			
			for(int i=1; i<=N; i++) {
				int lchild = i*2;
				int rchild = i*2+1;
				
				if(Character.isDigit(nodes[i])) { //만약 노드의 값이 숫자이면 -> 리프노드여야 함
					if(lchild<=N) { //만약 자식이 있다면 유효하지 않음
						answer=0;
						break;
					}
				} else { //만약 노드의 값이 연산자이면
					//1. 리프노드이면 안됨
					//2. 오른쪽 자식이 숫자이고 왼쪽 자식이 연산자이면 안됨
					if(lchild>N) { // 1의 경우
						answer=0; break;
					}
					
					if(Character.isDigit(nodes[lchild]) && !(Character.isDigit(nodes[rchild]))) { //2의 경우
						answer=0; break;
					}
				}
			}
			
			sb.append("#" + tc + " "+answer+"\n");
		}
		System.out.println(sb);
	}
}
