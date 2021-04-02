package com.cad.demo.controller.xieweihaoController;
import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.OcrDataService;
import com.cad.demo.xieweihaoPojo.OcrData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/OcrData")
public class OcrDataController {
    @Autowired
    private OcrDataService ocrDataService;

    @PostMapping("/insertData")
    public RetResult addOcrData(@RequestBody @Validated OcrData ocrData) {
        int judge = 0;
        judge = ocrDataService.InsertOcrData(ocrData);
        if (judge == 0) {
            return new RetResult(500, "添加失败");
        }
        return new RetResult(0, "添加成功");
    }
}
