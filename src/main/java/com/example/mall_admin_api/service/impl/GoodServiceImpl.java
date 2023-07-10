package com.example.mall_admin_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall_admin_api.entity.Category;
import com.example.mall_admin_api.entity.Good;
import com.example.mall_admin_api.service.GoodService;
import com.example.mall_admin_api.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.in;

/**
* @author Ming
* @description 针对表【good】的数据库操作Service实现
* @createDate 2023-07-05 20:38:05
*/
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good>
    implements GoodService{

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> getAllGood() {
        LambdaQueryWrapper<Good> queryWrapper = new LambdaQueryWrapper<Good>();
        queryWrapper
                .orderByDesc(Good::getBatch);
        return goodMapper.selectList(queryWrapper);
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
        int i = goodMapper.deleteBatchIds(list);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePrice(String id, String buyPrice, String standardPrice) {
        LambdaUpdateWrapper<Good> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Good::getBuyPrice, buyPrice)
                .set(Good::getStandardPrice, standardPrice)
                .eq(Good::getId, id); //lambda
//        表达式内的逻辑优先运算
        Good newGood = new Good();
        int result = goodMapper.update(newGood, updateWrapper);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Good> getSeletedGood(String typeId) {
        LambdaQueryWrapper<Good> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Good::getType, typeId);
        return goodMapper.selectList(queryWrapper);
    }

    @Override
    public List<Good> searchByKeyWord(String keyword) {
        QueryWrapper wrapper = new QueryWrapper<Good>()
                .like(StringUtils.isNotBlank(keyword),"name",keyword).or()
                .like(StringUtils.isNotBlank(keyword),"code",keyword).or()
                .like(StringUtils.isNotBlank(keyword),"type",keyword).or()
                .like(StringUtils.isNotBlank(keyword),"batch",keyword);
        return goodMapper.selectList(wrapper);
    }

    @Override
    public Boolean updateStock(String id, int stock) {
        Good good = goodMapper.selectById(id);
        LambdaUpdateWrapper<Good> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Good::getStock, good.getStock() + stock)
                .eq(Good::getId, id); //lambda
//        表达式内的逻辑优先运算
        Good newGood = new Good();
        int result = goodMapper.update(newGood, updateWrapper);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String getMaxBatch(String name) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String ds = sdf.format(date);

        LambdaQueryWrapper<Good> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Good::getName, name)
                .likeRight(Good::getBatch, ds)
                .orderByDesc(Good::getBatch);
        List<Good> goods = goodMapper.selectList(queryWrapper);
        if (goods.size() == 0) { return ds + "00"; }
        return goods.get(0).getBatch();
    }



    @Override
    public Boolean addGood(String code, String name, String type, String characteristic, String batch, String pic, String stock, String buyPrice, String standardPrice, String currentPrice, String createDate, String deadline) {
        Good newGood = null;
        if (currentPrice == null) { currentPrice = "0"; }
        try {
            if (Integer.parseInt(characteristic) == 1) {
                newGood = new Good(UUID.randomUUID().toString(), code,name,type,Integer.parseInt(characteristic),batch,pic,Integer.parseInt(stock), new BigDecimal(buyPrice),new BigDecimal(standardPrice),new BigDecimal(currentPrice),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createDate),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(deadline));
            } else if (Integer.parseInt(characteristic) == 2) {
                newGood = new Good(UUID.randomUUID().toString(), code,name,type,Integer.parseInt(characteristic),batch,pic,Integer.parseInt(stock), new BigDecimal(buyPrice),new BigDecimal(standardPrice),new BigDecimal(currentPrice),null,null);
            } else {
                newGood = new Good(UUID.randomUUID().toString(), code,name,type,Integer.parseInt(characteristic),batch,pic,Integer.parseInt(stock), new BigDecimal(buyPrice),new BigDecimal(standardPrice),new BigDecimal(currentPrice),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createDate),null);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = goodMapper.insert(newGood);
        return result == 1 ? true : false;
    }

    @Override
    public Boolean reduceStock(String id, int stock) {
        Good good = goodMapper.selectById(id);
        if ( good.getStock() < stock ) {
            return false;
        }
        LambdaUpdateWrapper<Good> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Good::getStock, good.getStock() - stock)
                .eq(Good::getId, id); //lambda
//        表达式内的逻辑优先运算
        Good newGood = new Good();
        int result = goodMapper.update(newGood, updateWrapper);
        if (result > 0) {
            return true;
        }
        return false;
    }


}




