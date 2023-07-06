package com.example.mall_admin_api.controller;

import com.example.mall_admin_api.utils.Result;
import com.example.mall_admin_api.utils.ResultGenerator;
import com.example.mall_admin_api.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<String> login(@RequestParam("username")  String username, @RequestParam("password") String password) {
        String token = adminService.login(username, password);

        if ("".equals(token)) {
            return ResultGenerator.genFailResult("登录失败");
        }
        return ResultGenerator.genSuccessResult("登录成功", token);
    }

    @PutMapping("/updatePassword")
    public Result updateInfo(
            @RequestParam("username") String username,
            @RequestParam("originalPassword") String originalPassword,
            @RequestParam("newPassword") String newPassword) {
        Boolean flag = adminService.updatePassword(username, originalPassword, newPassword);
        if (flag) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("修改成功", true);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("修改失败");
            return result;
        }
    }
}
