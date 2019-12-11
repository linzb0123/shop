package xyz.lzbin.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.BuyerMapper;
import xyz.lzbin.shop.exception.ResultBodyException;
import xyz.lzbin.shop.pojo.Buyer;
import xyz.lzbin.shop.pojo.BuyerExample;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.service.BuyerService;

import java.util.List;

/**
 * @author lzb
 * 2019/12/10
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public DataTablesResult getBuyerList(int draw, int start, int length, String search, String orderCol, String orderDir) {
        DataTablesResult result = new DataTablesResult();
        try {
            PageHelper.startPage(start / length + 1, length);
            List<Buyer> list = buyerMapper.selectBuyerList("%" + search + "%", orderCol, orderDir);
            PageInfo<Buyer> pageInfo = new PageInfo<>(list);
            result.setRecordsFiltered((int) pageInfo.getTotal());
            result.setRecordsTotal(buyerMapper.countByExample(new BuyerExample()));
            result.setDraw(draw);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int count() {
        return buyerMapper.countByExample(new BuyerExample());
    }

    @Override
    public void changeStatus(int id, short status) {
        try {
            Buyer buyer = new Buyer();
            buyer.setId(id);
            buyer.setStatus(status);
            buyerMapper.updateByPrimaryKeySelective(buyer);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }

    }
}
