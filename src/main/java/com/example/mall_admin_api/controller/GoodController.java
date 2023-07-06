package com.example.mall_admin_api.controller;

import com.example.mall_admin_api.entity.Category;
import com.example.mall_admin_api.entity.Good;
import com.example.mall_admin_api.service.GoodService;
import com.example.mall_admin_api.utils.Result;
import com.example.mall_admin_api.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @GetMapping("/getAllGood")
    public Result<List<Good>> getAllGood() {
        List<Good> goods = goodService.getAllGood();
        if (goods.size() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", goods);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
    @GetMapping("/getSeletedGood/{typeId}")
    public Result<List<Good>> getSeletedGood(@PathVariable("typeId") String typeId) {
        List<Good> goods = goodService.getSeletedGood(typeId);
        if (goods.size() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", goods);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
//    关键字查询
    @GetMapping("/search/{keyword}")
    public Result<List<Good>> search(@PathVariable("keyword") String keyword) {
        List<Good> goods = goodService.searchByKeyWord(keyword);
        if (goods.size() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", goods);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
    @DeleteMapping("/batchDelete/{ids}")
    public Result batchDelete(@PathVariable("ids") String ids) {
        Boolean flag = goodService.batchDelete(ids);
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
    @PutMapping("/updatePrice/{id}")
    public Result updatePrice(@PathVariable("id") String id, @RequestParam("buyPrice")  String buyPrice, @RequestParam("standardPrice")  String standardPrice) {
        Boolean flag = goodService.updatePrice(id, buyPrice, standardPrice);
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
    @PutMapping("/updateStock/{id}")
    public Result updateStock(@PathVariable("id") String id, @RequestParam("stock")  int stock) {
        Boolean flag = goodService.updateStock(id, stock);
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
    @PutMapping("/reduceStock/{id}")
    public Result reduceStock(@PathVariable("id") String id, @RequestParam("stock")  int stock) {
        Boolean flag = goodService.reduceStock(id, stock);
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
    @GetMapping("/getMaxBatch/{name}")
    public Result<String> getMaxBatch(@PathVariable("name") String name) {
        String maxBatch = goodService.getMaxBatch(name);
        if (maxBatch.length() > 0) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult("获取成功", maxBatch);
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("获取失败");
            return result;
        }
    }
    @PostMapping("/addGood")
    public Result addGood(
            @RequestParam("code") String code,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("characteristic") String characteristic,
            @RequestParam("batch") String batch,
            @RequestParam("pic") String pic,
            @RequestParam("stock") String stock,
            @RequestParam("buyPrice") String buyPrice,
            @RequestParam("standardPrice") String standardPrice,
            @RequestParam("currentPrice") String currentPrice,
            @RequestParam("createDate") String createDate,
            @RequestParam("deadline") String deadline
    ) {
        Boolean flag = goodService.addGood(code,name,type,characteristic,batch,pic,stock,buyPrice,standardPrice,currentPrice,createDate,deadline);
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
