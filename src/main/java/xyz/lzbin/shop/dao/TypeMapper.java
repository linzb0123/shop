package xyz.lzbin.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lzbin.shop.pojo.Type;
import xyz.lzbin.shop.pojo.TypeExample;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> selectTypeList(@Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);
}