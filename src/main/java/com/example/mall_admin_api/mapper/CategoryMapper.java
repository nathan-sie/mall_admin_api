package com.example.mall_admin_api.mapper;

import com.example.mall_admin_api.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Ming
* @description 针对表【category】的数据库操作Mapper
* @createDate 2023-07-04 22:27:09
* @Entity com.example.mall_admin_api.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




