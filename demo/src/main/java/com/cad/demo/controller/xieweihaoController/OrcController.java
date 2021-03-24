package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.OcrService;
import com.cad.demo.xieweihaoPojo.Ocr;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

@CrossOrigin
@RestController
@RequestMapping(value = "/Upload")
public class OrcController {
    @Autowired
    private OcrService orcService;

    private String languadge = "chi_sim";
    //识别图片
    @PostMapping("/addOcrFile")
    public String addOcrFile(@RequestParam("img1") MultipartFile img1) throws TesseractException, IOException {
        System.out.println(img1);
        String filePath = "C:/Users/27256/Desktop/img/" + img1.getOriginalFilename();
        InputStream ins = null;
        File img = null;
        ins = img1.getInputStream();
        img = new File(img1.getOriginalFilename());
        inputStreamToFile(ins, img);
        ins.close();

//        File img = new File(filePath);
//        if (!img.exists()) {
//            try {
//                img.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        String article = orcService.readArticle(img, languadge);
        if (article != null) {
            System.out.println(article);
            return article;
        }else {
            return "false";
        }
    }

    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置识别图片的语言（中文，英文）
    @PostMapping("/setLanguage")
    public RetResult setLanguage(@RequestBody @Validated Ocr ocr) {
        int judge = 1;
        System.out.println(ocr.getLanguage());
        try {
            languadge = "chi_sim";
            if (ocr.getLanguage().equals("English")){
                languadge = "eng";
            }
        }catch (Exception e) {
            System.out.println(e);
            judge = 0;
        }

        if(judge == 1){
            return new RetResult(0, "添加成功");

        }
        return new RetResult(500, "添加失败");

    }

}
