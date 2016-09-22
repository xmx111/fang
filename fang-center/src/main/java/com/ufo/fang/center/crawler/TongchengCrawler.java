package com.ufo.fang.center.crawler;

import com.ufo.fang.center.crawler.downloader.FangHttpClientDownloader;
import com.ufo.fang.center.model.HouseSourceSO;
import com.ufo.fang.center.crawler.pipeline.HouseSourcePipeline;
import com.ufo.fang.center.crawler.processor.TongChengProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import javax.annotation.PostConstruct;

/***
 * 58同城爬虫
 *
 * @author hekang
 * @created 2016/8/11
 */
@Component
public class TongchengCrawler {

    private Spider spider;

    @Autowired
    HouseSourcePipeline houseSourcePipeline;

    public void crawl() {
        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"), houseSourcePipeline, HouseSourceSO.class).addUrl("http://cs.58.com/ershoufang/pn1").thread(5).run();
    }

    public boolean isRuning() {
        try {
            spider.thread(5);
        } catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }

    public void crawlPage() {
        if (!isRuning()) {
            initSpider();
            spider.start();
        }
    }

    @PostConstruct
    public void initSpider() {
        //spider = Spider.create(new TongChengProcessor()).addUrl("http://short.58.com/zd_p/1a894422-fb4c-4c91-a10b-7e7fc33769ad/?target=xf-16-xgk_psfegvimob_30743110326382q-feykn&end=end&psid=124517920192915600012005345&entinfo=27102557298239_0")
        spider = Spider.create(new TongChengProcessor()).addUrl("http://cs.58.com/ershoufang/pn1/")
                .thread(5)
                .setDownloader(new FangHttpClientDownloader())
                .addPipeline(houseSourcePipeline);
    }
}
