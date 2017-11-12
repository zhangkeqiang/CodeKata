package kata.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kata.IncomeTax;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    private Map bundle;
    @Test
    public final void testMockAnnotation(){
        String keyString = "keyhello";
        String valueString = "hello";
        when(bundle.get(keyString)).thenReturn(valueString);
        assertEquals(valueString, bundle.get(keyString));
    }
	@Test
	public final void testMock_IncomeTax1() {
		IncomeTax mockIncomeTax = mock(IncomeTax.class);
		when(mockIncomeTax.calculate(45600)).thenReturn((double) 234);
		Assert.assertEquals((double) 234, mockIncomeTax.calculate(45600), 1);
	}

	@Test
	public final void testMock_IncomeTax2() {
		IncomeTax mockIncomeTax = mock(IncomeTax.class);
		when(mockIncomeTax.calculate(anyInt())).thenReturn((double) 234);
		Assert.assertEquals((double) 234, mockIncomeTax.calculate(45600), 1);
		Assert.assertEquals((double) 234, mockIncomeTax.calculate(434), 1);
		verify(mockIncomeTax).calculate(434);
	}

	@Test
	public void when_thenReturn() {
		// mock一个Iterator类
		Iterator iterator = mock(Iterator.class);
		// 预设当iterator调用next()时第一次返回hello，第n次都返回world
		when(iterator.next()).thenReturn("hello").thenReturn("world");
		// 使用mock的对象
		String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
		// 验证结果
		assertEquals("hello world world", result);
	}

	@Test(expected = IOException.class)
	public void when_thenThrow() throws IOException {
		OutputStream outputStream = mock(OutputStream.class);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream);
		// 预设当流关闭时抛出异常
		doThrow(new IOException()).when(outputStream).close();
		outputStream.close();
	}

	@Test
	public void with_arguments() {
		Comparable comparable = mock(Comparable.class);
		// 预设根据不同的参数返回不同的结果
		when(comparable.compareTo("Test")).thenReturn(1);
		when(comparable.compareTo("Omg")).thenReturn(2);
		assertEquals(1, comparable.compareTo("Test"));
		assertEquals(2, comparable.compareTo("Omg"));
		// 对于没有预设的情况会返回默认值
		assertEquals(0, comparable.compareTo("Not stub"));
	}

	@Test
	public void with_unspecified_arguments() {
		List list = mock(List.class);
		// 匹配任意参数
		when(list.get(anyInt())).thenReturn(1);
		when(list.contains(1)).thenReturn(true);
		assertEquals(1, list.get(1));
		assertEquals(1, list.get(999));
		assertTrue(list.contains(new Integer(1)));
		assertTrue(!list.contains(3));
	}

	@Test
	public void verifying_number_of_invocations() {
		List list = mock(List.class);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		// 验证是否被调用一次，等效于下面的times(1)
		verify(list).add(1);
		verify(list, times(1)).add(1);
		// 验证是否被调用2次
		verify(list, times(2)).add(2);
		// 验证是否被调用3次
		verify(list, times(3)).add(3);
		// 验证是否从未被调用过
		verify(list, never()).add(4);
		// 验证至少调用一次
		verify(list, atLeastOnce()).add(1);
		// 验证至少调用2次
		verify(list, atLeast(2)).add(2);
		// 验证至多调用3次
		verify(list, atMost(3)).add(3);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)  
	public void spy_on_real_objects(){  
	    List list = new LinkedList();  
	    List spy = spy(list);  
	    //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常  
	    //when(spy.get(0)).thenReturn(3);  
	  
	    //使用doReturn-when可以避免when-thenReturn调用真实对象api  
	    doReturn(999).when(spy).get(999);  
	    //预设size()期望值  
	    when(spy.size()).thenReturn(100);  
	    //调用真实对象的api  
	    spy.add(1);  
	    spy.add(2);  
	    assertEquals(100,spy.size());  
	    assertEquals(1,spy.get(0));  
	    assertEquals(2,spy.get(1));  
	    verify(spy).add(1);  
	    verify(spy).add(2);  
	    assertEquals(999,spy.get(999));  
	    assertEquals(100, spy.size());
	    System.out.println("spy.get(1) = " + spy.get(1));
	    assertEquals(3,spy.get(2));  
	    
	}  
}
