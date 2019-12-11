package xyz.lzbin.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lzbin.shop.pojo.Address;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.AddressService;

/**
 * @author lzb
 * 2019/12/11
 */
@RequestMapping("/address")
@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping("/getAddr/{id}")
    @ResponseBody
    public ResultInfo count(@PathVariable int id) {
        Address addr = addressService.getAddress(id);
        return ResultInfo.success().data("addr", addr);
    }


}
