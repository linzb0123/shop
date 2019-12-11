package xyz.lzbin.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lzbin.shop.pojo.GoodsItem;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.GoodsService;

/**
 * @author lzb
 * 2019/12/9
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(int draw, int start, int length, String searchKey,
                                       @RequestParam("search[value]") String search,
                                       @RequestParam("order[0][column]") int orderCol,
                                       @RequestParam("order[0][dir]") String orderDir) {

        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "title", "img_url", "type","price", "stock", "status", "status_time", "sort"};
        String orderColumn = cols[orderCol];
        //默认排序列
        if (orderColumn == null) {
            orderColumn = "sort";
        }
        //获取排序方式 默认为desc(asc)

        if (orderDir == null) {
            orderDir = "desc";
        }
        if (searchKey == null) {
            searchKey = "";
        }
        DataTablesResult result = goodsService.getGoodsList(draw, start, length, searchKey, orderColumn, orderDir);
        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public ResultInfo count() {
        int c = goodsService.count();
        return ResultInfo.success().data("count", c);
    }

    @PostMapping("/remove/{id}")
    @ResponseBody
    public ResultInfo delete(@PathVariable int id) {
        if (goodsService.delete(id)) {
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }


    @PostMapping("/create")
    @ResponseBody
    public ResultInfo create(GoodsItem goodsItem) {
        goodsService.create(goodsItem);
        return ResultInfo.success();
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResultInfo edit(GoodsItem goodsItem) {
        goodsService.edit(goodsItem);
        return ResultInfo.success();
    }

    @PostMapping("/up")
    @ResponseBody
    public ResultInfo up(int id) {
        goodsService.changeStatus(id, (short) 1);
        return ResultInfo.success();
    }

    @PostMapping("/down")
    @ResponseBody
    public ResultInfo down(int id) {
        goodsService.changeStatus(id, (short) 0);
        return ResultInfo.success();
    }

    @PostMapping("/getTypeList")
    @ResponseBody
    public ResultInfo getTypeList(int id) {
        goodsService.changeStatus(id, (short) 0);
        return ResultInfo.success();
    }
}
