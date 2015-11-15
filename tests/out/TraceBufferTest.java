package out;

import static org.junit.Assert.*;

import org.junit.*;

public class TraceBufferTest {
	
	@Before
	public void init(){
		TraceBuffer.getBuffer().clear();
	}
	
	@Test
	public void addTest() {
		assertEquals(0, TraceBuffer.getBuffer().size());
		TraceBuffer.add("temp");
		assertEquals(1, TraceBuffer.getBuffer().size());
	}
	
	@Test
	public void errorTest(){
		assertEquals(0, TraceBuffer.getBuffer().size());
		TraceBuffer.error(new Exception("temp"));
		assertEquals(1, TraceBuffer.getBuffer().size());
	}
	
	
	
	@Test
	public void flushTest() {
		assertEquals(0, TraceBuffer.getBuffer().size());
		TraceBuffer.add("temp1");
		TraceBuffer.add("temp2");
		assertEquals(2, TraceBuffer.getBuffer().size());
		TraceBuffer.flush();
		assertEquals(0, TraceBuffer.getBuffer().size());
	}

	@Test
	public void crTest() {
		assertEquals(0, TraceBuffer.getBuffer().size());
		TraceBuffer.cr();
		assertEquals(1, TraceBuffer.getBuffer().size());
	}
}
