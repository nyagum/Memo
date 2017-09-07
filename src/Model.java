import java.util.ArrayList;

class Model{
	ArrayList<Memo> list=new ArrayList<>();
	int lastIndex=0;
	
	public int getLastIndex(){
		return this.lastIndex;
	}
	public void create(Memo memo){
		lastIndex++;
		list.add(memo);
	}
	public Memo getMemo(int index){
		return list.get(index);
	}
	public void Delete(int index){
		list.remove(index);
	}
	public void Update(int index, Memo m){
		list.set(index, m);
	}
}