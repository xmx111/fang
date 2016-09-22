package com.ufo.fang.center.dao.housesourceimages.impl;

import com.ufo.fang.center.dao.housesourceimages.HouseSourceImagesDAO;
import com.ufo.fang.center.dao.housesourceimages.mapper.HouseSourceImagesMapper;
import com.ufo.fang.center.model.HouseSourceImages;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * HouseSourceImages数据库操作DAO实现
 *
 * @author generator
 * @created 2016-08-25
 */
@Repository
public class HouseSourceImagesDAOImpl extends BaseDAOImpl<HouseSourceImages, Long> implements HouseSourceImagesDAO {

    @Autowired
    HouseSourceImagesMapper houseSourceImagesMapper;

    @Override
    protected BaseMapper<HouseSourceImages, Long> getMapper() {
        return houseSourceImagesMapper;
    }

}
