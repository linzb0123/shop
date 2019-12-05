package xyz.lzbin.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lzbin.shop.pojo.OrderGoodsItem;
import xyz.lzbin.shop.pojo.OrderGoodsItemExample;

public interface OrderGoodsItemMapper {
    int countByExample(OrderGoodsItemExample example);

    int deleteByExample(OrderGoodsItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoodsItem record);

    int insertSelective(OrderGoodsItem record);

    List<OrderGoodsItem> selectByExample(OrderGoodsItemExample example);

    OrderGoodsItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderGoodsItem record, @Param("example") OrderGoodsItemExample example);

    int updateByExample(@Param("record") OrderGoodsItem record, @Param("example") OrderGoodsItemExample example);

    int updateByPrimaryKeySelective(OrderGoodsItem record);

    int updateByPrimaryKey(OrderGoodsItem record);
}