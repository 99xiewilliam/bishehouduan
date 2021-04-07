package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.common.RetResult;
import com.cad.demo.entity.xieweihaoEntity.Query;
import com.cad.demo.service.xieweihaoService.PaperInfoService;
import com.cad.demo.xieweihaoPojo.PaperInfo;
import com.cad.demo.xieweihaoPojo.Reference;
import com.cad.demo.service.xieweihaoService.ReferenceService;
import com.cad.demo.xieweihaoPojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/reference")
public class ReferenceController {
    @Autowired
    private ReferenceService referenceService;
    @Autowired
    private PaperInfoService paperInfoService;

    //获取所有文献
    @GetMapping(value = "/PaperAll")
    public List<Reference> getReferenceAll(){
        return referenceService.getReferenceListAll();
    }
    @GetMapping(value = "/Paper")
    //获取所有文献部分信息
    public List<PaperInfo> getPaperInfo() {
        return paperInfoService.getPaperInfo(referenceService);
    }
    // 获取最新文献列表 或 搜索文献列表
    @PostMapping(value = "/get")
    public List<Reference> getReference(@RequestBody Query query){
        String category = query.getCategory();
        String word = query.getContent();
        return referenceService.getReferenceList(category, word);
    }

    //获取查询的文献内容
    @PostMapping(value = "/getOnePaper")
    public Reference getOnePaper(@RequestBody String id){
        String new_id = id.substring(0, id.length() - 1);
        System.out.print(new_id);
        return referenceService.getReference(new_id);
    }

    // 获取文献详情
    @PostMapping(value = "/detail")
    public List<Reference> referenceDetail(@RequestBody Query query){
        String word = query.getContent();
        return referenceService.referenceDetail(word);
    }

    //修改标注信息
    @PutMapping(value = "/modify")
    public int modifyInfo(@RequestBody Request id) {
        String new_id = id.getId();
        int judge = referenceService.ModifyInfo(new_id);
        return judge;
    }




}
