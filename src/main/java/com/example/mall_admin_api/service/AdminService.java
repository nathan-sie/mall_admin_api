package com.example.mall_admin_api.service;

import com.example.mall_admin_api.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Ming
* @description 针对表【admin】的数据库操作Service
* @createDate 2023-07-04 15:29:22
*/
public interface AdminService extends IService<Admin> {

    Boolean updatePassword(String username, String originalPassword, String newPassword);

    String login(String username, String password);
}
