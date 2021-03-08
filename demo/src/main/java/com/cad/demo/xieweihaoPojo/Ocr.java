package com.cad.demo.xieweihaoPojo;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OcrFile")
public class Ocr {
    private String language;
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
