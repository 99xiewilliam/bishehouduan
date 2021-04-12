package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.common.RetResult;
import com.cad.demo.entity.xieweihaoEntity.Query;
import com.cad.demo.service.xieweihaoService.PaperInfoService;
import com.cad.demo.xieweihaoPojo.*;
import com.cad.demo.service.xieweihaoService.ReferenceService;
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
    @GetMapping(value = "/BookAll")
    public List<Book> getBookAll(){
        return referenceService.getBookListAll();
    }
    @GetMapping(value = "/GuideAll")
    public List<Guide> getGuideAll(){
        return referenceService.getGuideListAll();
    }
    @GetMapping(value = "/DrugInstructionsAll")
    public List<DrugInstructions> getDrugInstructionsAll(){
        return referenceService.getDrugInstructionsListAll();
    }
    @GetMapping(value = "/DiagnosisReportAll")
    public List<DiagnosisReport> getDiagnosisReportAll(){
        return referenceService.getDiagnosisReportListAll();
    }
    @GetMapping(value = "/Paper")
    //获取所有文献部分信息
    public List<PaperInfo> getPaperInfo() {
        return paperInfoService.getPaperInfo(referenceService);
    }
    @GetMapping(value = "/Book")
    public List<PaperInfo> getBookInfo() {
        return paperInfoService.getBookInfo(referenceService);
    }
    @GetMapping(value = "/Guide")
    public List<PaperInfo> getGuideInfo() {
        return paperInfoService.getGuideInfo(referenceService);
    }
    @GetMapping(value = "/DrugInstructions")
    public List<PaperInfo> getDrugInstructionsInfo() {
        return paperInfoService.getDrugInstructionsInfo(referenceService);
    }
    @GetMapping(value = "/DiagnosisReport")
    public List<PaperInfo> getDiagnosisReportInfo() {
        return paperInfoService.getDiagnosisReportInfo(referenceService);
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

    @PostMapping(value = "/getOneBook")
    public Book getOneBook(@RequestBody String id){
        String new_id = id.substring(0, id.length() - 1);
        System.out.print(new_id);
        return referenceService.getBook(new_id);
    }

    @PostMapping(value = "/getOneGuide")
    public Guide getOneGuide(@RequestBody String id){
        String new_id = id.substring(0, id.length() - 1);
        System.out.print(new_id);
        return referenceService.getGuide(new_id);
    }

    @PostMapping(value = "/getOneDrugInstructions")
    public DrugInstructions getOneDrugInstructions(@RequestBody String id){
        String new_id = id.substring(0, id.length() - 1);
        System.out.print(new_id);
        return referenceService.getDrugInstructions(new_id);
    }

    @PostMapping(value = "/getOneDiagnosisReport")
    public DiagnosisReport getOneDiagnosisReport(@RequestBody String id){
        String new_id = id.substring(0, id.length() - 1);
        System.out.print(new_id);
        return referenceService.getDiagnosisReport(new_id);
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
        String category = id.getCategory();
        int judge = referenceService.ModifyInfo(new_id, category);
        return judge;
    }



}
