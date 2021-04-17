package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.RestApiService;
import com.cad.demo.xieweihaoPojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Action;

@CrossOrigin
@RestController
@RequestMapping(value = "/Nodes")
public class RestApiController {

    @Autowired
    private RestApiService restApiService;
    @PutMapping(value = "/setNodes")
    public String setNodes(@RequestBody @Validated Request request) {
        return restApiService.setNodes(request);
    }
}
