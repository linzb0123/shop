package xyz.lzbin.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.AddressMapper;
import xyz.lzbin.shop.pojo.Address;
import xyz.lzbin.shop.service.AddressService;

/**
 * @author lzb
 * 2019/12/11
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper mapper;

    @Override
    public Address getAddress(int id) {
        Address address = mapper.selectByPrimaryKey(id);
        return address;
    }

}
