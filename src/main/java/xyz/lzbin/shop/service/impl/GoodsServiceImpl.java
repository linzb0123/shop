package xyz.lzbin.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.GoodsItemMapper;
import xyz.lzbin.shop.exception.ResultBodyException;
import xyz.lzbin.shop.pojo.GoodsItem;
import xyz.lzbin.shop.pojo.GoodsItemExample;
import xyz.lzbin.shop.pojo.StoreOwner;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.service.GoodsService;

import java.util.Date;
import java.util.List;

/**
 * @author lzb
 * 2019/12/9
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsItemMapper goodsMapper;

    @Override
    public DataTablesResult getGoodsList(int draw, int start, int length, String search, String orderCol, String orderDir) {
        DataTablesResult result = new DataTablesResult();
        try {
            PageHelper.startPage(start / length + 1, length);
            List<GoodsItem> list = goodsMapper.selectGoodsList("%" + search + "%", orderCol, orderDir);
            PageInfo<GoodsItem> pageInfo = new PageInfo<>(list);
            result.setRecordsFiltered((int) pageInfo.getTotal());
            result.setRecordsTotal(count());
            result.setDraw(draw);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int count() {
        return goodsMapper.countByExample(new GoodsItemExample());
    }

    @Override
    public boolean delete(int id) {
        int count = goodsMapper.deleteByPrimaryKey(id);
        return count > 0;
    }

    @Override
    public void changeStatus(int id, short status) {
        try {
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setId(id);
            goodsItem.setStatus(status);
            goodsMapper.updateByPrimaryKeySelective(goodsItem);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }

    }

    @Override
    public GoodsItem create(GoodsItem goods){
        try{
            goods.setStatusTime(new Date());
            goods.setStatus((short)0);
            goods.setStoreId(1);
            goodsMapper.insertSelective(goods);
        }catch (Exception e){
            throw new ResultBodyException(e.getMessage());
        }
        return goods;
    }

    @Override
    public GoodsItem edit(GoodsItem goods){
        try{
            goodsMapper.updateByPrimaryKeySelective(goods);
        }catch (Exception e){
            throw new ResultBodyException(e.getMessage());
        }
        return goods;
    }

}
