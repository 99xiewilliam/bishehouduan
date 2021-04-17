package com.cad.demo.service.xieweihaoService;

import com.cad.demo.dao.RestApiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApiService {

    @Autowired
    private RestApiDAO restApiDAO;

    public String getNodes() {
        return restApiDAO.getNodes();
    }
}
