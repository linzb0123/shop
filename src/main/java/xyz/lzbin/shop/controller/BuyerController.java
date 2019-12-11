package xyz.lzbin.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.BuyerService;

/**
 * @author lzb
 * 2019/12/10
 */
@RequestMapping("/buyer")
@Controller
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult geGameList(int draw, int start, int length, String searchKey,
                                       @RequestParam("search[value]") String search,
                                       @RequestParam("order[0][column]") int orderCol,
                                       @RequestParam("order[0][dir]") String orderDir) {

        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "nickname", "name", "gender", "tel", "username", "status", "id_card", "create_time"};
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
        DataTablesResult result = buyerService.getBuyerList(draw, start, length, searchKey, orderColumn, orderDir);
        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public ResultInfo count(){
        int c = buyerService.count();
        return ResultInfo.success().data("count",c);
    }


    @PostMapping("/lock")
    @ResponseBody
    public ResultInfo lock(int id){
        buyerService.changeStatus(id,(short)1);
        return ResultInfo.success();
    }

    @PostMapping("/unlock")
    @ResponseBody
    public ResultInfo unlock(int id){
        buyerService.changeStatus(id,(short)0);
        return ResultInfo.success();
    }

}
