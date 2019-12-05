package xyz.lzbin.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.StoreOwnerMapper;
import xyz.lzbin.shop.exception.ResultBodyException;
import xyz.lzbin.shop.pojo.StoreOwner;
import xyz.lzbin.shop.pojo.StoreOwnerExample;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.service.StoreOwnerService;

import java.util.Date;
import java.util.List;

/**
 * @author lzb
 * 2019/12/4
 */
@Service
public class StoreOwnerServiceImpl implements StoreOwnerService {
    private static final Logger logger = LoggerFactory.getLogger(StoreOwnerServiceImpl.class);

    @Autowired
    private StoreOwnerMapper ownerMapper;

    @Override
    public DataTablesResult getStoreOwnerList(int draw, int start, int length, String search, String orderCol, String orderDir) {
        DataTablesResult result = new DataTablesResult();
        try {
            PageHelper.startPage(start / length + 1, length);
            List<StoreOwner> list = ownerMapper.selectOwnerList("%" + search + "%", orderCol, orderDir, start, length);
            PageInfo<StoreOwner> pageInfo = new PageInfo<>(list);
            result.setRecordsFiltered((int) pageInfo.getTotal());
            result.setRecordsTotal(ownerMapper.countByExample(new StoreOwnerExample()));
            result.setDraw(draw);
            result.setData(list);
        } catch (Exception e) {
//            System.out.println("load StoreOwner data fail");
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public StoreOwner create(StoreOwner owner){
        try{
            owner.setCreateTime(new Date());
            ownerMapper.insertSelective(owner);
        }catch (Exception e){
            throw new ResultBodyException(e.getMessage());
        }
        return owner;
    }
    @Override
    public StoreOwner edit(StoreOwner owner){
        try{
            ownerMapper.updateByPrimaryKeySelective(owner);
        }catch (Exception e){
            throw new ResultBodyException(e.getMessage());
        }
        return owner;
    }
    @Override
    public int count() {
        return ownerMapper.countByExample(new StoreOwnerExample());
    }

    @Override
    public boolean delete(int id) {
        int count = ownerMapper.deleteByPrimaryKey(id);
        return count > 0;
    }

    @Override
    public void changeStatus(int id, short status) {
        try {
            StoreOwner owner = new StoreOwner();
            owner.setId(id);
            owner.setStatus(status);
            ownerMapper.updateByPrimaryKeySelective(owner);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }

    }

    @Override
    public void changeRealStatus(int id, short realStatus) {
        try {
            StoreOwner owner = new StoreOwner();
            owner.setId(id);
            owner.setRealStatus(realStatus);
            ownerMapper.updateByPrimaryKeySelective(owner);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }

    }
}
