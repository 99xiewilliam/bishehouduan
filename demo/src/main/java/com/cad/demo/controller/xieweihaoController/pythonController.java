package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.pythonService;
import com.cad.demo.xieweihaoPojo.python;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/selenium")
public class pythonController {
    @Autowired
    private pythonService pythonService;

    @PostMapping(value = "startSelenium")
    public int startSelenium(@RequestBody @Validated python python) {
        String fileName = python.getFileName();
        String keyword = python.getKeyword();
        String pageTo = python.getPageTo();
        int judge = pythonService.startSelenium(keyword, fileName, pageTo);
        return judge;
    }
}
