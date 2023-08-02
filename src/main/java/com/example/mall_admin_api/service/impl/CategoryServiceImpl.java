package com.example.mall_admin_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall_admin_api.entity.Admin;
import com.example.mall_admin_api.entity.Category;
import com.example.mall_admin_api.service.CategoryService;
import com.example.mall_admin_api.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author Ming
* @description 针对表【category】的数据库操作Service实现
* @createDate 2023-07-04 22:27:09
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectList(null);
    }

    @Override
    public Boolean addCategory(String name) {
        Category category = new Category(UUID.randomUUID().toString(), name, new Date());
        int result = categoryMapper.insert(category);
        return result == 1 ? true : false;
    }

    @Override
    public Boolean updateCategory(String id, String name) {
        LambdaUpdateWrapper<Category> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Category::getName, name)
                .eq(Category::getId, id); //lambda
//        表达式内的逻辑优先运算
        Category newCategory = new Category();
        int result = categoryMapper.update(newCategory, updateWrapper);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDelete(String ids) {
        List list = new ArrayList();
        if (ids.contains("&")) {
            String[] newIds = ids.split("&");
            list = Arrays.asList(newIds);
        } else {
            list = Arrays.asList(ids);
        }
        int i = categoryMapper.deleteBatchIds(list);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Category> searchByKeyWord(String keyword) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>();
        queryWrapper
                .like(Category::getName, keyword);
        return categoryMapper.selectList(queryWrapper);
    }
}




