package com.ufo.fang.center.task;

import com.ufo.fang.center.crawler.TongchengCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 搜索定时任务
 *
 * @author hekang
 * @created 2016-08-16
 */
@Component
public class FindFangTasks {

    @Autowired
    TongchengCrawler tongchengCrawler;

    // 半分钟一次
    @Scheduled(fixedDelay = 30 * 1000, initialDelay = 30 * 10000000)
    public void crawler() {
        tongchengCrawler.crawlPage();
    }

}
