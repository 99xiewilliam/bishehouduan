package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.FileMarkService;
import com.cad.demo.xieweihaoPojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/FileMarks")

//标注
public class FileMarkController {

    @Autowired
    private FileMarkService fileMarkService;
    //添加实体和关系标注
    @PostMapping("/addFileMark")
    public RetResult addFileMark(@RequestBody @Validated FileMark fileMark) {
        int judge = fileMarkService.addFileMark(fileMark);
        if(judge == 1){
            return new RetResult(0, "添加成功");

        }
        return new RetResult(500, "添加失败");
    }
    //获取标注数据
    @GetMapping("/getFileMark")
    public List<FileMark> getFileMark(){
        return fileMarkService.getFileMarkAll();
    }

    //更新object状态
    @PutMapping(value = "/updateEntityStatus")
    public int UpdateEntityStatus(@RequestBody @Validated EntityAudit entityAudit) {
        String id = entityAudit.getDocument_id();
        String object_type = entityAudit.getObject_type();
        String name = entityAudit.getName();
        boolean status = entityAudit.isStatus();
        String check_user_id = entityAudit.getCheck_user_id();
        System.out.println(check_user_id);
        return fileMarkService.updateEntityStatus(id, object_type, name, status, check_user_id);
    }

    @PutMapping(value = "/updateRelationStatus")
    public int UpdateRelationStatus(@RequestBody @Validated RelationAudit relationAudit) {
        String id = relationAudit.getDocument_id();
        String start_type = relationAudit.getStart_type();
        String relation_type = relationAudit.getRelation_type();
        String end_type = relationAudit.getEnd_type();
        String start_object = relationAudit.getStart_object();
        String end_object = relationAudit.getEnd_object();
        boolean status = relationAudit.isStatus();
        String check_user_id = relationAudit.getCheck_user_id();
        return fileMarkService.updateRelationStatus(id, start_type, relation_type, end_type, start_object, end_object, status, check_user_id);
    }
}
