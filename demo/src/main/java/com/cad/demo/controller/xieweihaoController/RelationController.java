package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.entity.xieweihaoEntity.Query;
import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.RelationService;
import com.cad.demo.xieweihaoPojo.Entity;
import com.cad.demo.xieweihaoPojo.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Service;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Relations")
public class RelationController {
    @Autowired
    private RelationService relationService;

    // 获取关系类型数据

    @GetMapping(value = "/relation")
    public List<Relation> getEntities(){
        return relationService.getEntities();
    }
}
