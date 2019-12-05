package xyz.lzbin.shop.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lzbin.shop.pojo.StoreOwner;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.StoreOwnerService;

/**
 * @author lzb
 * 2019/12/4
 */
@RequestMapping("/owner")
@Controller
public class StoreOwnerController {
    private static final Logger logger = LoggerFactory.getLogger(StoreOwnerController.class);

    @Autowired
    private StoreOwnerService storeOwnerService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult geGameList(int draw, int start, int length, String searchKey,
                                       @RequestParam("search[value]") String search,
                                       @RequestParam("order[0][column]") int orderCol,
                                       @RequestParam("order[0][dir]") String orderDir) {

        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "nickname", "name", "gender", "tel", "username", "status", "real_status", "id_card", "create_time"};
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
        DataTablesResult result = storeOwnerService.getStoreOwnerList(draw, start, length, searchKey, orderColumn, orderDir);
        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public ResultInfo count(){
        int c = storeOwnerService.count();
        return ResultInfo.success().data("count",c);
    }

    @PostMapping("/remove/{id}")
    @ResponseBody
    public ResultInfo delete(@PathVariable int id){
        if(storeOwnerService.delete(id)){
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResultInfo create(StoreOwner owner){
        storeOwnerService.create(owner);
        return ResultInfo.success();
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResultInfo edit(StoreOwner owner){
        storeOwnerService.edit(owner);
        return ResultInfo.success();
    }

    @PostMapping("/lock")
    @ResponseBody
    public ResultInfo lock(int id){
        storeOwnerService.changeStatus(id,(short)1);
        return ResultInfo.success();
    }

    @PostMapping("/unlock")
    @ResponseBody
    public ResultInfo unlock(int id){
        storeOwnerService.changeStatus(id,(short)0);
        return ResultInfo.success();
    }

    @PostMapping("/real")
    @ResponseBody
    public ResultInfo real(int id){
        storeOwnerService.changeRealStatus(id,(short)1);
        return ResultInfo.success();
    }

    @PostMapping("/unreal")
    @ResponseBody
    public ResultInfo unreal(int id){
        storeOwnerService.changeRealStatus(id,(short)0);
        return ResultInfo.success();
    }

}
