package xyz.lzbin.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lzbin.shop.pojo.Logistics;
import xyz.lzbin.shop.pojo.OrderItem;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.LogisticsService;
import xyz.lzbin.shop.service.OrderService;

import javax.xml.ws.handler.LogicalHandler;

/**
 * @author lzb
 * 2019/12/10
 */
@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private LogisticsService logisticsService;


    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(int draw, int start, int length, String searchKey,
                                    @RequestParam("search[value]") String search,
                                    @RequestParam("order[0][column]") int orderCol,
                                    @RequestParam("order[0][dir]") String orderDir) {

        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "name", "total_price", "create_time", "status", "pay_time"};
        String orderColumn = cols[orderCol];
        //默认排序列
        if (orderColumn == null) {
            orderColumn = "id";
        }
        //获取排序方式 默认为desc(asc)

        if (orderDir == null) {
            orderDir = "desc";
        }
        if (searchKey == null) {
            searchKey = "";
        }
        DataTablesResult result = orderService.getGoodsList(draw, start, length, searchKey, orderColumn, orderDir);
        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public ResultInfo count() {
        int c = orderService.count();
        return ResultInfo.success().data("count", c);
    }

    @PostMapping("/fahuo/{orderId}")
    @ResponseBody
    public ResultInfo fahuo(@PathVariable(value = "orderId") int id, Logistics logistics) {

        logistics = logisticsService.create(logistics);

        int c = orderService.fahuo(id,logistics.getId());
        return ResultInfo.success();
    }
}
