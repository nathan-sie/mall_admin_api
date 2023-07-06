package com.example.mall_admin_api.mapper;

import com.example.mall_admin_api.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Ming
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-07-04 15:29:22
* @Entity com.example.mall_admin_api.entity.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




