
/**
 * 출력 ->System.out.print();
 * 입력 ->Scanner(System.in)
 * @author anya
 *
 */

// 개별 글 한개를 저장하는 클래스
class Memo{
	private String name;
	private String content;
	private int no;
	private long dateTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String conents) {
		this.content = conents;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public long getDateTime() {
		return dateTime;
	}
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
	
}