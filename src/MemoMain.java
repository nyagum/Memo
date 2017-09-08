import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoMain {
	private Model model=new Model();
	private View view=new View();
	
	public static void main(String[] args) {
		// 입력을 받아서 처리하는 도구
		Scanner sc=new Scanner(System.in);
		MemoMain main=new MemoMain();
		
		// 명령어를 입력받아서 후속처리
		// c-create:데이터 입력모드로 전환
		// r-read: 데이터 읽기모드로 전환 
		// u -update: 데이터 수정모드로 전환
		// d-delte: 데이터 삭제모드로 전환 
		String command="";
		
		while(!command.equals("exit")){
			System.out.println("------------명령어를 입력하세요------------");
			System.out.println("c:쓰기  r:읽기  u:수정  d:삭제 l:목록보기");
			System.out.println("exit : 종료");
			command=sc.nextLine(); // 키보드 입력중에 Enter키가 입력될 때까지 대기
			Memo memo;
			//명령어를 분기
			switch(command){
				case "c":
				case "C":
					memo=main.view.create(sc, main.model.lastIndex);
					// 메모 데이터에 대한 조작이 필요한 경우모두 컨트롤러에서 작업한다.
					main.model.create(memo);
					break;
				case "r":
				case "R":
					int tempNumber=main.view.read(sc);
					main.view.print(main.model.getMemo(tempNumber));
					break;
				case "u":
				case "U":
					main.showList(main.model.list);
					int t=main.view.Update(sc);
					Memo tempMemo=main.view.create(sc, main.model.lastIndex);
					main.model.Update(t, tempMemo);
					break;
				case "d":
				case "D":
					main.model.Delete(main.view.Remove(sc));
					break;
				case "l":
				case "L":
					main.showList(main.model.getList());
					break;
			}
		}
		
		System.out.println("시스템이 종료 되었습니다!");
	}
	public int Update(Scanner sc){
		System.out.println("수정 할 리스트의 번호를 입력하세요");
		String StringNumber=sc.nextLine();
		
		int number=Integer.parseInt(StringNumber);
		return number;		
	}
	
	public void showList(ArrayList<Memo> list){
		for(Memo m:list){
			System.out.println("No: "+m.getNo());
			System.out.println("Name: "+m.getName());
			System.out.println("content: "+m.getContent());
		}
	}
}