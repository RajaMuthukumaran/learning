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
	
	@Test
	public void shouldReturnExactCountWhenStringMatchesToList(){
		assertEquals(s1.getCountOfStringWithMatchesString(data, "Sh"),2);
	}
	
	@Test
	public void shouldReturnZeroWhenStringDoesnotMatchesToList(){
		assertEquals(s1.getCountOfStringWithMatchesString(data, "Test"),0);
	}
	
	@Test
	public void shouldReturnConcatenatedNonEmptyString(){
		assertEquals(s1.concatenateNonEmptyString(data),"Raja,Shailendra,Satish");
	}
}
