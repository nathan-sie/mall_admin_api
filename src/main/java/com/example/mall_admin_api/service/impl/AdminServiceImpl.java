package com.example.mall_admin_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall_admin_api.entity.Admin;
import com.example.mall_admin_api.service.AdminService;
import com.example.mall_admin_api.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
* @author Ming
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2023-07-04 15:29:22
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Boolean updatePassword(String username, String originalPassword, String newPassword) {
        LambdaUpdateWrapper<Admin> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Admin::getPassword, newPassword)
                .eq(Admin::getUsername, username)
                .eq(Admin::getPassword, originalPassword); //lambda
//        表达式内的逻辑优先运算
        Admin newUser = new Admin();
        int result = adminMapper.update(newUser, updateWrapper);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String login(String username, String password) {
        LambdaQueryWrapper<Admin>  queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Admin::getUsername, username)
                .eq(Admin::getPassword, password);
        Admin admin = adminMapper.selectOne(queryWrapper);
        if (admin == null) {
            //用户不存在，创建一个新用户并且保存到数据库中(注册)
            return "";
        } else {
            //随机生成一个token
            String token = UUID.randomUUID().toString() + "&" + admin.getUsername().toString();
            return token;
        }
    }
}




