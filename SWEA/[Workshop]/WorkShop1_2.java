public class WorkShop1_2 {
  //별찍기 유형 문제
  
	//공백은 왼쪽에만 생기고, 오른쪽은 그냥 줄바꿈이 바로 일어난다고 생각하기.
		public static void main(String[] args) {
			int target = 5/2; // 모양이 반전 되는 기준이 되는 행의 위치(3행)
			//target을 중심으로 blank가 늘어났다가 다시 줄어든다.
			int blank=0;
			boolean blankIncreasing=true;
			int count=1;
			while(count<=17) {
				for(int i=0; i<blank; i++) { //공백
					System.out.printf("%3s", " ");
				}
				for(int i=0; i<5-2*blank; i++) { //숫자
					System.out.printf("%3d", count++);
				}
				System.out.println();
				if(blankIncreasing)
					blank++;
				else
					blank--;
				if(blank==target) {
					blankIncreasing=false;
					
				}
			}
		}
	}

