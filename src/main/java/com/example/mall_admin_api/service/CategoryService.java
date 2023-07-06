package com.example.mall_admin_api.service;

import com.example.mall_admin_api.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Ming
* @description 针对表【category】的数据库操作Service
* @createDate 2023-07-04 22:27:09
*/
public interface CategoryService extends IService<Category> {

    List<Category> getAllCategory();

    Boolean addCategory(String name);

    Boolean updateCategory(String id, String name);

    Boolean batchDelete(String ids);
}
