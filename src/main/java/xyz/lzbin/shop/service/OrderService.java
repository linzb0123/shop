package xyz.lzbin.shop.service;

import xyz.lzbin.shop.pojo.OrderItem;
import xyz.lzbin.shop.result.DataTablesResult;

/**
 * @author lzb
 * 2019/12/10
 */
public interface OrderService {
    DataTablesResult getGoodsList(int draw, int start, int length, String search, String orderCol, String orderDir);

    int count();

    int fahuo(int orderId,int logisticsId);
}
