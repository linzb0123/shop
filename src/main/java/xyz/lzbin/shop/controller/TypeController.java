package xyz.lzbin.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lzbin.shop.pojo.Type;
import xyz.lzbin.shop.result.DataTablesResult;
import xyz.lzbin.shop.result.ResultInfo;
import xyz.lzbin.shop.service.TypeService;

import java.util.List;

/**
 * @author lzb
 * 2019/12/10
 */
@RequestMapping("/type")
@Controller
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping("/getTypeList")
    @ResponseBody
    public ResultInfo getTypeList() {
        List<Type> list = service.getTypeList();
        return ResultInfo.success().data("list", list);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(int draw, int start, int length, String searchKey,
                                    @RequestParam("search[value]") String search,
                                    @RequestParam("order[0][column]") int orderCol,
                                    @RequestParam("order[0][dir]") String orderDir) {

        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "name"};
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
        DataTablesResult result = service.getList(draw, start, length, searchKey, orderColumn, orderDir);
        return result;
    }

    @GetMapping("/count")
    @ResponseBody
    public ResultInfo count() {
        int c = service.count();
        return ResultInfo.success().data("count", c);
    }


    @PostMapping("/remove/{id}")
    @ResponseBody
    public ResultInfo delete(@PathVariable int id) {
        if (service.delete(id)) {
            return ResultInfo.success();
        }
        return ResultInfo.fail();
    }


    @PostMapping("/create")
    @ResponseBody
    public ResultInfo create(Type type) {
        service.create(type);
        return ResultInfo.success();
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResultInfo edit(Type type) {
        service.edit(type);
        return ResultInfo.success();
    }

}
