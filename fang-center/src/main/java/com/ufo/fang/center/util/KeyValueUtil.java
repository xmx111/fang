package com.ufo.fang.center.util;

import com.ufo.fang.center.constants.CommonDic;
import com.ufo.fang.center.constants.KeyValue;
import com.ufo.fang.center.constants.KeyValueType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 键值工具类,将字典信息汇总，统一处理
 * @author zhangzhiwen@hitao.com
 * @created 2016年2月23日 上午10:30:38
 */
public class KeyValueUtil {
	private static final Map<String, KeyValueType<?, ?>> keyValueTypeMap = new HashMap<String, KeyValueType<?, ?>>();
	
	static {
		load(CommonDic.IS_BOOLEAN, CommonDic.STATUS, CommonDic.LOCK_STATUS, CommonDic.SEX);
	}
	
	private static void load(KeyValueType<?, ?> ... keyValueTypes) {
		if(keyValueTypes != null && keyValueTypes.length != 0) {
			for(KeyValueType<?, ?> keyValueType : keyValueTypes) {
				if(keyValueTypeMap.get(keyValueType.getKeyValueType()) != null) {
					throw new RuntimeException(String.format("存在重复的keyValueType定义[]，请检查字典定义，去除重复", keyValueType.getKeyValueType()));
				}
				keyValueTypeMap.put(keyValueType.getKeyValueType(), keyValueType);
			}
			
		}
	}
	
	/**
	 * 根据键类型和键，返回值信息
	 * @param keyValueType
	 * @param key
	 * @return
	 */
	public static <K, V> V getValue(String keyValueType, K key) {
		KeyValue<K, V> kv = getKeyValue(keyValueType, key);
		if(kv == null) {
			return null;
		}
		return kv.getValue();
	}
	
	/**
	 * 根据键类型和键，返回键值对象信息
	 * @param keyValueType
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> KeyValue<K, V> getKeyValue(String keyValueType, K key) {
		KeyValueType<K, V> kvType = (KeyValueType<K, V>) keyValueTypeMap.get(keyValueType);
		if(kvType == null) {
			return null;
		}
		KeyValue<K, V> kv = kvType.getKeyValue(key);
		return kv;
	}
	
	/**
	 * 根据键类型和键，返回值信息
	 * @param keyValueType
	 * @param key
	 * @return
	 */
	public static <K, V> String getValue(KeyValueType<K, V> keyValueType, K key) {
		return getValue(keyValueType.getKeyValueType(), key);
	}
	
	/**
	 * 根据键类型和键，返回键值对象信息
	 * @param keyValueType
	 * @param key
	 * @return
	 */
	public static <K, V> KeyValue<K, V> getKeyValue(KeyValueType<K, V> keyValueType, K key) {
		return getKeyValue(keyValueType.getKeyValueType(), key);
	}
	
	/**
	 * 返回keyValue对象的list
	 * @param keyValueType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> List<KeyValue<K, V>> getKeyValueList(String keyValueType) {
		KeyValueType<K, V> kvType = (KeyValueType<K, V>) keyValueTypeMap.get(keyValueType);
		if(kvType == null) {
			return null;
		}
		return kvType.getKeyValueList();
	}
	
	/**
	 * 返回keyValue对象的排序list
	 * @param keyValueType
	 * @return
	 */
	public static <K, V> List<KeyValue<K, V>> getKeyValueSortList(String keyValueType) {
		List<KeyValue<K, V>> keyValueList = getKeyValueList(keyValueType);
		Collections.sort(keyValueList);
		return keyValueList;
	}
	
	/**
	 * 返回keyValue对象的排序list
	 * @param keyValueType
	 * @return
	 */
	public static <K, V> List<KeyValue<K, V>> getKeyValueSortList(KeyValueType<K, V> keyValueType) {
		List<KeyValue<K, V>> keyValueList = getKeyValueSortList(keyValueType.getKeyValueType());
		return keyValueList;
	}
	
	/**
	 * 返回key，value的映射map
	 * @param keyValueType
	 * @return
	 */
	public static <K, V> Map<K, V> getKeyValueMap(String keyValueType) {
		List<KeyValue<K, V>> keyValueList = getKeyValueList(keyValueType);
		Map<K, V> keyValueMap = new HashMap<K, V>();
		for(KeyValue<K, V> kv : keyValueList) {
			keyValueMap.put(kv.getKey(), kv.getValue());
		}
		return keyValueMap;
	}
	
	public static <K, V> Boolean isExistsKey(KeyValueType<K, V> keyValueType,  K key) {
		if(key == null) {
			return Boolean.FALSE;
		}
		KeyValue<K, V> keyValue = keyValueType.getKeyValue(key);
		if(keyValue != null) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
