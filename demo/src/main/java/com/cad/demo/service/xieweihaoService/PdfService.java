package com.cad.demo.service.xieweihaoService;

import com.baidu.hugegraph.structure.Task;
import com.cad.demo.xieweihaoPojo.Pdf;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;

import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfService {
    @Autowired
    GridFsTemplate gridFsTemplate;


    public List<Pdf> getPdf(){
        List<Pdf> res = new ArrayList<Pdf>();
        Query query = new Query();
        GridFSFindIterable gridFSFile = gridFsTemplate.find(query);
        for(GridFSFile file : gridFSFile) {
            Pdf pdf = new Pdf();
            pdf.setName(file.getFilename());
            String id = file.getId().toString();
            pdf.setId(id);
            res.add(pdf);
        }
        return res;
    }

    public int getPdfNum(){
        int count = 0;
        Query query = new Query();
        GridFSFindIterable gridFSFile = gridFsTemplate.find(query);
        for(GridFSFile file : gridFSFile) {
            count = count + 1;
        }
        return count;
    }

    public static List<GridFSDBFile> getByFileName(GridFS gridFS){
        DBObject query  = new BasicDBObject();
        List<GridFSDBFile> res = gridFS.find(query);
        return res;
    }
}
