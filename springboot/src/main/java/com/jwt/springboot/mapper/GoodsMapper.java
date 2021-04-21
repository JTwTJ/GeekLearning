package com.jwt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jwt.springboot.dao.Goods;
import com.jwt.springboot.mysql.DataSource;
import com.jwt.springboot.mysql.DataSourceType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail
 */
@Mapper
@DataSource(DataSourceType.SourceType.Study_Demo)
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 查询记录条数
     *
     * @return 记录条数
     */
    Integer selectRecordsCount();
}
