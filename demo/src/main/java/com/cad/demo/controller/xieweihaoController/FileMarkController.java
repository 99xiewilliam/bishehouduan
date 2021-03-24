package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.FileMarkService;
import com.cad.demo.xieweihaoPojo.FileMark;
import com.cad.demo.xieweihaoPojo.Relation_marks;
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
}
