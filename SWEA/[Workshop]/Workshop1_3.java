public class WorkShop1_3 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.printf("번호를 입력하세요.");
		
		int choice = sc.nextInt();
		
		int user_win =0; // user가 이긴 횟수
		int com_win=0; //컴퓨터가 이긴 횟수
		int game_count=0; //게임이 진행된 횟수
		int full_count=0; //게임이 총 몇 번 진행되어야 하는지
		int win_cond=0; // 컴퓨터가 이기기 위해 채워야 하는 이긴 수
	
		if(choice==1) {
			full_count=5;
			win_cond=3;
		}
		else if (choice==2) {
			full_count=3;
			win_cond=2;
		}
		else {
			full_count=1;
			win_cond=1;
		}
		
		while((game_count++<full_count) && ((user_win<win_cond)&&(com_win<win_cond)))
		{
			System.out.printf("가위바위보 중 하나 입력: ");
			int user_choice=sc.nextInt();
			int com_choice=(int)(Math.random()*3)+1;
			
			if(user_choice==1) {
				if(com_choice==1) { System.out.println("비겼습니다!");}
				else if(com_choice==2) {
					System.out.println("졌습니다!");
					com_win++;
				}
				else {
					System.out.println("이겼습니다!");
					user_win++;
				}
			}
			
			else if(user_choice==2) {
				if(com_choice==1) { 
					System.out.println("이겼습니다!");
					user_win++;
				}
				else if(com_choice==2) {
					System.out.println("비겼습니다!");
				}
				else {
					System.out.println("졌습니다!");
					com_win++;
				}
			}
			else {
				if(com_choice==1) { 
					System.out.println("졌습니다!");
					com_win++;
				}
				else if(com_choice==2) {
					System.out.println("이겼습니다!");
					user_win++;
				}
				else {
					System.out.println("비겼습니다!");
				}
			}
		}
		
		if(user_win>com_win)
			System.out.println("### 당신이 이겼습니다!");
		else if(user_win<com_win)
			System.out.println("### 컴퓨터가 이겼습니다!");
		else
			System.out.println("### 비겼습니다!");
	}
}
