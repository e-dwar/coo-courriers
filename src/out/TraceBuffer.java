package out;
import java.util.ArrayList;

public class TraceBuffer {
	
	private static ArrayList<String> buffer = new ArrayList<String>();
	
	public static void add(Object line){
		buffer.add(line.toString());
	}
	
	public static void error (Exception e) {
		add("Error: " + e);
	}
	
	public static void cr () {
		add("");
	}
	
	public static void flush(){
		while (buffer.size() > 0) {
			System.out.println(buffer.remove(0));
		}
	}
}
