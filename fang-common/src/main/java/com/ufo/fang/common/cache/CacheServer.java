package com.ufo.fang.common.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 统一的缓存服务接口
 * 存入值 与  获取值
 *
 * 此接口的异常说明
 * 				当异常发生时，会记录日志的出错误信息，不会抛出
 * 				既然是异常，那就说平常都不需要关心他，但万一不幸发生了，可从以下原因着手排查问题
 * 				可能出现异常的情形
 *
 * 				1、集中式缓存异常，如果使用了集中式缓存容器(如阿里的OCS)，创建连接失败及网络异常等
 * 				2、可同步缓存异常，如果使用了同步缓存容器(如SyncCacheServer)，则在端口冲突或发送不成功或网络异常时，会抛异常，
 * 					  同步缓存说明：点对点通讯
 * 												同步机制使用 发布订阅的方式，即缓存更新者发布此消息（发送缓存数据），不等待各结点的返回结果
 * 												圈内的其他结点都接收此消息并处理（就是调用各自缓存容器的'put'方法），
 * 					  							由配置文件指定这个圈内的所有结点IP和绑定的端口，如果运行中有个别结点宕机了，
 * 												也不影响其他结点之间的同步，如果它启动了，则自动加入了同步成员中
 * 				3、数据加载异常，当使用本地内存容器且使用了CacheLoader委托加载数据，则可能会抛加载数据的异常（这属于业务异常，不是缓存的问题）
 * 					 CacheLoader委托加载数据 说明：在创建此缓存容器时，指定按key值获取value的实现逻辑，
 * 																		    则外界调用此缓存接口时，不需要往此缓存容器put值，直接调get方法即可
 * 																			如果是初次访问，则缓存容器会调  按key值获取value的实现逻辑 得到值，缓存并返回
 * 																			后续访问，就是直接返回值
 *                  这里提到的异常，是指  按key值获取value的实现逻辑  中发生了异常
 *             4、JAVA 内存溢出，这是由于对缓存容量估计错误或参数设置不当导致的，往往是对业务的访问频度和并发量等估计失误
 *
 *	注：如果key为null，如果是get，则返回null，否则，什么也不做
 * @Author qimao.huang
 * @CreateTime 2015年4月30日 下午3:43:08
 * @Company www.hitao.com
 */
public interface CacheServer<K, V> {

    /**
     * 获取值
     * @param key
     * @return  缓存值
     * 注：如果过程中出现异常，系统日志会记录下来并返回null
     */
    V get(K key, Class type);

    /**
     * 获取值
     * @param key
     * @return  缓存值
     * 注：如果过程中出现异常，系统日志会记录下来并返回null
     */
    V get(K key, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass);

    /**
     * 批量获取缓存
     * @param key		键
     * 				返回结果
     * 				true 只返回命中的值，返回集合的长度可能会比keys的小（当有一些没有命中时），但值顺序与keys中的键一致，只是跳过了那些没命中的值而已
     * 				false 返回的集合长度与keys一样，值的顺序也和keys一样。如果keys中有些key在缓存中没有命中值，则它的值为null
     * @return Collection<V>
     * 注：如果过程中出现异常，系统日志会记录下来并返回null或列表（里面的值都为null）
     */
    <T> List<T> getList(K key, Class type);

    /**
     * 存入值
     * 如果已有此key值的缓存，则替换之
     * @param key		key值
     * @param value	数据值
     * @return true 操作成功
     * 				 false 操作失败
     * 注：如果过程中出现异常，系统日志会记录下来
     */
    boolean put(K key, V value);

    /**
     * 删除缓存
     * 如果不存在此缓存，则相当于什么也不做
     * @param key	key值
     * @return true 操作成功
     * 				 false 操作失败
     * 注：如果过程中出现异常，系统日志会记录下来
     */
    boolean remove(K key);

    /**
     * 返回所有的缓存key值集合
     * 无序的
     * @return 如果缓存实现不支持获取键值集时 则返回emptyCollection  如ocs远程缓存服务
     * 注：如果过程中出现异常，系统日志会记录下来
     */
    Collection<K> keySet();

    /**
     * 清空所有缓存
     * 有的是使所有缓存失效，并且清空，失效后，内存可以被新的数据覆盖，如memcache
     * 不同的缓存，实现机制不同，但相同的是，对于访问者来说，通过key访问不到value值了
     * @return true 操作成功
     * 				 false 操作失败
     * 注：如果过程中出现异常，系统日志会记录下来
     */
    boolean cleanUp();

    /**
     * 清空所有缓存
     * 有的是使所有缓存失效，并且清空，失效后，内存可以被新的数据覆盖，如memcache
     * 不同的缓存，实现机制不同，但相同的是，对于访问者来说，通过key访问不到value值了
     * @return true 操作成功
     * 				 false 操作失败
     * 注：如果过程中出现异常，系统日志会记录下来
     */
    boolean cleanUp(String keyPrefix);
}
