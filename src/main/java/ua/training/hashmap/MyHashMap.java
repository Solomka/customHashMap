package ua.training.hashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

	private static final int DEFAULT_TABLE_CAPACITY = 16;
	private int size;
	private Entry<K, V>[] entries = new Entry[DEFAULT_TABLE_CAPACITY];
	//TODO: add loadFactor

	private static class Entry<K, V> {
		private K key;
		private V value;
		private int hashCode;
		private Entry<K, V> next;

		public Entry(K key, V value, int hashCode) {
			super();
			this.key = key;
			this.value = value;
			this.hashCode = hashCode;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public V get(Object key) {
		int hashCode = key.hashCode();
		int index = getIndex(hashCode);
		
		if (entries[index] == null) {
			return null;
		}
		Entry<K,V> current = entries[index];
		while(current!=null) {
			if (current.key.hashCode() == hashCode
					&& current.key.equals(key)){
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	public V put(K key, V value) {
		int hashCode = key.hashCode();

		int index = getIndex(hashCode);

		if (entries[index] == null) {
			entries[index] = new Entry<K, V>(key, value, hashCode);
			size++;
		} else {
			Entry<K, V> current = entries[index];
			while (current != null) {
				if (current.hashCode == hashCode && current.key.equals(key)) {
					V tempPrev = current.value;
					current.value = value;
					return tempPrev;
				}
				current = current.next;
			}
			// key not found
			Entry<K, V> newEntry = new Entry<K, V>(key, value, hashCode);
			newEntry.next = entries[index];
			entries[index] = newEntry;
			size++;
		}
		return value;
	}

	private int getIndex(int hashCode) {
		int index = (hashCode ^ (hashCode >> 16)) & (entries.length - 1);
		return index;
	}

	public V remove(Object key) {
		int hashCode = key.hashCode();
		int index = getIndex(hashCode);
		if (entries[index] == null) {
			return null;
		}
		else {
			Entry<K, V> current = entries[index];
			Entry<K, V> previous = null;

			while (current != null) {
				if (current.hashCode == hashCode 
						&& current.key.equals(key)) {
					V temp = current.value;
					if (previous != null) {
						previous.next = current.next;
					}
					else {
						entries[index] = current.next;
					}
					size--;
					return temp;
				}
			}
			return null;
		}

		
		
	
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
