package out;
import java.util.ArrayList;

public class TraceBuffer {
	
	public static ArrayList<String> buffer = new ArrayList<String>();
	
	public static void add(String line){
		buffer.add(line);
	}
	
	public static void flush(){
		while (buffer.size() > 0) {
			System.out.println(buffer.remove(0));
		}
	}
}
