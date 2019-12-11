package xyz.lzbin.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lzbin.shop.pojo.Buyer;
import xyz.lzbin.shop.pojo.BuyerExample;

public interface BuyerMapper {
    int countByExample(BuyerExample example);

    int deleteByExample(BuyerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    List<Buyer> selectByExample(BuyerExample example);

    Buyer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Buyer record, @Param("example") BuyerExample example);

    int updateByExample(@Param("record") Buyer record, @Param("example") BuyerExample example);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);

    List<Buyer> selectBuyerList(@Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);
}