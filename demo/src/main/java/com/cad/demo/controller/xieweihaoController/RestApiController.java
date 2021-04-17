package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.RestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Action;

@CrossOrigin
@RestController
@RequestMapping(value = "/Nodes")
public class RestApiController {

    @Autowired
    private RestApiService restApiService;
    @GetMapping(value = "/getNodes")
    public String getNodes() {
        return restApiService.getNodes();
    }
}
