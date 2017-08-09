package ua.training.hashmap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

public class HashMapTest {
	public Map<String,String> buildHashMap(){
		return new MyHashMap<String, String>();
	}
	
	@Test
	public void testSize() {
		Map<String,String> map = buildHashMap();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("one", "11");
		int expectedSize = 3;
		int actualSize = map.size();
		assertEquals(expectedSize , actualSize );
	}
	
	@Test
	public void testGetByReepetableKey() {
		Map<String,String> map = buildHashMap();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("one", "11");
		String expectedValue = "11";
		String actualValue = map.get("one");
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testRemove() {
		Map<String,String> map = buildHashMap();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		
		map.remove("one");
	
		String actualValue = map.get("one");
		assertNull( actualValue);
	}
	
}
