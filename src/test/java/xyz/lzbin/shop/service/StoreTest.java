package xyz.lzbin.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.lzbin.shop.dao.StoreMapper;
import xyz.lzbin.shop.pojo.Store;

import java.util.Date;

/**
 * @author lzb
 * 2019/12/4
 */
@SpringBootTest
public class StoreTest {

    @Autowired
    private StoreMapper storeMapper;

    @Test
    public void insertTest() {
        Store store = new Store();
        store.setId(1);
        store.setCreateTime(new Date());
        store.setName("Bin");
        store.setOwnerId(1);
        storeMapper.insert(store);
    }

}
