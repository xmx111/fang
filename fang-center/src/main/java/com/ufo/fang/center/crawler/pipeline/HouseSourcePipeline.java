package com.ufo.fang.center.crawler.pipeline;

import com.ufo.fang.center.model.HouseSourceSO;
import com.ufo.fang.center.service.housesource.HouseSourceService;
import com.ufo.fang.common.exceptions.ServiceException;
import com.ufo.fang.common.util.FileUtils;
import com.ufo.fang.common.util.UUIDUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.regex.Pattern;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/8/12
 */
@Component("houseSourcePipeline")
public class HouseSourcePipeline implements Pipeline, PageModelPipeline<HouseSourceSO> {

    @Value("img.path")
    private String imgPath = "D:\\img_download\\";

    @Resource
    private HouseSourceService houseSourceService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        HouseSourceSO so = resultItems.get("so");
        // 检查
        if (check(so) == false)
            return;
        downloadImg(so);
        initParams(so);
        try {
            houseSourceService.add(so.toHouseSource());
        } catch (ServiceException e){

        }
    }

    public void process(HouseSourceSO so, Task task) {
        // 检查
        if (check(so) == false)
            return;
        downloadImg(so);
        initParams(so);
        try {
            houseSourceService.add(so.toHouseSource());
        } catch (ServiceException e){

        }
    }

    /**
     * 检查抓取的内容
     * @param so
     * @return
     */
    private boolean check(HouseSourceSO so){
        if (so == null || so.getTitle() == null)
            return false;
        if (so.getContactType().indexOf("个人") == -1)
            return false;
        return true;
    }

    /**
     * 下载图片
     * @param so
     * @return
     */
    private HouseSourceSO downloadImg(HouseSourceSO so){
        if (CollectionUtils.isNotEmpty(so.getDownloadUrls())){
            CloseableHttpClient httpclient = HttpClients.createDefault();
            for (String url : so.getDownloadUrls()){
                try {
                    String path = FileUtils.getDateFolder(imgPath);
                    //这里先判断文件夹名是否存在，不存在则建立相应文件夹
                    Path target = Paths.get(path);
                    if (!Files.isReadable(target)) {
                        Files.createDirectories(target);
                    }

                    String extName = url.substring(url.lastIndexOf('.') + 1);
                    String imgFileNameNew = FileUtils.getFilePath(path, extName);

                    //这里通过httpclient下载之前抓取到的图片网址，并放在对应的文件中
                    HttpGet httpget = new HttpGet(url);
                    HttpResponse response = httpclient.execute(httpget);
                    HttpEntity entity = response.getEntity();
                    InputStream in = entity.getContent();

                    File file = new File(imgFileNameNew.toString());

                    try {
                        FileOutputStream fout = new FileOutputStream(file);
                        int l = -1;
                        byte[] tmp = new byte[1024];
                        while ((l = in.read(tmp)) != -1) {
                            fout.write(tmp, 0, l);
                        }
                        fout.flush();
                        fout.close();
                        so.setImgUrls(StringUtils.trimToEmpty(so.getImgUrls()) + imgFileNameNew + ",");
                    } finally {
                        in.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return so;
    }

    /**
     * 初始化参数
     * @param so
     * @return
     */
    private HouseSourceSO initParams(HouseSourceSO so){
        so.setUuid(UUIDUtils.getUUID());
        if (so.getHouseTypeStr() != null){
            String[] houseTypes = StringUtils.split(so.getHouseTypeStr());
            Pattern pattern = Pattern.compile("/d+");
            String str;
            for (String type : houseTypes){
                try {
                    str = pattern.matcher(type).group();
                    if (type.indexOf("室") != -1) {
                        so.setRoom(Integer.parseInt(str));
                    } else if (type.indexOf("厅") != -1) {
                        so.setHall(Integer.parseInt(str));
                    } else if (type.indexOf("厨") != -1) {
                        so.setKitchen(Integer.parseInt(str));
                    } else if (type.indexOf("卫") != -1) {
                        so.setToilet(Integer.parseInt(str));
                    } else if (type.indexOf("套内") != -1) {
                        so.setUsableArea(Double.parseDouble(str));
                    } else if (type.indexOf("㎡") != -1) {
                        so.setBuildingArea(Double.parseDouble(str));
                    }
                } catch (Exception e){

                }
            }
        }
        return so;
    }
}
