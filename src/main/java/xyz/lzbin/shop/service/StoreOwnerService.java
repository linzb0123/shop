package xyz.lzbin.shop.service;

import xyz.lzbin.shop.pojo.StoreOwner;
import xyz.lzbin.shop.result.DataTablesResult;

/**
 * @author lzb
 * 2019/12/4
 */
public interface StoreOwnerService {
    DataTablesResult getStoreOwnerList(int draw, int start, int length, String search, String orderCol, String orderDir);

    StoreOwner create(StoreOwner owner);

    StoreOwner edit(StoreOwner owner);

    int count();

    boolean delete(int id);

    void changeStatus(int id, short status);

    void changeRealStatus(int id, short realStatus);
}
