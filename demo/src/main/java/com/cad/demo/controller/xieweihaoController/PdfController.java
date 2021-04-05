package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.PdfService;
import com.cad.demo.xieweihaoPojo.Pdf;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @PostMapping(value = "/getPdf")
    public void getPdfData(@RequestBody @Validated Pdf pdf, HttpServletResponse response) throws IOException {
        System.out.println(pdf.getId());
        String id = pdf.getId();
        //id = "606ae579cdb2ca093653a88d";
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
        //打开流下载对象
        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, downloadStream);
        InputStream inputStream = gridFsResource.getInputStream();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] buff = new byte[100];
//        int rc = 0;
//        while ((rc = inputStream.read(buff, 0, 100)) > 0) {
//            byteArrayOutputStream.write(buff, 0, rc);
//        }
        OutputStream outputStream = response.getOutputStream();
        int b = 0;
        while ((b = inputStream.read()) != -1){
            outputStream.write(b);
        }

        outputStream.close();
        inputStream.close();
    }
}
