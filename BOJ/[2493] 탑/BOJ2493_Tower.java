import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_Tower {

	public static void main(String[] args) throws Exception {
		
		Stack<Tower> towers = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //탑의 높이
		StringTokenizer st = new StringTokenizer(br.readLine()); //탑들의 높이를 토큰화
		
		
		for(int num=1; num<=N; num++) {
			int height = Integer.parseInt(st.nextToken());
			while(!towers.empty()) {
				if(height > towers.peek().height) {
					towers.pop();
				} else {
					sb.append(towers.peek().num + " ");
					break;
				}
			}
			
			if(towers.isEmpty()) {
				sb.append("0" + " ");
			}
			
			towers.push(new Tower(num, height));
		}
		System.out.println(sb);
	}
}

class Tower{
	int num;
	int height;
	
	public Tower(int num, int height) {
		super();
		this.num = num;
		this.height = height;
	}
}
