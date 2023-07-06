package com.example.mall_admin_api.mapper;

import com.example.mall_admin_api.entity.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Ming
* @description 针对表【good】的数据库操作Mapper
* @createDate 2023-07-05 20:38:05
* @Entity com.example.mall_admin_api.entity.Good
*/
@Mapper
public interface GoodMapper extends BaseMapper<Good> {

}




