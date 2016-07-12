package com.ufo.fang.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/***
 * 多数据源设置
 *
 * @author hekang
 * @created 2016/5/9
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println(dataSourceKey.get());
        return dataSourceKey.get();
    }
}
