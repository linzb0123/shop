package xyz.lzbin.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lzbin.shop.dao.OrderItemMapper;
import xyz.lzbin.shop.exception.ResultBodyException;
import xyz.lzbin.shop.pojo.OrderItem;
import xyz.lzbin.shop.pojo.OrderItemExample;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.service.OrderService;

import java.util.List;

/**
 * @author lzb
 * 2019/12/10
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemMapper orderMapper;

    @Override
    public DataTablesResult getGoodsList(int draw, int start, int length, String search, String orderCol, String orderDir) {
        DataTablesResult result = new DataTablesResult();
        try {
            PageHelper.startPage(start / length + 1, length);
            List<OrderItem> list = orderMapper.selectOrderList("%" + search + "%", orderCol, orderDir);
            PageInfo<OrderItem> pageInfo = new PageInfo<>(list);
            result.setRecordsFiltered((int) pageInfo.getTotal());
            result.setRecordsTotal(count());
            result.setDraw(draw);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int count() {
        return orderMapper.countByExample(new OrderItemExample());
    }

    @Override
    public int fahuo(int orderId, int logisticsId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderId);
        orderItem.setLogisticsId(logisticsId);
        try{
            return orderMapper.updateByPrimaryKeySelective(orderItem);

        }catch (Exception e){
            throw new ResultBodyException(e.getMessage());
        }
    }

}
