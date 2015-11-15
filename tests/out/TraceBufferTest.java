package out;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.*;

import testdouble.TraceBufferDouble;

public class TraceBufferTest {

    private PrintStream original;

    @Before
    public void before() {
        original = System.out;
        System.setOut(new PrintStream(new NullByteArrayOutputStream()));
        TraceBufferDouble.getBuffer().clear();
    }

    @After
    public void after() {
        System.setOut(original);
    }

    @Test
    public void addTest() {
        assertEquals(0, TraceBufferDouble.getBuffer().size());
        TraceBufferDouble.add("temp");
        assertEquals(1, TraceBufferDouble.getBuffer().size());
    }

    @Test
    public void errorTest() {
        assertEquals(0, TraceBufferDouble.getBuffer().size());
        TraceBufferDouble.error(new Exception("temp"));
        assertEquals(1, TraceBufferDouble.getBuffer().size());
    }

    @Test
    public void flushTest() {
        assertEquals(0, TraceBufferDouble.getBuffer().size());
        TraceBufferDouble.add("temp1");
        TraceBufferDouble.add("temp2");
        assertEquals(2, TraceBufferDouble.getBuffer().size());
        TraceBufferDouble.flush();
        assertEquals(0, TraceBufferDouble.getBuffer().size());
    }

    @Test
    public void crTest() {
        assertEquals(0, TraceBufferDouble.getBuffer().size());
        TraceBufferDouble.cr();
        assertEquals(1, TraceBufferDouble.getBuffer().size());
    }
}
