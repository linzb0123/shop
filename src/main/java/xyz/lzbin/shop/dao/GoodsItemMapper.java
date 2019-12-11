package xyz.lzbin.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lzbin.shop.pojo.GoodsItem;
import xyz.lzbin.shop.pojo.GoodsItemExample;

public interface GoodsItemMapper {
    int countByExample(GoodsItemExample example);

    int deleteByExample(GoodsItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsItem record);

    int insertSelective(GoodsItem record);

    List<GoodsItem> selectByExample(GoodsItemExample example);

    GoodsItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsItem record, @Param("example") GoodsItemExample example);

    int updateByExample(@Param("record") GoodsItem record, @Param("example") GoodsItemExample example);

    int updateByPrimaryKeySelective(GoodsItem record);

    int updateByPrimaryKey(GoodsItem record);

    List<GoodsItem> selectGoodsList(@Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);
}