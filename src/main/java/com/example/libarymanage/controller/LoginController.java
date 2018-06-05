package com.example.libarymanage.controller;

import com.example.libarymanage.entity.BookAdmin;
import com.example.libarymanage.entity.SystemAdmin;
import com.example.libarymanage.entity.User;
import com.example.libarymanage.service.BookAdminService;
import com.example.libarymanage.service.SystemAdminService;
import com.example.libarymanage.service.UserService;
import com.example.libarymanage.utils.JSONResult;
import com.example.libarymanage.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final BookAdminService bookAdminService;
    private final SystemAdminService systemAdminService;

    @Autowired
    public LoginController(UserService userService, BookAdminService bookAdminService, SystemAdminService systemAdminService) {
        this.userService = userService;
        this.bookAdminService = bookAdminService;
        this.systemAdminService = systemAdminService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/judge")
    public JSONResult judge(@RequestBody @Valid Map input) {
        JSONResult jsonResult = new JSONResult<>();
        User user;
        BookAdmin bookAdmin;
        SystemAdmin systemAdmin;
        PasswordUtil passwordUtil = new PasswordUtil();
        String name = input.get("name").toString();
        String password = input.get("password").toString();
        Boolean status = false;
        int error = 1;    // 0为账号错误
        switch (input.get("type").toString()){
            case "user":
                user = userService.selectByUserNumber(name);
                if (user != null){
                    status = passwordUtil.verify(password, user.getPassword());
                } else {
                    error = 0;
                    jsonResult.setMessage("账号错误！");
                }
                break;
            case "bookAdmin":
                bookAdmin = bookAdminService.selectByAdName(name);
                if (bookAdmin != null){
                    status = passwordUtil.verify(password, bookAdmin.getAdPassword());
                } else {
                    error = 0;
                    jsonResult.setMessage("账号错误！");
                }
                break;
            case "systemAdmin":
                systemAdmin = systemAdminService.selectByAdminName(name);
                if (systemAdmin != null){
                    status = passwordUtil.verify(password, systemAdmin.getAdminPassword());
                } else {
                    error = 0;
                    jsonResult.setMessage("账号错误！");
                }
                break;
                default: jsonResult.setMessage("登录方式错误！");
        }
        if(status){
            jsonResult.setMessage("登录成功！");
        } else if (error == 1){
            jsonResult.setMessage("密码错误！");
        }
        jsonResult.setStatus(status);
        return jsonResult;
    }
}
