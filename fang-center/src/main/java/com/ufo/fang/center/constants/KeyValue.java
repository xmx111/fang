package com.ufo.fang.center.constants;

/**
 * 键值对象
 * @author zhangzhiwen@hitao.com
 * @created 2016年2月23日 上午10:53:14
 */
public class KeyValue<K, V> implements Comparable<KeyValue<K, V>> {

	private K key;		//键值
	private V value; 	//描述信息
	private int sort;		//排序
	
	private static final int DEFAULT_SORT_CODE = -1;	//默认排序id
	
	public KeyValue(K key, V value){
		this(key, value, DEFAULT_SORT_CODE);
	}
	
	public KeyValue(K key, V value, int sort){
		this.key = key;
		this.value = value;
		this.sort = sort;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public int getSort() {
		return sort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyValue<K, V> other = (KeyValue<K, V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("KeyValue [key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(KeyValue<K, V> other) {
	    int otherSort = other.getSort();
	    int thisSort = getSort();
	    if (thisSort < otherSort) {
	    	return -1;
	    } else if (thisSort == otherSort) {
	    	return 0;
	    } else {
	    	return 1;
	    }
	}

}
