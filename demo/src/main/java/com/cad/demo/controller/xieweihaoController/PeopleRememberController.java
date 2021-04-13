package com.cad.demo.controller.xieweihaoController;

import com.cad.demo.common.RetResult;
import com.cad.demo.service.xieweihaoService.PeopleRememberService;
import com.cad.demo.xieweihaoPojo.PeopleRemember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/Visit")
public class PeopleRememberController {
    @Autowired
    private PeopleRememberService peopleRememberService;

    @GetMapping(value = "/getPeople")
    public int getPeople() {
        int count = peopleRememberService.CountVisited();
        return count;
    }

    @PostMapping(value = "/insertPeople")
    public RetResult insertPeople(@RequestBody @Validated PeopleRemember peopleRemember) {
        int judge = peopleRememberService.insertVisited(peopleRemember);
        if (judge == 0) {
            return new RetResult(500, "添加失败");
        }
        return new RetResult(0, "添加成功");
    }
}
