package xyz.lzbin.shop.service;

import xyz.lzbin.shop.result.DataTablesResult;

/**
 * @author lzb
 * 2019/12/10
 */
public interface BuyerService {
    DataTablesResult getBuyerList(int draw, int start, int length, String search, String orderCol, String orderDir);

    int count();

    void changeStatus(int id, short status);
}
