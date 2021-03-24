package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.ExpertInputService;
import com.cad.demo.xieweihaoPojo.ExpertInput;
import com.cad.demo.xieweihaoPojo.FileMark;
import com.cad.demo.xieweihaoPojo.Relation_marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/ExpertInput")

//专家录入
public class ExpertInputController {

    @Autowired
    private ExpertInputService expertInputSerivice;
    @PostMapping("/addExpertInput")
    public RetResult addFileMark(@RequestBody @Validated ExpertInput expertInput) {
        int judge = expertInputSerivice.addExpertInput(expertInput);
        if(judge == 1){
            return new RetResult(0, "添加成功");

        }
        return new RetResult(500, "添加失败");
    }

    @GetMapping("/getFileMark")
    public List<ExpertInput> getFileMark(){
        return expertInputSerivice.getExpertInputAll();
    }
}
