import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Model{
	private final String DB_DIR="/Users/anya/Desktop/AnyaWork/java/database";
	private final String DB_FILE="memo.txt";
	private File database=null;
	private final String COLUMN_SEP="::";
	
	ArrayList<Memo> list=new ArrayList<>();
	int lastIndex=0;
	
	public Model(){
		File dir=new File(DB_DIR);
		if(dir.exists()){
			dir.mkdirs(); // 경로상에 디렉토리가 업승면 자동생성
		}
		File file=new File(DB_DIR+File.separator+DB_FILE);
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public int getLastIndex(){
		return this.lastIndex;
	}
	public void create(Memo memo){
		memo.setNo(lastIndex);
		
		try(FileOutputStream fos=new FileOutputStream(DB_DIR+File.separator+DB_FILE,true)){
			
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			
			bw.append(memo.getNo()+COLUMN_SEP+
					memo.getName()+COLUMN_SEP+
					memo.getContent()+COLUMN_SEP+
					memo.getDateTime()+"\n");
			
			bw.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		list.add(memo);
		lastIndex++;
		
	}
	public ArrayList<Memo> getList(){
		
		list.clear();
		try(FileInputStream fis=new FileInputStream(DB_DIR+File.separator+DB_FILE)){
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			String row;
			while((row=br.readLine())!=null){
				String[] tempRow=row.split(COLUMN_SEP);
				Memo m=new Memo();
				m.setNo(Integer.parseInt(tempRow[0]));
				m.setName(tempRow[1]);
				m.setContent(tempRow[2]);
				m.setDateTime(Long.parseLong(tempRow[3]));
				list.add(m);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return list;
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