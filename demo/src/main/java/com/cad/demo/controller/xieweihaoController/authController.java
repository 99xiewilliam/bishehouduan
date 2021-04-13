package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.service.xieweihaoService.authService;
import com.cad.demo.xieweihaoPojo.Token;
import com.cad.demo.xieweihaoPojo.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth")
public class authController {

    @Autowired
    private authService authService;
    @PostMapping(value = "/getAuth")
    public Token getAuthAll(@RequestBody @Validated auth auth) {
        String username = auth.getUsername();
        String password = auth.getPassword();
        Token token = authService.getAuthAll(username, password);
        return token;
    }
}
