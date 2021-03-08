
package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.entity.xieweihaoEntity.Query;
import com.cad.demo.xieweihaoPojo.Reference;
import com.cad.demo.service.xieweihaoService.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/test")
public class testController  {
    @Autowired
    private ReferenceService referenceService;

    //获取所有文献
    @GetMapping(value = "/getAll")
    public List<Reference> getReferenceAll(){
        return referenceService.getReferenceListAll();
    }
    // 获取最新文献列表 或 搜索文献列表
    @PostMapping(value = "/get")
    public List<Reference> getReference(@RequestBody Query query){
        String category = query.getCategory();
        String word = query.getContent();
        return referenceService.getReferenceList(category, word);
    }

    // 获取文献详情
    @PostMapping(value = "/detail")
    public List<Reference> referenceDetail(@RequestBody Query query){
        String word = query.getContent();
        return referenceService.referenceDetail(word);
    }
}
