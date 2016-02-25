package org.shl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.shl.StreamExample;

public class StreamTest {
	List<String> data =Arrays.asList("Raja","Shailendra","Satish","","");
	StreamExample s1=new StreamExample();
	/*
	 * Find the count of empty name in a list of string
	 */
	@Test
	public void whenListHaveTwoEmptyStringThenReturnTwo(){
		assertEquals(s1.getEmptyElementCount(data), 2);
	}
	
	@Test
	public void whenListHaveTwoEmptyStringShouldNotReturnMoreOrLess(){
		assertNotEquals(s1.getEmptyElementCount(data), 1);
		assertNotEquals(s1.getEmptyElementCount(data), 3);
	}
	
}
