package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.entity.xieweihaoEntity.Query;
import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.EntityService;
import com.cad.demo.xieweihaoPojo.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Service;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Entities")
//实体类型
public class EntityController {
    @Autowired
    private EntityService entityService;

    // 获取实体类型数据

    @GetMapping(value = "/entity")
    public List<Entity> getEntities(){
        return entityService.getEntities();
    }
}
