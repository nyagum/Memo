import java.text.SimpleDateFormat;
import java.util.Scanner;

class View{	
	public int Remove(Scanner sc){
		System.out.println("삭제할 리스트의 번호를 입력하세요");
		
		String StringNumber=sc.nextLine();
		int number=Integer.parseInt(StringNumber);
		return number;
	}
	public int Update(Scanner sc){
		System.out.println("수정 할 리스트의 번호를 입력하세요");
		String StringNumber=sc.nextLine();
		return Integer.parseInt(StringNumber);
	}
	public void print(Memo m){
		System.out.println(m.getNo());
		System.out.println(m.getName());
		System.out.print(m.getContent());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String formatedDate=sdf.format(m.getDateTime());
		System.out.println("Date:"+formatedDate);
	}
	public int read(Scanner sc){
		System.out.println("읽고싶은 글의 인덱스를 입력하세요");
		String tempno=sc.nextLine();
		int tempNumber=0;
		try{
			tempNumber=Integer.parseInt(tempno);
		}catch(Exception e){
			e.printStackTrace();
		}
		return tempNumber;
	}
	public Memo create(Scanner sc, int lastindex){
		Memo memo=new Memo();
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("내용을 입력하세요");
		String content=sc.nextLine();
		memo.setNo(lastindex);
		memo.setDateTime(System.currentTimeMillis());
		memo.setName(name);
		memo.setContent(content);
		return memo;
	}
	
}