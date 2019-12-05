package xyz.lzbin.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lzbin.shop.pojo.StoreOwner;
import xyz.lzbin.shop.pojo.StoreOwnerExample;

public interface StoreOwnerMapper {
    int countByExample(StoreOwnerExample example);

    int deleteByExample(StoreOwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreOwner record);

    int insertSelective(StoreOwner record);

    List<StoreOwner> selectByExample(StoreOwnerExample example);

    StoreOwner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreOwner record, @Param("example") StoreOwnerExample example);

    int updateByExample(@Param("record") StoreOwner record, @Param("example") StoreOwnerExample example);

    int updateByPrimaryKeySelective(StoreOwner record);

    int updateByPrimaryKey(StoreOwner record);

    List<StoreOwner> selectOwnerList(@Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir,@Param("start") int start,@Param("length") int length);
}