package com.cad.demo.service.xieweihaoService;

import com.cad.demo.dao.RestApiDAO;
import com.cad.demo.xieweihaoPojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApiService {

    @Autowired
    private RestApiDAO restApiDAO;

    public String setNodes(Request request) {
        String jsonStr;
        jsonStr = "{ " + "\"label\":" + "\"" + request.getLabel() + "\"" + ",\"properties\""+ ":{" + request.getDescription() + "}" + " }";
        System.out.println(jsonStr);
        return restApiDAO.setNodes(request, jsonStr);
    }
}
