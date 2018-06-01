package com.example.libarymanage.controller;

import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.testService;
import com.example.libarymanage.utils.JSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Component
@Controller
@RequestMapping("/")
public class HomeController {

    private final testService ddd;

    @Autowired
    public HomeController(testService ddd) {
        this.ddd = ddd;
    }

    @ApiOperation(value = "列表获取", notes = "获取列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<User>> jsonResult = new JSONResult<>();
        jsonResult.setData(ddd.test());
        return jsonResult;
    }
}
