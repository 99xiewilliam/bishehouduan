package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.common.RetResult;
import com.cad.demo.xieweihaoPojo.Item;
import com.cad.demo.service.xieweihaoService.ItemService;
import com.cad.demo.xieweihaoPojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    //获取所有项目任务
    @GetMapping(value = "/getAll")
    public List<Item> getReferenceAll(){
        return itemService.getReferenceListAll();
    }
    //插入新任务
    @PostMapping(value = "/addItem")
    public RetResult addUser(@RequestBody @Validated Item item) {
        int judge = itemService.addItem(item);
        if (judge == 0) {
            return new RetResult(500, "添加失败");
        }
        return new RetResult(0, "添加成功");

    }

    //更新时间
    @PutMapping(value = "/updateTime")
    public int UpdateTime(@RequestBody @Validated Request request) {
        String name = request.getName();
        String time = request.getTime();
        return itemService.updateTime(time, name);
    }


}
