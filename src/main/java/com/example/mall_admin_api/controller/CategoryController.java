package com.example.mall_admin_api.controller;

import com.example.mall_admin_api.entity.Category;
import com.example.mall_admin_api.entity.Good;
import com.example.mall_admin_api.service.CategoryService;
import com.example.mall_admin_api.utils.Result;
import com.example.mall_admin_api.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public Result<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        if (categories.size() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", categories);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
    @PostMapping("/addCategory")
    public Result<String> addCategory(@RequestParam("name")  String name) {
        Boolean flag = categoryService.addCategory(name);

        if (flag) {
            return ResultGenerator.genFailResult("添加成功");
        }
        return ResultGenerator.genSuccessResult("添加失败");
    }

    @PutMapping("/updateCategory")
    public Result updateCategory(@RequestParam("id")  String id, @RequestParam("name")  String name) {
        Boolean flag = categoryService.updateCategory(id, name);
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

    @DeleteMapping("/batchDelete/{ids}")
    public Result batchDelete(@PathVariable("ids") String ids) {
        Boolean flag = categoryService.batchDelete(ids);
        if (flag) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("删除成功", true);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("删除失败");
            return result;
        }
    }

    @GetMapping("/search/{keyword}")
    public Result<List<Category>> search(@PathVariable("keyword") String keyword) {
        List<Category> categories = categoryService.searchByKeyWord(keyword);
        if (categories.size() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", categories);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
}
