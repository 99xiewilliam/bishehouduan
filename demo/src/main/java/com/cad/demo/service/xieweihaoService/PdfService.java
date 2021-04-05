package com.cad.demo.service.xieweihaoService;

import com.baidu.hugegraph.structure.Task;
import com.cad.demo.xieweihaoPojo.Pdf;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfService {
    @Autowired
    GridFsTemplate gridFsTemplate;



//    @Autowired
//    private GridFsOperations operations;
    public List<Pdf> getPdf() throws IOException {
        List<Pdf> res = new ArrayList<Pdf>();
        MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
        DB db = mongoClient.getDB("Hypertension");
        GridFS gridFS = new GridFS(db);

//        Query query = new Query();
//        GridFSFindIterable result = gridFsTemplate.find(query);
//        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
//        for(GridFSFile fs : result){
//            GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(fs.getObjectId());
//            GridFsResource gridFsResource = new GridFsResource(fs, gridFSDownloadStream);
//            InputStream is = gridFsResource.getInputStream();
//            byte[] bytes =  IOUtils.toByteArray(gridFsResource.getInputStream());
//        }

        List<GridFSDBFile> grids = getByFileName(gridFS);
        for(GridFSDBFile grid : grids) {
            Pdf pdf = new Pdf();
            //grid.writeTo(new File("/Users/xiexiaohao/Desktop/test/1.pdf"));
            //pdf.setBase64();
           // File file = new File(grid.getFilename());
            //grid.writeTo(file);
//            OutputStream sos = response.getOutputStream();
//            response.addHeader("Content-Disposition", "attachment; filename=\""	+ grid.getFilename() + "\"");
//            grid.writeTo(sos);
//            sos.flush();
//            sos.close();

            pdf.setName(grid.getFilename());
            InputStream is = grid.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int rc = 0;
            while((rc = is.read(bytes, 0, 1024)) > 0) {
                byteArrayOutputStream.write(bytes, 0, 100);
            }

            BASE64Encoder encoder = new BASE64Encoder();
            //String base64 = encoder.encode(bytes);
            pdf.setBase64(byteArrayOutputStream.toByteArray());
            res.add(pdf);
        }
        return res;
    }
    public static List<GridFSDBFile> getByFileName(GridFS gridFS){
        DBObject query  = new BasicDBObject();
        List<GridFSDBFile> res = gridFS.find(query);
        return res;
    }
}
