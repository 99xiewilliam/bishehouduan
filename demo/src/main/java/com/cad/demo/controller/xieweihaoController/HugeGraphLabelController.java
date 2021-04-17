package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.HugeGraphLabelService;
import com.cad.demo.xieweihaoPojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/hugeNodes")
public class HugeGraphLabelController {

    @Autowired
    private HugeGraphLabelService hugeGraphLabelService;

    @PostMapping(value = "/getNodes")
    public List<Object> getNodes(@RequestBody @Validated Request request) {
        String category = request.getCategory();

        List<Object>res = hugeGraphLabelService.getNodes(category);

        return res;
    }
}
