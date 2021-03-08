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

public class FileMarkController {

    @Autowired
    private FileMarkService fileMarkService;
    @PostMapping("/addFileMark")
    public RetResult addFileMark(@RequestBody @Validated FileMark fileMark) {
        int judge = fileMarkService.addFileMark(fileMark);
        if(judge == 1){
            return new RetResult(0, "添加成功");

        }
        return new RetResult(500, "添加失败");
    }

    @GetMapping("/getFileMark")
    public List<FileMark> getFileMark(){
        return fileMarkService.getFileMarkAll();
    }
}
