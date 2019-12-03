package xyz.lzbin.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.StoreMapper;
import xyz.lzbin.shop.pojo.Store;
import xyz.lzbin.shop.service.StoreService;

/**
 * @author lzb
 * 2019/12/3
 */
@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Store getStoreById(int storeId) {
        Store store = storeMapper.selectByPrimaryKey(1);
        System.out.println("123");
        return store;
    }
}
