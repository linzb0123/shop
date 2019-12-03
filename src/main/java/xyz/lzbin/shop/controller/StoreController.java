package xyz.lzbin.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lzbin.shop.service.StoreService;

/**
 * @author lzb
 * 2019/12/3
 */
@Controller
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreService storeService;

    @ResponseBody
    @RequestMapping("/getStore")
    public String getStore() {

        return storeService.getStoreById(1).getInfo();
    }

}
