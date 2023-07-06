package com.example.mall_admin_api.service;

import com.example.mall_admin_api.entity.Good;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Ming
* @description 针对表【good】的数据库操作Service
* @createDate 2023-07-05 20:38:05
*/
public interface GoodService extends IService<Good> {

    List<Good> getAllGood();

    Boolean batchDelete(String ids);

    Boolean updatePrice(String id, String buyPrice, String standardPrice);

    List<Good> getSeletedGood(String typeId);

    List<Good> searchByKeyWord(String keyword);

    Boolean updateStock(String id, int stock);

    String getMaxBatch(String name);

    Boolean addGood(String code, String name, String type, String characteristic, String batch, String pic, String stock, String buyPrice, String standardPrice, String currentPrice, String createDate, String deadline);

    Boolean reduceStock(String id, int stock);
}
