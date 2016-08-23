package com.ufo.fang.center.crawler.processor;

import com.ufo.fang.center.model.HouseSourceSO;
import com.ufo.fang.center.crawler.pipeline.HouseSourcePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/***
 * 58同城处理器
 *
 * @author hekang
 * @created 2016/5/11
 */
public class TongChengProcessor implements PageProcessor {

    public static final String URL_LIST = "\\w+.58.com/ershoufang/pn\\d+/";

    public static final String URL_POST = "(http://((jump.jinpai)|(jump.jinpai)|(short)|(cs)){1}.58.com/([^# ]{50,}))";

    private Site site = Site
            .me()
//            .setDomain("blog.sina.com.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public void process(Page page) {
        //列表页
        if (page.getUrl().regex(URL_LIST).match()) {
            page.addTargetRequests(page.getHtml().links().regex(URL_POST).all());
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
        } else {
            //文章页
            if (page.getUrl().toString().length() < 50) {
                page.setSkip(true);
                return;
            }
            HouseSourceSO so = new HouseSourceSO();
            so.setUrl(page.getHtml().xpath("//[@id='main']//[@id='clickValId']/@value").toString());
            so.setTitle(page.getHtml().xpath("//[@id='main']//div[@class='mainTitle']/div[@class='bigtitle']/h1/text()").toString());
            so.setGradingName(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[3]/text()").toString());
            so.setDistrict(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[1]/text()").toString());
            so.setCbd(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[2]/text()").toString());
            Selectable publishPrice = page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[1]/div[@class='su_con']/span[1]/text()");
            so.setPublishPrice(Double.valueOf(publishPrice == null || publishPrice.toString() == null || publishPrice.toString().equals("null") ? "0" : publishPrice.toString()));
            so.setContact(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[8]/div[@class='su_con']//a[1]/text()").toString());
            so.setHouseTypeStr(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[4]/div[2]/text()").toString());
            so.setAddress(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[6]/div[@class='su_con']/text()").toString());
            so.setContactType(page.getHtml().xpath("//[@id='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[8]/div[@class='su_con']//em[1]/text()").toString());
            so.setDownloadUrls(page.getHtml().xpath("//[@id='main']//div[@class='description']//div[@class='descriptionImg']//img/@src").all());
            page.putField("so", so);
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws Exception {
//        Spider spider = Spider.create(new TongChengProcessor()).addUrl("http://cs.58.com/ershoufang/pn1/")
        Spider spider = Spider.create(new TongChengProcessor()).addUrl("http://short.58.com/zd_p/1a894422-fb4c-4c91-a10b-7e7fc33769ad/?target=xf-16-xgk_psfegvimob_30743110326382q-feykn&end=end&psid=124517920192915600012005345&entinfo=27102557298239_0")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new HouseSourcePipeline());
        spider.start();
    }

}
