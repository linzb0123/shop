package xyz.lzbin.shop.service;

import xyz.lzbin.shop.pojo.Type;
import xyz.lzbin.shop.result.DataTablesResult;

import java.util.List;

/**
 * @author lzb
 * 2019/12/10
 */
public interface TypeService {
    List<Type> getTypeList();

    DataTablesResult getList(int draw, int start, int length, String search, String orderCol, String orderDir);

    int count();

    boolean delete(int id);

    Type create(Type type);

    Type edit(Type type);
}
