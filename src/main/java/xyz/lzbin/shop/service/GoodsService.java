package xyz.lzbin.shop.service;

import xyz.lzbin.shop.pojo.GoodsItem;
import xyz.lzbin.shop.result.DataTablesResult;

/**
 * @author lzb
 * 2019/12/9
 */
public interface GoodsService {
    DataTablesResult getGoodsList(int draw, int start, int length, String search, String orderCol, String orderDir);

    int count();

    boolean delete(int id);

    void changeStatus(int id, short status);

    GoodsItem create(GoodsItem goods);

    GoodsItem edit(GoodsItem goods);
}
