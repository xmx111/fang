package com.ufo.fang.center.constants;

import java.util.*;

/**
 * 键值类型
 * @author hekang@hitao.com
 * @created 2016年2月23日 上午10:53:26
 */
public class KeyValueType<K, V> {

	private String keyValueType;		//键类型
	private String name; 		//类型名称
	private final Map<K, KeyValue<K, V>> keyValueMap = new HashMap<K, KeyValue<K, V>>(); //键值映射
	
	@SafeVarargs
	public KeyValueType(String keyValueType, String name, KeyValue<K, V> ... keyValues) {
		this.keyValueType = keyValueType;
		this.name = name;
		if(keyValues != null && keyValues.length != 0) {
			for(KeyValue<K, V> kv : keyValues) {
				if(kv.getKey() != null) {
					keyValueMap.put(kv.getKey(), kv);
				}
			}
		}
	}
	
	public String getKeyValueType() {
		return keyValueType;
	}
	
	public String getName() {
		return name;
	}
	
	public V getValue(K key) {
		KeyValue<K, V> keyValue = keyValueMap.get(key);
		return keyValue.getValue();
	}
	
	public KeyValue<K, V> getKeyValue(K key) {
		KeyValue<K, V> keyValue = keyValueMap.get(key);
		return keyValue;
	}
	
	public List<KeyValue<K, V>> getKeyValueList() {
		Collection<KeyValue<K, V>> values = keyValueMap.values();
		return new ArrayList<KeyValue<K, V>>(Collections.unmodifiableCollection(values));
	}
}
