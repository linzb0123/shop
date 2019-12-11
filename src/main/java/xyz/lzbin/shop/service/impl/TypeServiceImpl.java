package xyz.lzbin.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lzbin.shop.dao.GoodsItemMapper;
import xyz.lzbin.shop.dao.TypeMapper;
import xyz.lzbin.shop.exception.ResultBodyException;
import xyz.lzbin.shop.pojo.GoodsItem;
import xyz.lzbin.shop.pojo.GoodsItemExample;
import xyz.lzbin.shop.pojo.Type;
import xyz.lzbin.shop.pojo.TypeExample;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.service.TypeService;

import java.util.List;

/**
 * @author lzb
 * 2019/12/10
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper mapper;

    @Autowired
    private GoodsItemMapper goodsItemMapper;


    @Override
    public List<Type> getTypeList() {
        return mapper.selectByExample(new TypeExample());
    }

    @Override
    public DataTablesResult getList(int draw, int start, int length, String search, String orderCol, String orderDir) {
        DataTablesResult result = new DataTablesResult();
        try {
            PageHelper.startPage(start / length + 1, length);
            List<Type> list = mapper.selectTypeList("%" + search + "%", orderCol, orderDir);
            PageInfo<Type> pageInfo = new PageInfo<>(list);
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
        return mapper.countByExample(new TypeExample());
    }

    @Override
    public boolean delete(int id) {
        int count = mapper.deleteByPrimaryKey(id);
        return count > 0;
    }

    @Override
    public Type create(Type type) {
        try {
            mapper.insertSelective(type);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }
        return type;
    }

    @Override
    @Transactional
    public Type edit(Type type) {
        try {
            Type old = mapper.selectByPrimaryKey(type.getId());
            String oldName = old.getName();
            mapper.updateByPrimaryKeySelective(type);
            GoodsItemExample goodsItemExample = new GoodsItemExample();
            GoodsItemExample.Criteria  criteria = goodsItemExample.createCriteria();
            criteria.andCategoryEqualTo(oldName);
            GoodsItem goodsItem = new GoodsItem();
            goodsItem.setCategory(type.getName());
            goodsItemMapper.updateByExampleSelective(goodsItem,goodsItemExample);
        } catch (Exception e) {
            throw new ResultBodyException(e.getMessage());
        }
        return type;
    }


}
