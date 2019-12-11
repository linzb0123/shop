package xyz.lzbin.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.LogisticsMapper;
import xyz.lzbin.shop.pojo.Logistics;
import xyz.lzbin.shop.service.LogisticsService;

/**
 * @author lzb
 * 2019/12/11
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private LogisticsMapper mapper;

    @Override
    public Logistics create(Logistics logistics){
        mapper.insertSelective(logistics);
        return logistics;
    }
}
