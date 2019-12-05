package xyz.lzbin.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.lzbin.shop.dao.StoreOwnerMapper;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    StoreOwnerMapper storeOwnerMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void storeOwnerTest() {
//        StoreOwner storeOwner = StoreOwner.StoreOwnerBuilder.newBuilder()
//                .nickname("lzb1")
//                .gender("男")
//                .name("lzb1")
//                .createTime(new Date())
//                .username("lzb1")
//                .builder();
//        storeOwnerMapper.insertSelective(storeOwner);
    }
}
