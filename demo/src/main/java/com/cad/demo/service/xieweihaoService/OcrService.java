package com.cad.demo.service.xieweihaoService;

import org.springframework.stereotype.Service;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

@Service
public class OcrService{
    //识别图片具体代码
    public String readArticle(File img, String lan) throws TesseractException{
        String orcResult = null;
        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath("D:/Tesseract-OCR/tessdata");
        iTesseract.setLanguage(lan);
        //File img = new File(img_path);
        orcResult = iTesseract.doOCR(img);
        return orcResult;
    }



}
